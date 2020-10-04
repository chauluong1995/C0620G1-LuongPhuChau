package bo.contract;

import dao.contract.ContractDAO;
import dao.contract.ContractDAOImpl;
import model.contract.Contract;
import model.customer.Customer;
import model.employee.Employee;
import model.service.Service;

import java.util.List;

public class ContractBOImpl implements ContractBO {
    ContractDAO contractDAO = new ContractDAOImpl();

    @Override
    public String saveContract(Contract contract) {
        String message;
        message = this.contractDAO.saveContract(contract);
        return message;
    }

    @Override
    public List<Employee> findAllEmployee() {
        return this.contractDAO.findAllEmployee();
    }

    @Override
    public List<Customer> findAllCustomer() {
        return this.contractDAO.findAllCustomer();
    }

    @Override
    public List<Service> findAllService() {
        return this.contractDAO.findAllService();
    }
}
