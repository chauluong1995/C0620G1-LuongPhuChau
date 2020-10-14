package com.login.service;

import com.login.entity.Login;
import com.login.entity.User;

public interface UserDao {
    User checkLogin(Login login);
}
