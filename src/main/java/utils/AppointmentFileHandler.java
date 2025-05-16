package utils;

import models.Appointment;
import java.io.*;

public class AppointmentFileHandler {
    private static final String FILE_PATH = "D:/USERS/Desktop/TDH/Sliit/OOP/Mid prep/appointment/file/appointments.txt";

    private static void ensureFileExists() throws IOException {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public static void writeAppointmentToFile(Appointment appointment) throws IOException {
        ensureFileExists();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(appointment.getName() + "," +
                    appointment.getAge() + "," +
                    appointment.getContact() + "," +
                    appointment.getGender() + "," +
                    appointment.getDoctor() + "," +
                    appointment.getDate() + "," +
                    appointment.getTime() + "," +
                    appointment.getQ1() + "," +
                    appointment.getQ2() + "," +
                    appointment.getQ3());
            writer.newLine();
        }
    }

    public static Appointment getLastAppointment() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
        String line, lastLine = null;

        while ((line = reader.readLine()) != null) {
            lastLine = line;
        }
        reader.close();

        if (lastLine != null) {
            String[] parts = lastLine.split(",");
            Appointment appointment = new Appointment();
            appointment.setName(parts[0]);
            appointment.setAge(Integer.parseInt(parts[1]));
            appointment.setContact(parts[2]);
            appointment.setGender(parts[3]);
            appointment.setDoctor(parts[4]);
            appointment.setDate(parts[5]);
            appointment.setTime(parts[6]);
            appointment.setQ1(parts[7]);
            appointment.setQ2(parts[8]);
            appointment.setQ3(parts[9]);
            return appointment;
        }

        return null;
    }

}
