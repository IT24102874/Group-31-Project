package servlets;

public class PaymentServlet {
    package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import models.Appointment;
import models.Payment;
import utils.AppointmentFileHandler;
import utils.PaymentFileHandler;

import java.io.IOException;
import java.util.List;

    @WebServlet("/payment")
    public class PaymentServlet extends HttpServlet {
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            String patientName = request.getParameter("patientName");
            String cardNumber = request.getParameter("cardNumber");
            String expiryDate = request.getParameter("expiryDate");
            String cvv = request.getParameter("cvv");

            // Find the latest appointment (or match by name if needed)
            Appointment latestAppointment = AppointmentFileHandler.getLastAppointment();
            if (latestAppointment != null && !latestAppointment.getName().equalsIgnoreCase(patientName)) {
                latestAppointment = null; // Patient mismatch
            }


            if (latestAppointment != null) {
                Payment payment = new Payment();
                payment.setAppointment(latestAppointment);
                payment.setCardNumber(cardNumber);
                payment.setExpiryDate(expiryDate);
                payment.setCvv(cvv);
                payment.setReferenceNumber("REF" + System.currentTimeMillis());
                payment.setStatus("Pending");

                PaymentFileHandler.writePaymentToFile(payment);

                response.sendRedirect("payment_success.jsp?ref=" + payment.getReferenceNumber());
            } else {
                response.sendRedirect("error.jsp");
            }
        }

    }
