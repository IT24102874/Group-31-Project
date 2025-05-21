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
import java.util.stream.Collectors;

@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || !"admin".equals(session.getAttribute("loggedUser"))) {
            response.sendRedirect("login.jsp");
            return;
        }

        String usernameToDelete = request.getParameter("username");
        if (usernameToDelete != null && !usernameToDelete.isEmpty()) {
            List<User> users = FileHandler.readUsersFromFile();

            // Filter out the user to delete
            List<User> updatedUsers = users.stream()
                    .filter(user -> !user.getUserName().equals(usernameToDelete))
                    .collect(Collectors.toList());

            // Rewrite file without the deleted user
            FileHandler.writeUsersToFile(updatedUsers);
        }

        response.sendRedirect("admin");
    }
}