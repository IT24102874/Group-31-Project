package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import models.Appointment;
import utils.AppointmentFileHandler;

import java.io.IOException;

@WebServlet("/appointment")
public class AppointmentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Appointment appointment = new Appointment();
        appointment.setName(request.getParameter("patientName"));
        appointment.setAge(Integer.parseInt(request.getParameter("patientAge")));
        appointment.setContact(request.getParameter("contactNumber"));
        appointment.setGender(request.getParameter("gender"));
        appointment.setDoctor(request.getParameter("doctor"));
        appointment.setDate(request.getParameter("appointmentDate"));
        appointment.setTime(request.getParameter("appointmentTime"));
        appointment.setQ1(request.getParameter("q1"));
        appointment.setQ2(request.getParameter("q2"));
        appointment.setQ3(request.getParameter("q3"));

        try {
            AppointmentFileHandler.writeAppointmentToFile(appointment);
            System.out.println("Appointment written Successfully");
            response.sendRedirect("payment.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
