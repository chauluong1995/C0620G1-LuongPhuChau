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
    public void update(int id, Customer customer) {

    }

    @Override
    public void remove(int id) {

    }
}
