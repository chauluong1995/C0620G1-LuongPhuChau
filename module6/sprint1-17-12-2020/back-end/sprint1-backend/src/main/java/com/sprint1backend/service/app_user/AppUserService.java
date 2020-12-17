package com.sprint1backend.service.app_user;

import com.sprint1backend.entity.AppUser;

import java.util.List;

public interface AppUserService {
    AppUser findAppUserByEmail(String email);

    List<AppUser> findAllAppUser();
}
