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


@WebServlet("/user_login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String username = request.getParameter("username");
        String password = request.getParameter("password");


        List<User> users = FileHandler.readUsersFromFile();

        boolean isAuthenticated = false;


        for (User user : users) {
            if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
                isAuthenticated = true;
                break;
            }
        }

        if (isAuthenticated) {

            response.sendRedirect("dashboard.html");
        } else {

            response.sendRedirect("login.jsp?error=Invalid Credentials");
        }


    }

}
