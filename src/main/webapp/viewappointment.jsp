<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="models.Appointment" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Your Appointments</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<nav class="navbar navbar-dark bg-primary px-4">
    <span class="navbar-brand mb-0 h1">Cardio Care</span>
</nav>

<div class="container bg-white p-5 mt-5 rounded shadow">
    <h2 class="text-center text-info mb-4">Your Appointment Details</h2>

    <%
        List<Appointment> appointments = (List<Appointment>) request.getAttribute("appointments");
        if (appointments == null || appointments.isEmpty()) {
    %>
    <p class="text-center">No appointments found.</p>
    <%
    } else {
        for (Appointment a : appointments) {
    %>

    <div class="card mb-4 shadow-sm">
        <div class="card-body">
            <div class="mb-2">
                <label class="form-label fw-bold">Patient Name:</label>
                <p><%= a.getName() %></p>
            </div>
            <div class="mb-2">
                <label class="form-label fw-bold">Doctor Name:</label>
                <p><%= a.getDoctor() %></p>
            </div>
            <div class="mb-2">
                <label class="form-label fw-bold">Appointment Date:</label>
                <p><%= a.getDate() %></p>
            </div>
            <div class="mb-2">
                <label class="form-label fw-bold">Appointment Time:</label>
                <p><%= a.getTime() %></p>
            </div>
        </div>
    </div>

    <%
            }
        }
    %>

    <a href="/JSP/dashboard.jsp" class="btn btn-secondary mt-3">Back to Dashboard</a>
</div>

</body>
</html>
