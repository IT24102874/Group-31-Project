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

@WebServlet("/Admin")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || !"admin".equals(session.getAttribute("loggedUser"))) {
            response.sendRedirect("../login.jsp?error=Unauthorized+access");
            return;
        }

        // Load users for account management
        List<User> users = FileHandler.readUsersFromFile();
        request.setAttribute("users", users);

        // Load payments for approval section
        List<Payment> payments = PaymentFileHandler.readAllPayments();
        request.setAttribute("payments", payments);

        request.getRequestDispatcher("Admin.jsp").forward(request, response);
    }
}