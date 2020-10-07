package controller;

import bo.customer.CustomerBO;
import bo.customer.CustomerBOImpl;
import model.customer.Customer;
import model.customer.TypeCustomer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customer"})

public class CustomerServlet extends HttpServlet {
    private CustomerBO customerBO = new CustomerBOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String actionFurama = request.getParameter("actionFurama");
        if (actionFurama == null) {
            actionFurama = "";
        }
        switch (actionFurama) {
            case "createNewCustomer":
                createNewCustomer(request, response);
                break;
            case "searchCustomer":
                searchCustomer(request, response);
                break;
            case "editCustomer":
                updateCustomer(request, response);
                break;
//            case "deleteCustomer":
//                deleteCustomer(request, response);
//                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
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
            case "showEditCustomer":
                showEditCustomer(request, response);
                break;
            case "deleteCustomer":
                deleteCustomer(request, response);
                break;
//            case "showDeleteCustomer":
//                showDeleteCustomer(request, response);
//                break;
        }
    }

    private void customerTable(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = this.customerBO.findAll();
        request.setAttribute("customerList", customerList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/customer-list.jsp");
//        RequestDispatcher dispatcher = request.getRequestDispatcher("view/demo.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateNewCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<TypeCustomer> typeCustomers = this.customerBO.findAllTypeCustomer();
        request.setAttribute("typeCustomers", typeCustomers);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/create-new-customer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createNewCustomer(HttpServletRequest request, HttpServletResponse response) {
        Customer customer = informationCustomer(request);

        String message = this.customerBO.saveCustomer(customer);
        request.setAttribute("message", message);
        if (!message.equals("Create Complete !")) {
            request.setAttribute("customer", customer);
        }

        showCreateNewCustomer(request, response);
    }

//    private void showDeleteCustomer(HttpServletRequest request, HttpServletResponse response) {
//        String id = request.getParameter("id");
//        Customer customer = this.customerBO.findCustomerById(id);
//        RequestDispatcher dispatcher;
//        request.setAttribute("customer", customer);
//        dispatcher = request.getRequestDispatcher("view/delete-customer.jsp");
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException | IOException e) {
//            e.printStackTrace();
//        }
//    }

    private void showEditCustomer(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Customer customer = this.customerBO.findCustomerById(id);
        request.setAttribute("customer", customer);

        List<TypeCustomer> typeCustomers = this.customerBO.findAllTypeCustomer();
        request.setAttribute("typeCustomers", typeCustomers);

        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("view/customer/update-customer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        Customer customer = informationCustomer(request);
//        Customer customer = informationCustomerModal(request);

        String message = this.customerBO.updateCustomer(customer);
        request.setAttribute("message", message);
        if (!message.equals("Update Complete !")) {
            request.setAttribute("customer", customer);
            RequestDispatcher dispatcher;
            dispatcher = request.getRequestDispatcher("view/customer/update-customer.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        } else customerTable(request, response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("idCustomer");
        this.customerBO.deleteCustomer(id);

        customerTable(request, response);
    }

    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("nameCustomer");
        List<Customer> customerList = this.customerBO.findByName(name);
        request.setAttribute("customerList", customerList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/search-list-customer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private Customer informationCustomer(HttpServletRequest request) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String birthDay = request.getParameter("birthDay");
        String gender = request.getParameter("gender");
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        return new Customer(id, type, name, birthDay, gender, idCard, phone, email, address);
    }

    private Customer informationCustomerModal(HttpServletRequest request) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String birthDay = request.getParameter("birthDay");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        return new Customer(id, name, birthDay, gender, email, address);
    }
}
