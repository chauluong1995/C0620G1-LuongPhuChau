package bo;

import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import model.Customer;

import java.util.List;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO = new CustomerDAOImpl();

    @Override
    public List<Customer> findAll() {
        return this.customerDAO.findAll();
    }

    @Override
    public String save(Customer customer) {
        String message;
        message = this.customerDAO.save(customer);
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
}
