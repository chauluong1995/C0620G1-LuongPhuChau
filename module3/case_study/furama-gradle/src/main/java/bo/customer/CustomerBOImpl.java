package bo.customer;

import dao.customer.CustomerDAO;
import dao.customer.CustomerDAOImpl;
import model.Customer;

import java.util.List;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO = new CustomerDAOImpl();

    @Override
    public List<Customer> findAll() {
        return this.customerDAO.findAll();
    }

    @Override
    public List<Customer> findByName(String name) {
        return this.customerDAO.findByName(name);
    }

    @Override
    public String saveCustomer(Customer customer) {
        String message;
        message = this.customerDAO.saveCustomer(customer);
        return message;
    }

    @Override
    public Customer findCustomerById(String id) {
        return this.customerDAO.findCustomerById(id);
    }

    @Override
    public void deleteCustomer(String id) {
        this.customerDAO.deleteCustomer(id);
    }

    @Override
    public String updateCustomer(Customer customer) {
        String message;
        message = this.customerDAO.updateCustomer(customer);
        return message;
    }
}
