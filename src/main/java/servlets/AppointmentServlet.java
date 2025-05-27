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

        //DSA requirement
        String q1Answer = request.getParameter("q1");
        String q2Answer = request.getParameter("q2");
        String q3Answer = request.getParameter("q3");

        int q1Score = mapAnswerToScore(q1Answer);
        int q2Score = mapAnswerToScore(q2Answer);
        int q3Score = mapAnswerToScore(q3Answer);

        int urgencyScore = q1Score + q2Score + q3Score;

        Appointment appointment = new Appointment();
        appointment.setUsername(username);
        appointment.setName(request.getParameter("patientName"));
        appointment.setAge(Integer.parseInt(request.getParameter("patientAge")));
        appointment.setContact(request.getParameter("contactNumber"));
        appointment.setGender(request.getParameter("gender"));
        appointment.setDoctor(request.getParameter("doctor"));
        appointment.setDate(request.getParameter("appointmentDate"));
        appointment.setTime(request.getParameter("appointmentTime"));
        appointment.setQ1(String.valueOf(q1Score));
        appointment.setQ2(String.valueOf(q2Score));
        appointment.setQ3(String.valueOf(q3Score));
        appointment.setUrgencyScore(urgencyScore);





        try {
            AppointmentFileHandler.writeAppointmentToFile(appointment);
            System.out.println("Appointment written successfully for user: " + username);
            response.sendRedirect(request.getContextPath() + "/Payment.jsp");
        } catch (IOException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }

    private int mapAnswerToScore(String answer) {
        switch (answer.toLowerCase()) {
            case "a": return 5;
            case "b": return 3;
            case "c": return 1;
            default: return 0;
        }
    }

}
