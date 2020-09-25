import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float firstOperand = Integer.parseInt(request.getParameter("firstOperand"));
        float secondOperand = Integer.parseInt(request.getParameter("secondOperand"));
        String operator = request.getParameter("operator");
        String display;

        try {
            float result = Calculator.calculate(firstOperand, secondOperand, operator);
            display = firstOperand + " " + operator + " " + secondOperand + " = " + result;
        } catch (Exception ex) {
            display = "Error : " + ex.getMessage();
        }

        request.setAttribute("display", display);
        request.getRequestDispatcher("display.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
