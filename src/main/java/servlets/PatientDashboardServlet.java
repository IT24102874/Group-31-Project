package servlets;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import models.Appointment;
import utils.AppointmentFileHandler;

import java.io.IOException;

@WebServlet("/patientDashboard")
public class PatientDashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        String username = (String) session.getAttribute("loggedUser");

        if (username == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        Appointment appointment = AppointmentFileHandler.getLatestAppointmentForUser(username);
        request.setAttribute("appointment", appointment);
        request.setAttribute("username", username);
        request.getRequestDispatcher("patientDashboard.jsp").forward(request, response);
    }
}

