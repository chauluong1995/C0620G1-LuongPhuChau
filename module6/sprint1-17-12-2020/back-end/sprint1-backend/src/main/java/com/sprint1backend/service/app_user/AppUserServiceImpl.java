package com.sprint1backend.service.app_user;

import com.sprint1backend.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.sprint1backend.entity.AppUser;

@Service
public class AppUserServiceImpl implements AppUserService {
    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public AppUser findAppUserByEmail(String email) {
        return this.appUserRepository.findByEmail(email);
    }

    @Override
    public List<AppUser> findAllAppUser() {
        return this.appUserRepository.findAll();
    }
}
