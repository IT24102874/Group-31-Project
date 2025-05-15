<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    // These values would typically come from the appointment booking form (via POST or session)
    String patientName = request.getParameter("patientName");
    String email = request.getParameter("email");
    String phone = request.getParameter("phone");
    String doctorName = request.getParameter("doctorName");
    String appointmentDate = request.getParameter("appointmentDate");
    String appointmentTime = request.getParameter("appointmentTime");
    String fee = request.getParameter("fee"); // Or set a default fee
    if (fee == null) fee = "50.00";
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
                <li class="list-group-item"><strong>Patient Name:</strong> <%= patientName %></li>
                <li class="list-group-item"><strong>Email:</strong> <%= email %></li>
                <li class="list-group-item"><strong>Phone:</strong> <%= phone %></li>
                <li class="list-group-item"><strong>Doctor:</strong> <%= doctorName %></li>
                <li class="list-group-item"><strong>Date:</strong> <%= appointmentDate %></li>
                <li class="list-group-item"><strong>Time:</strong> <%= appointmentTime %></li>
                <li class="list-group-item"><strong>Fee:</strong> $<%= fee %></li>
            </ul>
        </div>

        <form action="processPayment.jsp" method="post">
            <h4 class="mt-4">Enter Card Details</h4>
            <div class="mb-3">
                <label for="cardNumber" class="form-label">Card Number</label>
                <input type="text" class="form-control" id="cardNumber" name="cardNumber" required>
            </div>
            <div class="mb-3 row">
                <div class="col-md-6">
                    <label for="expiryDate" class="form-label">Expiry Date</label>
                    <input type="text" class="form-control" id="expiryDate" name="expiryDate" placeholder="MM/YY" required>
                </div>
                <div class="col-md-6">
                    <label for="cvv" class="form-label">CVV</label>
                    <input type="password" class="form-control" id="cvv" name="cvv" required>
                </div>
            </div>

            <!-- Hidden fields to carry appointment data -->
            <input type="hidden" name="patientName" value="<%= patientName %>">
            <input type="hidden" name="email" value="<%= email %>">
            <input type="hidden" name="phone" value="<%= phone %>">
            <input type="hidden" name="doctorName" value="<%= doctorName %>">
            <input type="hidden" name="appointmentDate" value="<%= appointmentDate %>">
            <input type="hidden" name="appointmentTime" value="<%= appointmentTime %>">
            <input type="hidden" name="fee" value="<%= fee %>">

            <button type="submit" class="btn btn-success w-100 mt-3">Pay Now</button>
        </form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>