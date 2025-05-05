package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        switch (action) {
            case "approvePayment":
                approvePayment(request, response);
                break;
            case "rejectPayment":
                rejectPayment(request, response);
                break;
            case "createUser":
                createUser(request, response);
                break;
            case "updateUser":
                updateUser(request, response);
                break;
            case "deleteUser":
                deleteUser(request, response);
                break;
            default:
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
        }
    }

    private void approvePayment(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String paymentId = request.getParameter("paymentId");
        // Call your service layer to approve the payment
        // paymentService.approvePayment(paymentId);
        response.sendRedirect("adminDashboard.jsp?status=paymentApproved");
    }

    private void rejectPayment(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String paymentId = request.getParameter("paymentId");
        // paymentService.rejectPayment(paymentId);
        response.sendRedirect("adminDashboard.jsp?status=paymentRejected");
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String role = request.getParameter("role");
        // userService.createUser(username, email, role);
        response.sendRedirect("adminDashboard.jsp?status=userCreated");
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String userId = request.getParameter("userId");
        String email = request.getParameter("email");
        String role = request.getParameter("role");
        // userService.updateUser(userId, email, role);
        response.sendRedirect("adminDashboard.jsp?status=userUpdated");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String userId = request.getParameter("userId");
        // userService.deleteUser(userId);
        response.sendRedirect("adminDashboard.jsp?status=userDeleted");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
