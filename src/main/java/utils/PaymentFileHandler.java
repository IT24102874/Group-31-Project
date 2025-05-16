package utils;

import models.Payment;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

    public class PaymentFileHandler {
        private static final String FILE_PATH = "D:/USERS/Desktop/TDH/Sliit/OOP/Mid prep/appointment/file/payments.txt";

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
    }

