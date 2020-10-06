package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FuramaServlet", urlPatterns = {"", "/furama"})

public class FuramaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        if (userName.equals("SuPea Jr") && passWord.equals("ok hahaha")) {
            home(response);
        } else {
            String message = "Sorry ! Wrong password, bro !";
            request.setAttribute("message", message);
            try {
                request.getRequestDispatcher("view/login.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String actionFurama = request.getParameter("actionFurama");
        if (actionFurama == null) {
            actionFurama = "";
        }
        if (actionFurama.equals("home")) {
            home(response);
        } else {
            login(response);
        }
    }

    private void home(HttpServletResponse response) {
        try {
            response.sendRedirect("view/home.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void login(HttpServletResponse response) {
        try {
            response.sendRedirect("view/login.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}