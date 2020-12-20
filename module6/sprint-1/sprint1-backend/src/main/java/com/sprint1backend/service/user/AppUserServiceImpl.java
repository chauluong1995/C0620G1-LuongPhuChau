package com.sprint1backend.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.sprint1backend.entity.AppUser;
import com.sprint1backend.repository.AppUserRepository;

@Service
public class AppUserServiceImpl implements AppUserService {
    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public List<AppUser> findAppUserAll() {
        return this.appUserRepository.findAll();
    }

    @Override
    public AppUser findAppUserById(Long id) {
        return this.appUserRepository.findById(id).orElse(null);
    }

    @Override
    public void save(AppUser appUser) {
        this.appUserRepository.save(appUser);
    }

    @Override
    public AppUser findAppUserByEmail(String email) {
        return this.appUserRepository.findByEmail(email);
    }

    @Override
    public List<AppUser> testEmailOfAppUser(String emailInput) {
        List<AppUser> appUserList = new ArrayList<>();
        AppUser appUser = this.appUserRepository.findByEmail(emailInput);
        if (appUser != null) {
            appUserList.add(appUser);
        }
        return appUserList;
    }
}



