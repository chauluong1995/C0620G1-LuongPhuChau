package com.codegym.service;

import com.codegym.entity.Customer;
import com.codegym.entity.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findAllAndSortByID(Pageable pageable);

    Page<Customer> findAllAndSortByName(Pageable pageable);

    Page<Customer> findAllAndSortByBirthDay(Pageable pageable);

    Page<Customer> findByNameContaining(Pageable pageable, String name);

    Page<Customer> findByAddressContaining(Pageable pageable, String address);

    Page<Customer> findByNameAndAddressContaining(Pageable pageable, String name, String address);

    Page<Customer> findAllOfMe(Pageable pageable, String all);

    void deleteCustomer(String id);

    void save(Customer customer);

    List<CustomerType> allCustomerType();

    void update(Customer customer);
}
