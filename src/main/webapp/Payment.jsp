<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="models.Appointment" %>
<%@ page import="utils.AppointmentFileHandler" %>
<%
    Appointment appointment = AppointmentFileHandler.getLastAppointment();
    String fee = "1000.00"; // default or fixed fee
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Confirm & Pay - Medical Appointment</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <div class="card shadow p-4">
        <h2 class="mb-4 text-center">Confirm Your Appointment</h2>


        <div class="mb-3">
            <ul class="list-group">
                <li class="list-group-item"><strong>Patient Name:</strong> <%= appointment.getName() %></li>
                <li class="list-group-item"><strong>Phone:</strong> <%= appointment.getContact() %></li>
                <li class="list-group-item"><strong>Doctor:</strong> <%= appointment.getDoctor() %></li>
                <li class="list-group-item"><strong>Date:</strong> <%= appointment.getDate() %></li>
                <li class="list-group-item"><strong>Time:</strong> <%= appointment.getTime() %></li>
                <li class="list-group-item"><strong>Fee:</strong> LKR <%= fee %></li>
            </ul>
        </div>

        <form action="<%= request.getContextPath() %>/payment" method="post">
            <h4 class="mt-4">Enter Card Details</h4>
            <div class="mb-3">
                <label for="cardHolder" class="form-label">Card Holder Name</label>
                <input type="text" class="form-control" id="cardHolder" name="patientName" required>
            </div>
            <div class="mb-3">
                <label for="cardNumber" class="form-label">Card Number</label>
                <input type="text" class="form-control" id="cardNumber" name="cardNumber" required>
            </div>
            <div class="mb-3 row">
                <div class="col-md-6">
                    <label for="expiry" class="form-label">Expiry Date</label>
                    <input type="text" class="form-control" id="expiry" name="expiryDate" placeholder="MM/YY" required>
                </div>
                <div class="col-md-6">
                    <label for="cvv" class="form-label">CVV</label>
                    <input type="password" class="form-control" id="cvv" name="cvv" required>
                </div>
            </div>

            <!-- Hidden fields to pass appointment details -->
            <input type="hidden" name="name" value="<%= appointment.getName() %>">
            <input type="hidden" name="contact" value="<%= appointment.getContact() %>">
            <input type="hidden" name="doctor" value="<%= appointment.getDoctor() %>">
            <input type="hidden" name="date" value="<%= appointment.getDate() %>">
            <input type="hidden" name="time" value="<%= appointment.getTime() %>">
            <input type="hidden" name="fee" value="<%= fee %>">

            <button type="submit" class="btn btn-success w-100 mt-3">Pay Now</button>
        </form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>