package model.contract;

import bo.contract.ContractBO;
import bo.contract.ContractBOImpl;
import model.customer.Customer;
import model.employee.Employee;
import model.service.Service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ContractServlet {
    private static ContractBO contractBO = new ContractBOImpl();

    public static void addNewContract(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employees = contractBO.findAllEmployee();
        request.setAttribute("employees", employees);

        List<Customer> customers = contractBO.findAllCustomer();
        request.setAttribute("customers", customers);

        List<Service> services = contractBO.findAllService();
        request.setAttribute("services", services);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/create-new-contract.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void createNewContract(HttpServletRequest request, HttpServletResponse response) {
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String deposit = request.getParameter("deposit");
        String totalMoney = request.getParameter("totalMoney");
        String idEmployee = request.getParameter("employee");
        String idCustomer = request.getParameter("customer");
        String idService = request.getParameter("service");

        Contract contract = new Contract(startDate, endDate, deposit, totalMoney, idEmployee, idCustomer, idService);

        String message = contractBO.saveContract(contract);
        request.setAttribute("message", message);

        addNewContract(request, response);
    }
}
