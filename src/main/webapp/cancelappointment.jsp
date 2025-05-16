<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cancel Appointment</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<nav class="navbar navbar-dark bg-primary px-4">
    <span class="navbar-brand mb-0 h1">Cardio Care</span>
</nav>

<div class="container bg-white p-5 mt-5 rounded shadow">
    <h2 class="text-center text-danger mb-4">Cancel Your Appointment</h2>

    <%
        String patientName = request.getParameter("patientName");
        String doctorName = request.getParameter("doctorName");
        String appointmentDate = request.getParameter("appointmentDate");
        String appointmentTime = request.getParameter("appointmentTime");

        if (patientName == null) patientName = "Unknown";
        if (doctorName == null) doctorName = "Unknown";
        if (appointmentDate == null) appointmentDate = "Unknown";
        if (appointmentTime == null) appointmentTime = "Unknown";
    %>

    <div class="mb-3">
        <label class="form-label fw-bold">Patient Name:</label>
        <p id="patientName"><%= patientName %></p>
    </div>
    <div class="mb-3">
        <label class="form-label fw-bold">Doctor Name:</label>
        <p id="doctorName"><%= doctorName %></p>
    </div>
    <div class="mb-3">
        <label class="form-label fw-bold">Appointment Date:</label>
        <p id="appointmentDate"><%= appointmentDate %></p>
    </div>
    <div class="mb-3">
        <label class="form-label fw-bold">Appointment Time:</label>
        <p id="appointmentTime"><%= appointmentTime %></p>
    </div>

    <button class="btn btn-danger" onclick="cancelAppointment()">Cancel Appointment</button>
    <a href="dashboard.jsp" class="btn btn-secondary ms-2">Back to Dashboard</a>

    <div id="cancelMsg" class="mt-4 text-success fw-bold" style="display: none;">
        Appointment has been successfully canceled.
    </div>
</div>

<script>
    function cancelAppointment() {
        document.getElementById("cancelMsg").style.display = "block";
        document.getElementById("patientName").innerText = "-";
        document.getElementById("doctorName").innerText = "-";
        document.getElementById("appointmentDate").innerText = "-";
        document.getElementById("appointmentTime").innerText = "-";
    }
</script>

</body>
</html>
