//package utils;
//
//public class DoctorFileHandler {
//package utils;
//
//import models.AppointmentAction;
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;

//    public class DoctorFileHandler {
//        private static final String FILE_PATH = "C:/Users/Rasith/Desktop/SLIIT/DSA/MedicalAppointmentSystem/DoctorFileHandler.txt";
//
//        // Ensure the file exists before reading or writing
//        private static void ensureFileExists() throws IOException {
//            File file = new File(FILE_PATH);
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//        }
//
//        // Write an appointment action to the file
//        public static void writeActionToFile(AppointmentAction action) throws IOException {
//            ensureFileExists();
//
//            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
//                writer.write(action.getAppointmentId() + "," +
//                        action.getPatientName() + "," +
//                        action.getStatus() + "," +
//                        action.getTimestamp());
//                writer.newLine();
//            }
//        }
//
//        // Read all appointment actions from the file
//        public static List<AppointmentAction> readActionsFromFile() throws IOException {
//            ensureFileExists();
//            List<AppointmentAction> actions = new ArrayList<>();
//
//            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    String[] actionData = line.split(",");
//                    if (actionData.length == 4) {
//                        AppointmentAction action = new AppointmentAction(
//                                Integer.parseInt(actionData[0]), // appointmentId
//                                actionData[1],                  // patientName
//                                actionData[2],                  // status
//                                actionData[3]                   // timestamp
//                        );
//                        actions.add(action);
//                    }
//                }
//            }
//            return actions;
//        }
//    }
//}
