package com.codegym.controllers.customer;

import com.codegym.entity.customer.Customer;
import com.codegym.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restCustomerController")
@CrossOrigin
public class CustomerRestController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public ResponseEntity<List<Customer>> getListCustomer() {
        List<Customer> listCustomer = this.customerService.findAll();
        return new ResponseEntity<>(listCustomer, HttpStatus.OK);
    }

    @GetMapping("/scroll")
    public ResponseEntity<List<Customer>> getListCustomerScroll(@RequestParam int start, int limit) {
        List<Customer> listCustomer = this.customerService.findAllScroll(start, limit);
        return new ResponseEntity<>(listCustomer, HttpStatus.OK);
    }

    @PostMapping("/search/{name}")
    public ResponseEntity<List<Customer>> getCustomer(@PathVariable String name) {
        List<Customer> listCustomer = this.customerService.findByNameContainingAjax(name);
        return new ResponseEntity<>(listCustomer, HttpStatus.OK);
    }
}
