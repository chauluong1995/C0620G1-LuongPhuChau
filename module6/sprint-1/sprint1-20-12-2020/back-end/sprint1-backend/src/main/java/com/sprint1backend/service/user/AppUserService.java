package com.sprint1backend.service.user;

import com.sprint1backend.entity.AppUser;

import java.util.List;

public interface AppUserService {
    List<AppUser> findAppUserAll();

    AppUser findAppUserById(Long id);

    void save(AppUser appUser);

    AppUser findAppUserByEmail(String email);

    List<AppUser> testEmailOfAppUser(String emailInput);
}
