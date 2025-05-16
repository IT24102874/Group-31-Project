package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminServlet", value = "/hidden-admin-dashboard")
public class AdminServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        // Check if user is authenticated as admin
        if (session != null && session.getAttribute("isAdmin") != null) {
            // Show admin dashboard
            request.getRequestDispatcher("/WEB-INF/adminDashboard.jsp").forward(request, response);
        } else {
            // Not authorized - redirect to login
            response.sendRedirect(request.getContextPath() + "/login.jsp?unauthorized=true");
        }
    }
}