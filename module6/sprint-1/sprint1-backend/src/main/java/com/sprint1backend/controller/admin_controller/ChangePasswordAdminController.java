package com.sprint1backend.controller.admin_controller;

import com.sprint1backend.entity.AppAccount;
import com.sprint1backend.model.ChangePasswordAdminDTO;
import com.sprint1backend.model.MessageDTO;
import com.sprint1backend.service.change_password_admin.ChangePasswordAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/changePassword")
public class ChangePasswordAdminController {
    @Autowired
    private ChangePasswordAdminService changePasswordAdminService;

    @Autowired
    private PasswordEncoder encoder;


    @GetMapping("/findById/{id}")
    public ResponseEntity<AppAccount> getAccountById(@PathVariable Long id) {
        AppAccount appAccount = this.changePasswordAdminService.findById(id);
        return new ResponseEntity<>(appAccount, HttpStatus.OK);
    }

    @GetMapping("/findAppAccountByUsername/{username}")
    public ResponseEntity<AppAccount> getAccountByUsername(@PathVariable String username) {
        AppAccount appAccount = this.changePasswordAdminService.findAppAccountByUsername(username);
        return new ResponseEntity<>(appAccount, HttpStatus.OK);

    }

    @PutMapping("/saveAppAccount/{username}")
    public ResponseEntity<?> getAccountByUsername(@RequestBody ChangePasswordAdminDTO changePasswordAdminDTO,
                                                  @PathVariable String username) {
        AppAccount appAccount = this.changePasswordAdminService.findAppAccountByUsername(username);
        boolean isMatch = encoder.matches(changePasswordAdminDTO.getPasswordOld(), appAccount.getPassword());
        if (isMatch) {
            appAccount.setPassword(encoder.encode(changePasswordAdminDTO.getPassword()));
            this.changePasswordAdminService.save(appAccount);
            return ResponseEntity.ok(new MessageDTO("Password changed"));
        } else {
            return ResponseEntity.ok(new MessageDTO("Wrong password"));
        }
    }
}
