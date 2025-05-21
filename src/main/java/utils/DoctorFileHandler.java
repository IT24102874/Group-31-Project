package utils;

import models.Doctor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorFileHandler {
    private static final String FILE_PATH = "D:/USERS/Desktop/TDH/Sliit/OOP/sample/Medical/file/doctors.txt";

    private static void ensureFileExists() throws IOException {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public static Doctor getDoctorByUsername(String username) throws IOException {
        ensureFileExists();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4 && parts[0].equalsIgnoreCase(username)) {
                    return new Doctor(parts[0], parts[1], parts[2], parts[3]);
                }
            }
        }
        return null;
    }

    public static List<Doctor> readAllDoctors() throws IOException {
        ensureFileExists();
        List<Doctor> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    list.add(new Doctor(parts[0], parts[1], parts[2], parts[3]));
                }
            }
        }
        return list;
    }
}