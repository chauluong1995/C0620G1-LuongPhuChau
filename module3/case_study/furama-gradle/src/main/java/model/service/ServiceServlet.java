package model.service;

import bo.service.ServiceBO;
import bo.service.ServiceBOImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ServiceServlet {
    private static ServiceBO serviceBO = new ServiceBOImpl();

    public static void addNewService(HttpServletRequest request, HttpServletResponse response) {
        List<RentType> rentTypes = serviceBO.findAllRentType();
        request.setAttribute("rentTypes", rentTypes);

        List<ServiceType> serviceTypes = serviceBO.findAllServiceType();
        request.setAttribute("serviceTypes", serviceTypes);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/create-new-service.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void createNewService(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String area = request.getParameter("area");
        String cost = request.getParameter("cost");
        String maxPeople = request.getParameter("maxPeople");
        String rentTypeId = request.getParameter("rentTypeId");
        String serviceTypeId = request.getParameter("serviceTypeId");
        String standardRoom = request.getParameter("standardRoom");
        String descriptionOtherConvenience = request.getParameter("descriptionOtherConvenience");
        String poolArea = request.getParameter("poolArea");
        String numberOfFloors = request.getParameter("numberOfFloors");

        Service service = new Service(id, name, area, cost, maxPeople, rentTypeId, serviceTypeId, standardRoom, descriptionOtherConvenience,
                poolArea, numberOfFloors);

        String message = serviceBO.saveService(service);
        request.setAttribute("message", message);

        addNewService(request, response);
    }
}
