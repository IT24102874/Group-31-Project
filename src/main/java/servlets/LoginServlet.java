package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;
import utils.FileHandler;

import java.io.IOException;
import java.util.List;


@WebServlet("/user-login") // This servlet is mapped to "/login" URL
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get username and password entered in the login form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Read users from file
        List<User> users = FileHandler.readUsersFromFile();

        boolean isAuthenticated = false; // Flag to track if user is found

        // Loop through user list and check if username & password match
        for (User user : users) {
            if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
                isAuthenticated = true;
                break; // Exit loop if match is found
            }
        }

        if (isAuthenticated) {
            // Redirect to homepage/dashboard after successful login
            response.sendRedirect("dashboard.html");
        } else {
            // Redirect to login page with error message
            response.sendRedirect("login.jsp?error=Invalid Credentials");
        }
    }
}