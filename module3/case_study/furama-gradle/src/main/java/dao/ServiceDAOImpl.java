package dao;

import model.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ServiceDAOImpl implements ServiceDAO {
    private BaseDAO baseDAO = new BaseDAO();
    private static final String CREATE_NEW_SERVICE = "insert into service values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    @Override
    public String saveService(Service service) {
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(CREATE_NEW_SERVICE);
            preparedStatement.setString(1, service.getId());
            preparedStatement.setString(2, service.getName());
            preparedStatement.setString(3, service.getArea());
            preparedStatement.setString(4, service.getCost());
            preparedStatement.setString(5, service.getMaxPeople());
            preparedStatement.setString(6, service.getStandardRoom());
            preparedStatement.setString(7, service.getDescriptionOtherConvenience());
            preparedStatement.setString(8, service.getPoolArea());
            preparedStatement.setString(9, service.getNumberOfFloors());
            preparedStatement.setString(10, service.getRentTypeId());
            preparedStatement.setString(11, service.getServiceTypeId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "Create Complete !";
    }
}
