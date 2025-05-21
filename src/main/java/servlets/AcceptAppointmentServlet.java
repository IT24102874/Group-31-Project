package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;

@WebServlet("/AcceptAppointmentServlet")
public class AcceptAppointmentServlet extends HttpServlet {
    private static final String FILE_PATH = "C:/Users/dilun/OneDrive/Desktop/desktop/OOP/Project-31/appointments.txt"; // Replace with actual path

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String appointmentId = request.getParameter("appointmentId");

        File file = new File(FILE_PATH);
        File tempFile = new File("appointments_temp.txt");

        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine;
        boolean updated = false;

        while ((currentLine = reader.readLine()) != null) {
            String[] fields = currentLine.split(",");

            // Expected format: name,age,contact,gender,doctor,date,time,q1,q2,q3,status
            if (fields.length >= 10) {
                String id = fields[0] + fields[5] + fields[6]; // name + date + time
                if (id.equals(appointmentId)) {
                    fields[9] = "Accepted"; // Update status field
                    updated = true;
                }
                writer.write(String.join(",", fields));
                writer.newLine();
            } else {
                // In case of incomplete line
                writer.write(currentLine);
                writer.newLine();
            }
        }

        writer.close();
        reader.close();

        // Replace old file with updated file
        if (updated) {
            if (file.delete()) {
                tempFile.renameTo(file);
            }
        } else {
            tempFile.delete(); // No update, so remove temp file
        }

        response.sendRedirect("Doctor.jsp");
    }
}