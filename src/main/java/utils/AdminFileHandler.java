package utils;

import models.User;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AdminFileHandler {
    private static final String USER_FILE_PATH = "D:/USERS/Desktop/TDH/Sliit/OOP/sample/Medical/file/users.txt";

    public static List<User> getAllUsers() throws IOException {
        List<User> users = new ArrayList<>();
        File file = new File(USER_FILE_PATH);
        if (!file.exists()) return users;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 6) {
                    User user = new User(data[0], data[1], data[2], data[3], data[4], data[5]);
                    users.add(user);
                }
            }
        }

        return users;
    }

    public static int getTotalUserCount() throws IOException {
        return getAllUsers().size();
    }

    public static int getPatientCount() throws IOException {
        return (int) getAllUsers().stream().filter(u -> u.getRole().equalsIgnoreCase("Patient")).count();
    }

    public static int getDoctorCount() throws IOException {
        return (int) getAllUsers().stream().filter(u -> u.getRole().equalsIgnoreCase("Doctor")).count();
    }
}