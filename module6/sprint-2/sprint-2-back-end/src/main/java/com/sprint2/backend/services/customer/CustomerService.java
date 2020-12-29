package com.sprint2.backend.services.customer;

import com.sprint2.backend.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findByID(Long id);
}
