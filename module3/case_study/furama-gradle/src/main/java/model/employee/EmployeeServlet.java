package model.employee;

import bo.employee.EmployeeBO;
import bo.employee.EmployeeBOImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class EmployeeServlet {
    private static EmployeeBO employeeBO = new EmployeeBOImpl();

    public static void employeeTable(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = employeeBO.findAll();
        request.setAttribute("employeeList", employeeList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/employee-list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void showCreateNewEmployee(HttpServletRequest request, HttpServletResponse response) {
        support(request);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/create-new-employee.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void createNewEmployee(HttpServletRequest request, HttpServletResponse response) {
        Employee employee = informationEmployee(request);

        String message = employeeBO.saveEmployee(employee);
        request.setAttribute("message", message);

        showCreateNewEmployee(request, response);
    }

    public static void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("idEmployee");
        employeeBO.deleteEmployee(id);

        employeeTable(request, response);
    }

    public static void searchEmployee(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("nameEmployee");
        List<Employee> employeeList = employeeBO.findByName(name);
        request.setAttribute("employeeList", employeeList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/search-list-employee.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void showEditEmployee(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Employee employee = employeeBO.findEmployeeById(id);
        request.setAttribute("employee", employee);

        support(request);

        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("view/employee/update-employee.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateEmployee(HttpServletRequest request, HttpServletResponse response) {
        Employee employee = informationEmployee(request);
        String id = request.getParameter("id");
        employee.setId(id);

        String message = employeeBO.updateEmployee(employee);
        request.setAttribute("message", message);

        employeeTable(request, response);
    }

    private static Employee informationEmployee(HttpServletRequest request) {
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
        String userName = request.getParameter("user");

        return new Employee(name, birthDay, idCard, salary, phone, email, address, position,
                educationDegree, division, userName);
    }

    private static void support(HttpServletRequest request) {
        List<Position> positions = employeeBO.findAllPosition();
        request.setAttribute("positions", positions);

        List<EducationDegree> educationDegrees = employeeBO.findAllEducationDegree();
        request.setAttribute("educationDegrees", educationDegrees);

        List<Division> divisions = employeeBO.findAllDivision();
        request.setAttribute("divisions", divisions);

        List<User> users = employeeBO.findAllUser();
        request.setAttribute("users", users);
    }
}
