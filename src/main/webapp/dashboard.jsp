<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cardio Care - Patient Dashboard</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap CSS (v5 CDN) -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .dashboard-container {
            max-width: 600px;
            margin: 50px auto;
            background-color: #ffffff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        .appointment-box {
            background-color: #f8f9fa;
            border-left: 5px solid #007bff;
            padding: 15px;
            margin-bottom: 30px;
            text-align: left;
        }

        .btn-block {
            width: 100%;
            margin-bottom: 15px;
        }
    </style>
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container">
        <a class="navbar-brand fw-bold" href="#">Cardio Care</a>
        <div class="ms-auto">
            <a class="btn btn-outline-light" href="logout.jsp">Logout</a>
        </div>
    </div>
</nav>

<!-- Dashboard -->
<div class="dashboard-container">
    <h2 class="text-primary fw-bold mb-3">Welcome Anuja</h2>
    <p class="text-muted">Today: May 5, 2025</p>

    <div class="appointment-box mb-4">
        <strong>Your Next Appointment:</strong><br>
        Dr. ABC | May 7, 2025 | 10:00 AM
    </div>

    <a href="appointment.jsp" class="btn btn-success btn-lg btn-block">Book Appointment</a>
    <a href="viewappointment.jsp" class="btn btn-info btn-lg btn-block">View Appointment</a>
    <a href="cancelappointment.jsp" class="btn btn-warning btn-lg btn-block">Cancel Appointment</a>
</div>

<!-- Bootstrap JS (optional if you use dropdowns/toggles) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
