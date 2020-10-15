package com.codegym.service;

import com.codegym.entity.Email;

public interface EmailService {
    Email create();

    Email update(Email email);
}
