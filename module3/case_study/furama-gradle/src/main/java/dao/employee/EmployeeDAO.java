package dao.employee;

import model.Employee;

import java.util.List;

public interface EmployeeDAO {
    String saveEmployee (Employee employee);

    List<Employee> findAll();

    List<Employee> findByName(String name);

    String updateEmployee(Employee employee);

    void deleteEmployee(String id);
}
