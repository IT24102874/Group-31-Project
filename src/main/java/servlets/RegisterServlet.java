package servlets;

import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final String FILE_PATH = "C:/Users/Rasith/Desktop/SLIIT/DSA/MedicalAppointmentSystem"; // Change path

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get user inputs
        String role = request.getParameter("role");
        String specialization = request.getParameter("specialization"); // Only for doctors
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Save data to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(role + "," + specialization + "," + name + "," + email + "," +
                    phone + "," + username + "," + password);
            writer.newLine();
        }

        // Redirect to login page
        response.sendRedirect("login.jsp");
    }
}
