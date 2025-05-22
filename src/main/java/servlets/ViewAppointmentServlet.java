package servlets;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import models.Appointment;
import models.User;
import utils.AppointmentFileHandler;

import java.io.IOException;
import java.util.List;

    @WebServlet("/myAppointments")
    public class ViewAppointmentServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            HttpSession session = request.getSession(false);
            User loggedUser = (session != null) ? (User) session.getAttribute("loggedUser") : null;

            if (loggedUser == null || !"Patient".equalsIgnoreCase(loggedUser.getRole())) {
                response.sendRedirect("login.jsp?error=Please+login+as+patient");
                return;
            }

            String username = loggedUser.getUserName();
            List<Appointment> appointments = AppointmentFileHandler.getAppointmentsForUser(username);

            request.setAttribute("appointments", appointments);
            request.getRequestDispatcher("/JSP/viewappointment.jsp").forward(request, response);
        }
    }

