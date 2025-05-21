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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("loggedUser", "admin");
            response.sendRedirect("Admin"); // Redirect to AdminServlet
            return;
        }

        List<User> users = FileHandler.readUsersFromFile();
        User authenticatedUser = null;

        for (User user : users) {
            if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
                authenticatedUser = user;
                break;
            }
        }

        if (authenticatedUser != null) {
            HttpSession session = request.getSession();
            session.setAttribute("loggedUser", authenticatedUser);
            String role = authenticatedUser.getRole();

            if ("Doctor".equalsIgnoreCase(role)) {
                response.sendRedirect("JSP/Doctor.jsp");
            } else if ("Patient".equalsIgnoreCase(role)) {
                response.sendRedirect("JSP/dashboard.jsp");
            } else {
                response.sendRedirect("login.jsp?error=Unknown+role");
            }
        } else {
            response.sendRedirect("login.jsp?error=Invalid+username+or+password");
        }
    }
}
