package utils;

import models.User;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileHandler {
    private static final String FILE_PATH = "C:/Users/Office/IdeaProjects/Group-31-Project/users.txt";



    private static void ensureFileExists() throws IOException {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            file.createNewFile();
        }
    }


    public static void writeUserToFile(User user) throws IOException {
        ensureFileExists();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(user.getName() + "," +
                    user.getPhoneNumber() + "," +
                    user.getEmail() + "," +
                    user.getRole() + "," +
                    user.getUserName() + "," +
                    user.getPassword());
            writer.newLine();
        }
    }


    public static List<User> readUsersFromFile() throws IOException {
        ensureFileExists();
        List<User> users = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length == 6) {
                    User user = new User(userData[0], userData[1], userData[2], userData[3], userData[4], userData[5]);
                    users.add(user);
                }
            }
        }
        return users;
    }


    public static void writeUsersToFile(List<User> users) throws IOException {
        ensureFileExists();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, false))) { // overwrite file
            for (User user : users) {
                writer.write(user.getName() + "," +
                        user.getPhoneNumber() + "," +
                        user.getEmail() + "," +
                        user.getRole() + "," +
                        user.getUserName() + "," +
                        user.getPassword());
                writer.newLine();
            }
        }
    }
}

