package com.sprint1backend.service.account;

import com.sprint1backend.entity.AppAccount;

public interface AccountUserService {
    AppAccount findById(Long id);
    void changePassword(Long id, String password);
}
