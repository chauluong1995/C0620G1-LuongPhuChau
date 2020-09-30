package controller;

import bo.CustomerBO;
import bo.CustomerBOImpl;
import model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FuramaServlet", urlPatterns = {"", "/furama"})
public class FuramaServlet extends HttpServlet {
    CustomerBO customerBO = new CustomerBOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionFurama = request.getParameter("actionFurama");
        if (actionFurama == null) {
            actionFurama = "";
        }
        switch (actionFurama) {
            case "createNewCustomer":
                createNewCustomer(request, response);
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
                customerTable(request, response);
                break;
            case "showCreateNewCustomer":
                showCreateNewCustomer(request, response);
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

    private void customerTable(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = this.customerBO.findAll();
        request.setAttribute("customerList", customerList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer-list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateNewCustomer(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("view/create-new-customer.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createNewCustomer(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Customer customer = new Customer(id, type, name, birthday, gender, idCard, phone, email, address);

        String message = this.customerBO.save(customer);
        request.setAttribute("message", message);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/create-new-customer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
