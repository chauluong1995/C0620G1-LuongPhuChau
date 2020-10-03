package controller;

import bo.customer.CustomerBO;
import bo.customer.CustomerBOImpl;
import bo.employee.EmployeeBO;
import bo.employee.EmployeeBOImpl;
import bo.service.ServiceBO;
import bo.service.ServiceBOImpl;
import model.Customer;
import model.Employee;
import model.Service;

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
    ServiceBO serviceBO = new ServiceBOImpl();
    EmployeeBO employeeBO = new EmployeeBOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionFurama = request.getParameter("actionFurama");
        if (actionFurama == null) {
            actionFurama = "";
        }
        switch (actionFurama) {
            case "createNewCustomer":
                createNewCustomer(request, response);
                break;
            case "createNewService":
                createNewService(request, response);
                break;
            case "createNewEmployee":
                createNewEmployee(request, response);
                break;
//            case "deleteCustomer":
//                deleteCustomer(request, response);
//                break;
            case "editCustomer":
                updateCustomer(request, response);
                break;
            case "searchCustomer":
                searchCustomer(request, response);
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
            case "employeeList":
                employeeTable(request, response);
                break;
            case "showCreateNewCustomer":
                showCreateNewCustomer(request, response);
                break;
//            case "showDeleteCustomer":
//                showDeleteCustomer(request, response);
//                break;
            case "deleteCustomer":
                deleteCustomer(request, response);
                break;
            case "deleteEmployee":
                deleteEmployee(request, response);
                break;
            case "showEditCustomer":
                showEditCustomer(request, response);
                break;
            case "addNewService":
                addNewService(request, response);
                break;
            case "showCreateNewEmployee":
                showCreateNewEmployee(request, response);
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

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/customer-list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateNewCustomer(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("view/customer/create-new-customer.jsp");
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

        String message = this.customerBO.saveCustomer(customer);
        request.setAttribute("message", message);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/create-new-customer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
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
        RequestDispatcher dispatcher;
        request.setAttribute("customer", customer);
        dispatcher = request.getRequestDispatcher("view/customer/update-customer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("idCustomer");
        this.customerBO.deleteCustomer(id);

        customerTable(request, response);

//        List<Customer> customerList = this.customerBO.findAll();
//        request.setAttribute("customerList", customerList);
//
//        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer-list.jsp");
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException | IOException e) {
//            e.printStackTrace();
//        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
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

        String message = this.customerBO.updateCustomer(customer);
        request.setAttribute("message", message);

        this.customerTable(request, response);

//        List<Customer> customerList = this.customerBO.findAll();
//        request.setAttribute("customerList", customerList);
//
//        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/customer-list.jsp");
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException | IOException e) {
//            e.printStackTrace();
//        }
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

    private void addNewService(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("view/create-new-service.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createNewService(HttpServletRequest request, HttpServletResponse response) {
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

        String message = this.serviceBO.saveService(service);
        request.setAttribute("message", message);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/create-new-service.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void employeeTable(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = this.employeeBO.findAll();
        request.setAttribute("employeeList", employeeList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/employee-list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateNewEmployee(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("view/employee/create-new-employee.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createNewEmployee(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String birthDay = request.getParameter("birthDay");
        String idCard = request.getParameter("idCard");
        String salary = request.getParameter("salary");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String position = request.getParameter("position");
        String educationDegree = request.getParameter("educationDegree");
        String division = request.getParameter("division");
        String userName = request.getParameter("userName");

        Employee employee = new Employee(name, birthDay, idCard, salary, phone, email, address, position,
                educationDegree, division, userName);

        String message = this.employeeBO.saveEmployee(employee);
        request.setAttribute("message", message);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/create-new-employee.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("idEmployee");
        this.employeeBO.deleteEmployee(id);

        employeeTable(request, response);
    }
}