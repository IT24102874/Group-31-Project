package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.User;
import utils.FileHandler;

import java.io.IOException;
import java.util.List;

@WebServlet("/user_login")
public class LoginServlet extends HttpServlet {

    // Hardcoded admin credentials
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // First, check if admin
        if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
            HttpSession session = request.getSession();
            session.setAttribute("loggedUser", "admin");
            response.sendRedirect("Admin.jsp"); // Redirect to admin dashboard
            return;
        }

        // Check file-based users (patients/doctors)
        List<User> users = FileHandler.readUsersFromFile();
        User authenticatedUser = null;

        for (User user : users) {
            if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
                authenticatedUser = user;
                break;
            }
        }

        if (authenticatedUser != null) {
            // Store the user in session
            HttpSession session = request.getSession();
            session.setAttribute("loggedUser", authenticatedUser);

            String role = authenticatedUser.getRole();

            if (role.equalsIgnoreCase("Doctor")) {
                response.sendRedirect("Doctor.jsp");
            } else
                response.sendRedirect("dashboard.jsp");

        }
        }
    }

