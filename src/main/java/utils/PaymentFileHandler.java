package utils;

import models.Appointment;
import models.Payment;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentFileHandler {
        private static final String FILE_PATH = "D:/USERS/Desktop/TDH/Sliit/OOP/Mid prep/appointment/file/payments.txt";

    private static void ensureFileExists() throws IOException {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            file.createNewFile();
        }
    }
        public static void writePaymentToFile(Payment payment) throws IOException {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
                writer.write(
                        payment.getReferenceNumber() + "," +
                                payment.getAppointment().getName() + "," +
                                payment.getAppointment().getDoctor() + "," +
                                payment.getAppointment().getDate() + "," +
                                payment.getAppointment().getTime() + "," +
                                payment.getCardNumber() + "," +
                                payment.getExpiryDate() + "," +
                                payment.getStatus()
                );
                writer.newLine();
            }
        }

    public static List<Payment> readAllPayments() throws IOException {
        ensureFileExists();
        List<Payment> payments = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                String[] data = line.split(",");
                if (data.length == 8) {
                    Appointment appt = new Appointment(data[1], data[2], data[3], data[4]);
                    Payment p = new Payment();
                    p.setReferenceNumber(data[0]);
                    p.setAppointment(appt);
                    p.setCardNumber(data[5]);
                    p.setExpiryDate(data[6]);
                    p.setStatus(data[7]);
                    payments.add(p);
                }
            }
        }

        return payments;
    }

    public static boolean updatePaymentStatus(String refNumber, String newStatus) throws IOException {
        List<Payment> payments = readAllPayments();
        boolean found = false;

        for (Payment p : payments) {
            if (p.getReferenceNumber().equals(refNumber)) {
                p.setStatus(newStatus);
                found = true;
                break;
            }
        }

        if (found) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
                for (Payment p : payments) {
                    writer.write(
                            p.getReferenceNumber() + "," +
                                    p.getAppointment().getName() + "," +
                                    p.getAppointment().getDoctor() + "," +
                                    p.getAppointment().getDate() + "," +
                                    p.getAppointment().getTime() + "," +
                                    p.getCardNumber() + "," +
                                    p.getExpiryDate() + "," +
                                    p.getStatus()
                    );
                    writer.newLine();
                }
            }
        }

        return found;
    }
}



