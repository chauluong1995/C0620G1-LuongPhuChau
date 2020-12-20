package com.sprint1backend.service.account;

import com.sprint1backend.entity.AppUser;
import com.sprint1backend.model.AppUserDTO;
import com.sprint1backend.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;

@Service
public class AppUserService {
    @Autowired
    AppUserRepository appUserRepository;

    public AppUser convertAppUserDTO(AppUserDTO appUser) {
        AppUser newAppUser = new AppUser();
        newAppUser.setFullName(appUser.getFullName());
        newAppUser.setBirthday(appUser.getBirthday());
        newAppUser.setAddress(appUser.getAddress());
        newAppUser.setEmail(appUser.getEmail());
        newAppUser.setGender(appUser.getGender());
        newAppUser.setPhoneNumber(appUser.getPhoneNumber());
        return newAppUser;
    }




}
