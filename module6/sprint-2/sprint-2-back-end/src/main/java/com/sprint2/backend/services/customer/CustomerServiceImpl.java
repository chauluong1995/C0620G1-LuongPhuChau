package com.sprint2.backend.services.customer;

import com.sprint2.backend.entity.Customer;
import com.sprint2.backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return this.customerRepository.findAll();
    }

    @Override
    public Customer findByID(Long id) {
        return this.customerRepository.findById(id).orElse(null);
    }
}
