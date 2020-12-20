package com.sprint1backend.controller;

import com.sprint1backend.config.JwtTokenUtil;
import com.sprint1backend.model.*;
import com.sprint1backend.repository.AppAccountRepository;
import com.sprint1backend.service.account.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/*
Expose a POST API /authenticate using the JwtAuthenticationController. The POST API gets username and password in the
body- Using Spring Authentication Manager we authenticate the username and password.If the credentials are valid,
a JWT token is created using the JWTTokenUtil and provided to the client.
 */
@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    AppAccountRepository appAccountRepository;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @GetMapping("/hello")
    public ResponseEntity<?> hello() {
        return ResponseEntity.ok(new MessageDTO("Hello"));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody AccountDTO account, HttpServletRequest request) throws Exception {
        if (appAccountRepository.findByUsername(account.getUsername()) != null) {
            return ResponseEntity.ok(new MessageDTO("Email đã được đăng kí"));
        }

        String siteURL = request.getRequestURL().toString();
        return ResponseEntity.ok(userDetailsService.save(account, siteURL));
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        // check username exist
        if (appAccountRepository.findByUsername(authenticationRequest.getUsername()) == null) {
            return ResponseEntity.ok(new MessageDTO("Email chưa được đăng kí"));
        }

        // check if verification email is confirmed
        if (!appAccountRepository.findByUsername(authenticationRequest.getUsername()).getEnabled())
            return ResponseEntity.ok(new MessageDTO("Email chưa được kích hoạt"));

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

//        return ResponseEntity.ok(new JwtResponse(token));
        String username = authenticationRequest.getUsername();
        Long id = appAccountRepository.findByUsername(username).getId();

        return ResponseEntity.ok(new JwtResponseNew(id,username,token));
    }


    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @GetMapping("/register/verify")
    public ResponseEntity<?> verifyAccount(@RequestParam String code) {
        boolean verify = userDetailsService.verify(code);
        if (verify) {
            return ResponseEntity.ok(new MessageDTO("Verification Succeed!"));
        } else {
            return ResponseEntity.ok(new MessageDTO("Verification Fail"));
        }
    }
}
