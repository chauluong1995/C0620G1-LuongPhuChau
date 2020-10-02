package bo;

import model.Customer;

import java.util.List;

public interface CustomerBO {
    List<Customer> findAll();

    List<Customer> findByName(String name);

    String saveCustomer(Customer customer);

    String updateCustomer(Customer customer);

    Customer findCustomerById(String id);

    void deleteCustomer(String id);
}
