package controller;

import model.customer.CustomerServlet;
import model.employee.EmployeeServlet;
import model.service.ServiceServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FuramaServlet", urlPatterns = {"", "/furama"})
public class FuramaServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionFurama = request.getParameter("actionFurama");
        if (actionFurama == null) {
            actionFurama = "";
        }
        switch (actionFurama) {
            case "createNewCustomer":
                CustomerServlet.createNewCustomer(request, response);
                break;
            case "createNewService":
                ServiceServlet.createNewService(request, response);
                break;
            case "createNewEmployee":
                EmployeeServlet.createNewEmployee(request, response);
                break;
//            case "deleteCustomer":
//                CustomerServlet.deleteCustomer(request, response);
//                break;
            case "editCustomer":
                CustomerServlet.updateCustomer(request, response);
                break;
            case "editEmployee":
                EmployeeServlet.updateEmployee(request, response);
                break;
            case "searchCustomer":
                CustomerServlet.searchCustomer(request, response);
                break;
            case "searchEmployee":
                EmployeeServlet.searchEmployee(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionFurama = request.getParameter("actionFurama");
        if (actionFurama == null) {
            actionFurama = "";
        }
        switch (actionFurama) {
            case "customerList":
                CustomerServlet.customerTable(request, response);
                break;
            case "employeeList":
                EmployeeServlet.employeeTable(request, response);
                break;
            case "showCreateNewCustomer":
                CustomerServlet.showCreateNewCustomer(request, response);
                break;
//            case "showDeleteCustomer":
//                CustomerServlet.showDeleteCustomer(request, response);
//                break;
            case "deleteCustomer":
                CustomerServlet.deleteCustomer(request, response);
                break;
            case "deleteEmployee":
                EmployeeServlet.deleteEmployee(request, response);
                break;
            case "showEditCustomer":
                CustomerServlet.showEditCustomer(request, response);
                break;
            case "showEditEmployee":
                EmployeeServlet.showEditEmployee(request, response);
                break;
            case "addNewService":
                ServiceServlet.addNewService(request, response);
                break;
            case "showCreateNewEmployee":
                EmployeeServlet.showCreateNewEmployee(request, response);
                break;
            default:
                home(request, response);
        }
    }

    private void home(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("view/home.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}