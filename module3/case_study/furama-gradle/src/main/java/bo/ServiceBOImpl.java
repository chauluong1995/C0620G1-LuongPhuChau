package bo;

import dao.ServiceDAO;
import dao.ServiceDAOImpl;
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
