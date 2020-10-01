package dao;

import model.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> findAll();

    String save(Customer customer);

    Customer findCustomerById(String id);

    void deleteCustomer(String id);
}
