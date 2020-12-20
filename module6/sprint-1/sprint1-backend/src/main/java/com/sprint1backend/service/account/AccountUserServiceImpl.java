package com.sprint1backend.service.account;

import com.sprint1backend.entity.AppAccount;
import com.sprint1backend.repository.AppAccountUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountUserServiceImpl implements AccountUserService {
    @Autowired
    private AppAccountUserRepository appAccountUserRepository;

    @Override
    public AppAccount findById(Long id) {
        return appAccountUserRepository.findById(id).orElse(null);
    }

    @Override
    public void changePassword(Long id, String password) {
        AppAccount appAccount = appAccountUserRepository.findById(id).orElse(null);
        if (appAccount != null) {
            appAccount.setPassword(password);
            appAccountUserRepository.save(appAccount);
        }
    }
}
