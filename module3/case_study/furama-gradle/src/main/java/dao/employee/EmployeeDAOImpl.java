package dao.employee;

import dao.BaseDAO;
import model.Customer;
import model.Employee;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private BaseDAO baseDAO = new BaseDAO();
    private static final String CREATE_NEW_EMPLOYEE = "insert into employee values(null,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SELECT_ALL_EMPLOYEE = "select employee_name, employee_salary, employee_phone, employee_email, " +
            "employee_address from employee";

    @Override
    public String saveEmployee(Employee employee) {
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(CREATE_NEW_EMPLOYEE);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getBirthDay());
            preparedStatement.setString(3, employee.getIdCard());
            preparedStatement.setString(4, employee.getSalary());
            preparedStatement.setString(5, employee.getPhone());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getAddress());
            preparedStatement.setString(8, employee.getIdPosition());
            preparedStatement.setString(9, employee.getIdEducationDegree());
            preparedStatement.setString(10, employee.getIdDivision());
            preparedStatement.setString(11, employee.getUserName());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "Create Complete !";
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_EMPLOYEE);
            ResultSet resultSet = preparedStatement.executeQuery();
            Employee employee;
            while (resultSet.next()) {
                String name = resultSet.getString("employee_name");
                String salary = resultSet.getString("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");

                employee = new Employee(name, salary, phone, email, address);
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public List<Employee> findByName(String name) {
        List<Employee> employeeListResult = new ArrayList<>();
        List<Employee> employeeList = findAll();

        for (Employee employee : employeeList) {
            if (employee.getName().contains(name)) {
                employeeListResult.add(employee);
            }
        }

        return employeeListResult;
    }

    @Override
    public String updateEmployee(Employee employee) {
        try {
            CallableStatement callableStatement = this.baseDAO.getConnection().prepareCall("call update_employee(?,?,?,?,?,?,?,?,?,?,?,?)");
            callableStatement.setString(1, employee.getId());
            callableStatement.setString(2, employee.getName());
            callableStatement.setString(3, employee.getBirthDay());
            callableStatement.setString(4, employee.getIdCard());
            callableStatement.setString(5, employee.getSalary());
            callableStatement.setString(6, employee.getPhone());
            callableStatement.setString(7, employee.getEmail());
            callableStatement.setString(8, employee.getAddress());
            callableStatement.setString(9, employee.getIdPosition());
            callableStatement.setString(10, employee.getIdEducationDegree());
            callableStatement.setString(11, employee.getIdDivision());
            callableStatement.setString(12, employee.getUserName());

            callableStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "Update Complete !";
    }

    @Override
    public void deleteEmployee(String idNeedDelete) {
        try {
            CallableStatement callableStatement = this.baseDAO.getConnection().prepareCall("call delete_employee(?)");
            callableStatement.setString(1, idNeedDelete);
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
