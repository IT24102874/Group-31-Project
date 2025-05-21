package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import models.Doctor;
import models.Appointment;
import utils.DoctorFileHandler;
import utils.AppointmentFileHandler;

import java.io.IOException;
import java.util.List;

@WebServlet("/DoctorDashboardServlet")
public class DoctorDashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("doctorUsername") == null) {
            response.sendRedirect("doctor_login.jsp");  // Not logged in
            return;
        }

        String doctorUsername = (String) session.getAttribute("doctorUsername");

        // Load doctor info
        Doctor doctor = DoctorFileHandler.getDoctorByUsername(doctorUsername);

        // Load appointments for this doctor
        List<Appointment> appointments = AppointmentFileHandler.readAppointmentsFromFile()
                .stream()
                .filter(a -> a.getDoctor().equalsIgnoreCase(doctorUsername))
                .toList();

        // Set attributes and forward to JSP
        request.setAttribute("doctor", doctor);
        request.setAttribute("appointments", appointments);
        request.getRequestDispatcher("Doctor.jsp").forward(request, response);
    }
}