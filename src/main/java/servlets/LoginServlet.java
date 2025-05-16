package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/admin")
public class LoginServlet extends HttpServlet {
    // Admin credentials (in real app, store securely in database with hashed passwords)
    private static final String ADMIN_USERNAME = "secretAdmin";
    private static final String ADMIN_PASSWORD = "superSecret123!";
    private static final String ADMIN_PATH = "/hidden-admin-dashboard";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password)) {
            // Create session and set admin attribute
            HttpSession session = request.getSession();
            session.setAttribute("isAdmin", true);

            // Redirect to hidden admin dashboard
            response.sendRedirect(request.getContextPath() + ADMIN_PATH);
        } else {
            // Invalid credentials - show error
            request.setAttribute("errorMessage", "Invalid credentials");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}