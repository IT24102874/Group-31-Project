package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;
import utils.FileHandler;
import java.io.IOException;


@WebServlet("/user_register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get form input values from request
        String name = request.getParameter("name"); // Get user name
        String phone = request.getParameter("phone"); // Get phone number
        String email = request.getParameter("email"); // Get email
        String role = request.getParameter("role"); // Get user role (Patient/Doctor)
        String username = request.getParameter("username"); // Get username
        String password = request.getParameter("password"); // Get password

        // Create a new User object and set its attributes
        User user = new User();
        user.setName(name);
        user.setPhoneNumber(phone);
        user.setEmail(email);
        user.setRole(role);
        user.setUserName(username);
        user.setPassword(password);

        try {
            // Save user data to file using FileHandler utility class
            FileHandler.writeUserToFile(user);
            System.out.println("User registered successfully: " + username);

            // Redirect to login page after successful registration
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        } catch (Exception e) {
            e.printStackTrace(); // Print error details
        }
    }
}


