package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import models.Appointment;
import models.User;
import utils.AppointmentFileHandler;
import utils.FileHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/appointment")
public class AppointmentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<User> doctorList = new ArrayList<>();
        List<User> allUsers = FileHandler.readUsersFromFile();

        for (User user : allUsers) {
            if ("Doctor".equalsIgnoreCase(user.getRole())) {
                doctorList.add(user);
            }
        }

        request.setAttribute("doctorList", doctorList);
        request.getRequestDispatcher("appointment.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        User loggedUser = (session != null) ? (User) session.getAttribute("loggedUser") : null;
        String username = (loggedUser != null) ? loggedUser.getUserName() : "unknown";

        Appointment appointment = new Appointment();
        appointment.setUsername(username);
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
            System.out.println("Appointment written successfully for user: " + username);
            response.sendRedirect(request.getContextPath() + "/Payment.jsp");
        } catch (IOException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}