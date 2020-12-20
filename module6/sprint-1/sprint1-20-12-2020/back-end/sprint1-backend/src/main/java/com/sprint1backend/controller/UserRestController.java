package com.sprint1backend.controller;

import com.sprint1backend.entity.AppUser;
import com.sprint1backend.model.UserUpdateDTO;
import com.sprint1backend.service.account.AccountUserService;
import com.sprint1backend.service.user.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserRestController {
    @Autowired
    AppUserService appUserService;
    @Autowired
    AccountUserService accountUserService;

    @GetMapping()
    public ResponseEntity<List<AppUser>> getAppUserList() {
        List<AppUser> appUserList = appUserService.findAppUserAll();
        if (appUserList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else
        return new ResponseEntity<>(appUserList, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<AppUser> getAppUserByID(@PathVariable Long id) {
        AppUser appUser = this.appUserService.findAppUserById(id);
        if (appUser ==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(appUser, HttpStatus.OK);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") long id,@RequestBody UserUpdateDTO userUpdateDTO) {
        AppUser appUser = appUserService.findAppUserById(id);
        if (appUser == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        appUser.setFullName(userUpdateDTO.getFullName());
        appUser.setBirthday(userUpdateDTO.getBirthday());
        appUser.setAddress(userUpdateDTO.getAddress());
        appUser.setEmail(userUpdateDTO.getEmail());
        appUser.setPhoneNumber(userUpdateDTO.getPhoneNumber());
//        appUser1.setGender(userUpdateDTO.getGender());

        appUserService.save(appUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @PatchMapping("/{id}/change-password")


    }

