package dao.customer;

import dao.BaseDAO;
import model.Customer;

import java.sql.CallableStatement;
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
        List<Customer> customerList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_CUSTOMERS);
            ResultSet resultSet = preparedStatement.executeQuery();
            Customer customer;
            while (resultSet.next()) {
                String id = resultSet.getString("customer_id");
                String name = resultSet.getString("customer_name");
                String birthDay = resultSet.getString("customer_birthday");
                String gender = resultSet.getString("customer_gender");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");

                customer = new Customer(id, name, birthDay, gender, email, address);
                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    @Override
    public String saveCustomer(Customer customer) {
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
    public Customer findCustomerById(String idNeedDelete) {
        Customer customer = null;
        try {
            CallableStatement callableStatement = this.baseDAO.getConnection().prepareCall("call find_customer_by_id(?)");
            callableStatement.setString(1, idNeedDelete);
            ResultSet resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("customer_id");
                String name = resultSet.getString("customer_name");
                String birthDay = resultSet.getString("customer_birthday");
                String gender = resultSet.getString("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String phoneNumber = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                String typeOfCustomer = resultSet.getString("customer_type_id");

                customer = new Customer(id, typeOfCustomer, name, birthDay, gender, idCard, phoneNumber, email, address);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public void deleteCustomer(String idNeedDelete) {
        try {
            CallableStatement callableStatement = this.baseDAO.getConnection().prepareCall("call delete_customer(?)");
            callableStatement.setString(1, idNeedDelete);
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String updateCustomer(Customer customer) {
        try {
            CallableStatement callableStatement = this.baseDAO.getConnection().prepareCall("call update_customer(?,?,?,?,?,?,?,?,?)");
            callableStatement.setString(1, customer.getId());
            callableStatement.setString(2, customer.getName());
            callableStatement.setString(3, customer.getBirthDay());
            callableStatement.setString(4, customer.getGender());
            callableStatement.setString(5, customer.getIdCard());
            callableStatement.setString(6, customer.getPhoneNumber());
            callableStatement.setString(7, customer.getEmail());
            callableStatement.setString(8, customer.getAddress());
            callableStatement.setString(9, customer.getTypeCustomer());

            callableStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "Update Complete !";
    }

    @Override
    public List<Customer> findByName(String name) {
        List<Customer> customerList = findAll();
        List<Customer> customerListResult = new ArrayList<>();

        for (Customer customer : customerList) {
            if (customer.getName().contains(name)) {
                customerListResult.add(customer);
            }
        }

        return customerListResult;
    }
}
