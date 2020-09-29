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

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionFurama = request.getParameter("actionFurama");
        if (actionFurama == null) {
            actionFurama = "";
        }
        switch (actionFurama) {
            case "customer" :
                customerTable(request, response);
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
}
