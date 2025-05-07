package servlets;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;
import FileHandler.FileHandler;

import java.io.IOException;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String role = request.getParameter("role");
        String username = request.getParameter("username");
        String password = request.getParameter("password");


        User user = new User();
        user.setName(name);
        user.setPhoneNumber(phone);
        user.setEmail(email);
        user.setRole(role);
        user.setUserName(username);
        user.setPassword(password);

        try {

            FileHandler.writeUserToFile(user);
            System.out.println("User registered successfully: " + username);


            response.sendRedirect(request.getContextPath()+"/login.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
