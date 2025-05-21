package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import models.User;
import models.Payment;
import utils.FileHandler;
import utils.PaymentFileHandler;

import java.io.IOException;
import java.util.List;

@WebServlet("/adminDashboard")
public class AdminDashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Load users
        List<User> users = FileHandler.readUsersFromFile();
        request.setAttribute("users", users);

        // Load payments
        List<Payment> payments = PaymentFileHandler.readAllPayments();
        request.setAttribute("payments", payments);

        // Forward to admin dashboard JSP
        request.getRequestDispatcher("Admin.jsp").forward(request, response);
    }
}