package servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import utils.PaymentFileHandler;
import java.io.IOException;

@WebServlet("/ApprovePaymentServlet")
public class ApprovePaymentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String ref = request.getParameter("referenceNumber");
        String action = request.getParameter("action");

        String newStatus = "Pending";
        if ("accept".equalsIgnoreCase(action)) {
            newStatus = "Accepted";
        } else if ("reject".equalsIgnoreCase(action)) {
            newStatus = "Rejected";
        }

        boolean updated = PaymentFileHandler.updatePaymentStatus(ref, newStatus);
        response.sendRedirect(request.getContextPath() + "/adminDashboard");

    }
}