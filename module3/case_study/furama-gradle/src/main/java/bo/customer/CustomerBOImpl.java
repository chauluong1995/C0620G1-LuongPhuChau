package bo.customer;

import common.Validation;
import dao.customer.CustomerDAO;
import dao.customer.CustomerDAOImpl;
import model.customer.Customer;
import model.customer.TypeCustomer;

import java.util.List;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO = new CustomerDAOImpl();

    @Override
    public List<Customer> findAll() {
        return this.customerDAO.findAll();
    }

    @Override
    public List<TypeCustomer> findAllTypeCustomer() {
        return this.customerDAO.findAllTypeCustomer();
    }

    @Override
    public List<Customer> findByName(String name) {
        return this.customerDAO.findByName(name);
    }

    @Override
    public String saveCustomer(Customer customer) {
        String message;

        if (!Validation.regexIDCustomer(customer.getId())) {
            message = "Format ID is KH-XXXX with X is number from 0 to 9 !";
        } else if (testID(customer.getId())) {
            message = "ID is exists ! Please input ID other !";
        } else message = this.customerDAO.saveCustomer(customer);

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

    private boolean testID(String id) {
        List<Customer> customerList = findAll();
        for (Customer customer : customerList){
            if (customer.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
