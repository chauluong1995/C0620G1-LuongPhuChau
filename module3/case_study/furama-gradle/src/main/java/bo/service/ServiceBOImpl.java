package bo.service;

import dao.service.ServiceDAO;
import dao.service.ServiceDAOImpl;
import model.service.RentType;
import model.service.Service;
import model.service.ServiceType;

import java.util.List;

public class ServiceBOImpl implements ServiceBO {
    ServiceDAO serviceDAO = new ServiceDAOImpl();

    @Override
    public String saveService(Service service) {
        String message;
        message = this.serviceDAO.saveService(service);
        return message;
    }

    @Override
    public List<RentType> findAllRentType() {
        return this.serviceDAO.findAllRentType();
    }

    @Override
    public List<ServiceType> findAllServiceType() {
        return this.serviceDAO.findAllServiceType();
    }
}
