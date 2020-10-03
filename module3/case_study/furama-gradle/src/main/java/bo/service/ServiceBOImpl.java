package bo.service;

import dao.service.ServiceDAO;
import dao.service.ServiceDAOImpl;
import model.Service;

public class ServiceBOImpl implements ServiceBO {
    ServiceDAO serviceDAO = new ServiceDAOImpl();

    @Override
    public String saveService(Service service) {
        String message;
        message = this.serviceDAO.saveService(service);
        return message;
    }
}
