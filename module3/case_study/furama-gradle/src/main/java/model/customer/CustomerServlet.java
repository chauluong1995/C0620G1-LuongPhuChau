package model.customer;

import bo.customer.CustomerBO;
import bo.customer.CustomerBOImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CustomerServlet {
    private static CustomerBO customerBO = new CustomerBOImpl();

    public static void customerTable(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = customerBO.findAll();
        request.setAttribute("customerList", customerList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/customer-list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void showCreateNewCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<TypeCustomer> typeCustomers = customerBO.findAllTypeCustomer();
        request.setAttribute("typeCustomers", typeCustomers);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/create-new-customer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void createNewCustomer(HttpServletRequest request, HttpServletResponse response) {
        Customer customer = informationCustomer(request);

        String message = customerBO.saveCustomer(customer);
        request.setAttribute("message", message);

        showCreateNewCustomer(request, response);
    }

//    public void showDeleteCustomer(HttpServletRequest request, HttpServletResponse response) {
//        String id = request.getParameter("id");
//        Customer customer = customerBO.findCustomerById(id);
//        RequestDispatcher dispatcher;
//        request.setAttribute("customer", customer);
//        dispatcher = request.getRequestDispatcher("view/delete-customer.jsp");
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException | IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static void showEditCustomer(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Customer customer = customerBO.findCustomerById(id);
        request.setAttribute("customer", customer);

        List<TypeCustomer> typeCustomers = customerBO.findAllTypeCustomer();
        request.setAttribute("typeCustomers", typeCustomers);

        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("view/customer/update-customer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("idCustomer");
        customerBO.deleteCustomer(id);

        customerTable(request, response);
    }

    public static void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        Customer customer = informationCustomer(request);

        String message = customerBO.updateCustomer(customer);
        request.setAttribute("message", message);

        customerTable(request, response);
    }

    public static void searchCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("nameCustomer");
        List<Customer> customerList = customerBO.findByName(name);
        request.setAttribute("customerList", customerList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/search-list-customer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private static Customer informationCustomer(HttpServletRequest request){
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
}
