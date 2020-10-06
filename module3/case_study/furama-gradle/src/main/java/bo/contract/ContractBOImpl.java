package bo.contract;

import common.Validation;
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

        if (Validation.regexPositiveNumbers(contract.getDeposite())) {
            message = "Invalid deposit ! Deposit must be a positive number !";
        } else if (Validation.regexPositiveNumbers(contract.getTotalMoney())) {
            message = "Invalid total money ! Total money must be a positive number !";
        } else message = this.contractDAO.saveContract(contract);

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
