package com.codegym.service.impl;

import com.codegym.entity.User;
import com.codegym.repository.UserSignUpRepository;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserSignUpRepository userSignUpRepository;

    @Override
    public List<User> findAll() {
        return this.userSignUpRepository.findAll();
    }

    @Override
    public String save(User user) {
        List<User> userList = findAll();
        boolean check = true;
        String warning = null;
        for (User userExist : userList) {
            if (user.getEmail().equals(userExist.getEmail())) {
                check = false;
                warning = "Email is Exist ! Please sign up email other !";
                break;
            }
        }
        if (check) {
            this.userSignUpRepository.save(user);
            warning = "Sign up complete !";
        }
        return warning;
    }
}
