package bo.service;

import common.Validation;
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

        if (!Validation.regexIDService(service.getId())) {
            message = "Format ID is DV-XXXX with X is number from 0 to 9 !";
        } else if (testID(service.getId())) {
            message = "ID is exists ! Please input ID other !";
        } else message = this.serviceDAO.saveService(service);

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

    private boolean testID(String id) {
        List<String> listID = this.serviceDAO.findAllIDService();
        for (String idExist : listID){
            if (idExist.equals(id)) {
                return true;
            }
        }
        return false;
    }
}
