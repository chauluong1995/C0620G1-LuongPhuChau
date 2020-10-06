package bo;

import model.Customer;
import model.TypeCustomer;

import java.util.List;

public interface CustomerBO {
    List<Customer> findAll();

    List<TypeCustomer> findAllTypeCustomer();

    List<Customer> findByName(String name);

    String saveCustomer(Customer customer);

    String updateCustomer(Customer customer);

    Customer findCustomerById(String id);

    void deleteCustomer(String id);
}
