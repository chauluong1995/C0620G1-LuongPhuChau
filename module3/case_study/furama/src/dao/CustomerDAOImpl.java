package dao;

import model.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    private BaseDAO baseDAO = new BaseDAO();
    private static final String SELECT_ALL_CUSTOMERS = "select customer_id, customer_name, customer_birthday, customer_gender, customer_email, " +
            "customer_address from customer";
    private static final String CREATE_NEW_CUSTOMER = "insert into customer values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    @Override
    public List<Customer> findAll() {
        List<Customer> studentList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_CUSTOMERS);
            ResultSet resultSet = preparedStatement.executeQuery();
            Customer customer;
            while (resultSet.next()) {
//                String id = String.valueOf(resultSet.getInt("customer_id"));
                String id = resultSet.getString("customer_id");
                String name = resultSet.getString("customer_name");
                String birthDay = resultSet.getString("customer_birthday");
                String gender = resultSet.getString("customer_gender");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");

                customer = new Customer(id, name, birthDay, gender, email, address);
                studentList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public String save(Customer customer) {
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(CREATE_NEW_CUSTOMER);
            preparedStatement.setString(1, customer.getId());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getBirthDay());
            preparedStatement.setString(4, customer.getGender());
            preparedStatement.setString(5, customer.getIdCard());
            preparedStatement.setString(6, customer.getPhoneNumber());
            preparedStatement.setString(7, customer.getEmail());
            preparedStatement.setString(8, customer.getAddress());
            preparedStatement.setString(9, customer.getTypeCustomer());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "Create Complete !";
    }

    @Override
    public void update(int id, Customer customer) {

    }

    @Override
    public void remove(int id) {

    }
}
