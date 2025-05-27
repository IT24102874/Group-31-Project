package utils;

import models.Appointment;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentFileHandler {
    private static final String FILE_PATH = "C:/Users/Office/IdeaProjects/Group-31-Project/appointments.txt";

    private static void ensureFileExists() throws IOException {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public static void writeAppointmentToFile(Appointment appointment) throws IOException {
        ensureFileExists();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(appointment.getUsername() + "," + appointment.getName() + "," +
                    appointment.getAge() + "," + appointment.getContact() + "," +
                    appointment.getGender() + "," + appointment.getDoctor() + "," +
                    appointment.getDate() + "," + appointment.getTime() + "," +
                    appointment.getQ1() + "," + appointment.getQ2() + "," + appointment.getQ3() + "," +
                    appointment.getUrgencyScore());
            writer.newLine();
        }
    }

    public static Appointment getLatestAppointmentForUser(String username) throws IOException {
        ensureFileExists();
        Appointment latest = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 12 && parts[0].equalsIgnoreCase(username)) {
                    try {
                        Appointment appt = new Appointment();
                        appt.setUsername(parts[0]);
                        appt.setName(parts[1]);
                        appt.setAge(Integer.parseInt(parts[2]));
                        appt.setContact(parts[3]);
                        appt.setGender(parts[4]);
                        appt.setDoctor(parts[5]);
                        appt.setDate(parts[6]);
                        appt.setTime(parts[7]);
                        appt.setQ1(parts[8]);
                        appt.setQ2(parts[9]);
                        appt.setQ3(parts[10]);
                        appt.setUrgencyScore(Integer.parseInt(parts[11]));
                        latest = appt;
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid data format in line: " + line);
                        continue;
                    }
                }
            }
        }
        return latest;
    }

    public static Appointment getLastAppointment() throws IOException {
        ensureFileExists();
        String lastLine = null, line;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            while ((line = reader.readLine()) != null) {
                lastLine = line;
            }
        }

        if (lastLine != null) {
            String[] parts = lastLine.split(",");
            if (parts.length == 12) {
                try {
                    Appointment appointment = new Appointment();
                    appointment.setUsername(parts[0]);
                    appointment.setName(parts[1]);
                    appointment.setAge(Integer.parseInt(parts[2]));
                    appointment.setContact(parts[3]);
                    appointment.setGender(parts[4]);
                    appointment.setDoctor(parts[5]);
                    appointment.setDate(parts[6]);
                    appointment.setTime(parts[7]);
                    appointment.setQ1(parts[8]);
                    appointment.setQ2(parts[9]);
                    appointment.setQ3(parts[10]);
                    appointment.setUrgencyScore(Integer.parseInt(parts[11]));
                    return appointment;
                } catch (NumberFormatException e) {
                    System.err.println("Invalid data format in line: " + lastLine);
                }
            }
        }
        return null;
    }

    public static List<Appointment> getAppointmentsForUser(String username) throws IOException {
        ensureFileExists();
        List<Appointment> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 12 && parts[0].equalsIgnoreCase(username)) {
                    try {
                        Appointment a = new Appointment();
                        a.setUsername(parts[0]);
                        a.setName(parts[1]);
                        a.setAge(Integer.parseInt(parts[2]));
                        a.setContact(parts[3]);
                        a.setGender(parts[4]);
                        a.setDoctor(parts[5]);
                        a.setDate(parts[6]);
                        a.setTime(parts[7]);
                        a.setQ1(parts[8]);
                        a.setQ2(parts[9]);
                        a.setQ3(parts[10]);
                        a.setUrgencyScore(Integer.parseInt(parts[11]));
                        list.add(a);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid data format in line: " + line);
                        continue;
                    }
                }
            }
        }
        return list;
    }

    public static Appointment getLatestAppointmentByUsername(String username) {
        List<Appointment> all = readAppointmentsFromFile();
        for (int i = all.size() - 1; i >= 0; i--) {
            if (all.get(i).getUsername().equalsIgnoreCase(username)) {
                return all.get(i);
            }
        }
        return null;
    }

    public static List<Appointment> readAppointmentsFromFile() {
        List<Appointment> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 12) {
                    try {
                        Appointment a = new Appointment();
                        a.setUsername(parts[0]);
                        a.setName(parts[1]);
                        a.setAge(Integer.parseInt(parts[2]));
                        a.setContact(parts[3]);
                        a.setGender(parts[4]);
                        a.setDoctor(parts[5]);
                        a.setDate(parts[6]);
                        a.setTime(parts[7]);
                        a.setQ1(parts[8]);
                        a.setQ2(parts[9]);
                        a.setQ3(parts[10]);
                        a.setUrgencyScore(Integer.parseInt(parts[11]));
                        list.add(a);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid data format in line: " + line);
                        continue;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<Appointment> getAppointmentsByDoctorName(String doctorName) throws IOException {
        List<Appointment> doctorAppointments = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            return doctorAppointments;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 12 && parts[5].equalsIgnoreCase(doctorName)) {
                    try {
                        Appointment a = new Appointment();
                        a.setUsername(parts[0]);
                        a.setName(parts[1]);
                        a.setAge(Integer.parseInt(parts[2]));
                        a.setContact(parts[3]);
                        a.setGender(parts[4]);
                        a.setDoctor(parts[5]);
                        a.setDate(parts[6]);
                        a.setTime(parts[7]);
                        a.setQ1(parts[8]);
                        a.setQ2(parts[9]);
                        a.setQ3(parts[10]);
                        a.setUrgencyScore(Integer.parseInt(parts[11]));
                        doctorAppointments.add(a);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid data format in line: " + line);
                        continue;
                    }
                }
            }
        }
        return doctorAppointments;
    }
}