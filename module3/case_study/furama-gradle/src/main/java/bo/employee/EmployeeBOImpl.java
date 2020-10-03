package bo.employee;

import dao.employee.EmployeeDAO;
import dao.employee.EmployeeDAOImpl;
import model.Employee;

public class EmployeeBOImpl implements EmployeeBO {
    EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    public String saveEmployee(Employee employee) {
        String message;
        message = this.employeeDAO.saveEmployee(employee);
        return message;
    }
}
