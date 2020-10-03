package dao.employee;

import dao.BaseDAO;
import model.Employee;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDAOImpl implements EmployeeDAO {
    private BaseDAO baseDAO = new BaseDAO();
    private static final String CREATE_NEW_EMPLOYEE = "insert into employee values(null,?,?,?,?,?,?,?,?,?,?,?)";
//    private static final String CREATE_NEW_EMPLOYEE = "insert into employee values (employee_name = ?, " +
//            "employee_birthday = ?, employee_id_card = ?, employee_salary = ?, employee_phone = ?" +
//            "employee_email = ?, employee_address = ?, position_id = ?, education_degree_id = ?," +
//            "division_id = ?, user_name = ?)";

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
}
