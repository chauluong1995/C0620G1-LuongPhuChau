import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DiscountServlet", urlPatterns = "/display-discount")
public class DiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        String listPrice = request.getParameter("listPrice");
        String discountPercent = request.getParameter("discountPercent");
        double discountAmount;
        double iscountPrice;

        discountAmount = Float.parseFloat(listPrice) * Float.parseFloat(discountPercent) * 0.01;
        iscountPrice = Float.parseFloat(listPrice) - discountAmount;

        request.setAttribute("description", description);
        request.setAttribute("listPrice", listPrice);
        request.setAttribute("discountPercent", discountPercent);
        request.setAttribute("discountAmount", String.valueOf(discountAmount));
        request.setAttribute("iscountPrice", String.valueOf(iscountPrice));

        request.getRequestDispatcher("display.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
