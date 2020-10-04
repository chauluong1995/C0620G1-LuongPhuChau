package bo.employee;

import dao.employee.EmployeeDAO;
import dao.employee.EmployeeDAOImpl;
import model.employee.*;

import java.util.List;

public class EmployeeBOImpl implements EmployeeBO {
    EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    public String saveEmployee(Employee employee) {
        String message;
        message = this.employeeDAO.saveEmployee(employee);
        return message;
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeDAO.findAll();
    }

    @Override
    public Employee findEmployeeById(String id) {
        return this.employeeDAO.findEmployeeById(id);
    }

    @Override
    public List<Position> findAllPosition() {
        return this.employeeDAO.findAllPosition();
    }

    @Override
    public List<Division> findAllDivision() {
        return this.employeeDAO.findAllDivision();
    }

    @Override
    public List<EducationDegree> findAllEducationDegree() {
        return this.employeeDAO.findAllEducationDegree();
    }

    @Override
    public List<User> findAllUser() {
        return this.employeeDAO.findAllUser();
    }

    @Override
    public List<Employee> findByName(String name) {
        return this.employeeDAO.findByName(name);
    }

    @Override
    public String updateEmployee(Employee employee) {
        String message;
        message = this.employeeDAO.updateEmployee(employee);
        return message;
    }

    @Override
    public void deleteEmployee(String id) {
        this.employeeDAO.deleteEmployee(id);
    }
}
