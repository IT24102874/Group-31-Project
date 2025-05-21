<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="models.User" %>
<%@ page import="models.Appointment" %>
<%@ page import="java.util.List" %>

<%
    User user = (User) session.getAttribute("loggedUser");

    if (user == null || !"Doctor".equals(user.getRole())) {
        response.sendRedirect("login.jsp");
        return;
    }

    List<Appointment> appointments = (List<Appointment>) request.getAttribute("appointments");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cardio Care - Doctor Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container-fluid">
        <a class="navbar-brand fw-bold" href="#">Cardio Care</a>
        <div class="ms-auto d-flex align-items-center">
            <span class="navbar-text text-white me-3">
                Logged in as: <%= user.getName() %>
            </span>
            <a href="logout.jsp" class="btn btn-outline-light btn-sm">Logout</a>
        </div>
    </div>
</nav>

<!-- Main Container -->
<div class="container mt-5">
    <!-- Doctor Info -->
    <div class="card mb-4">
        <div class="card-body">
            <h4 class="card-title">Welcome, Dr. <%= user.getName() %></h4>
            <p><strong>Email:</strong> <%= user.getEmail() %></p>
            <p><strong>Specialization:</strong> Cardiology</p>
        </div>
    </div>

    <!-- Appointments Table -->
    <div class="card">
        <div class="card-header bg-primary text-white">
            <h5 class="mb-0">Your Appointments</h5>
        </div>
        <div class="card-body">
            <table class="table table-hover">
                <thead class="table-dark">
                <tr>
                    <th>Patient Name</th>
                    <th>Date</th>
                    <th>Time</th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <%
                    if (appointments != null && !appointments.isEmpty()) {
                        for (Appointment app : appointments) {
                            if (app.getDoctor().equals(user.getName())) {
                %>
                <tr>
                    <td><%= app.getName() %></td>
                    <td><%= app.getDate() %></td>
                    <td><%= app.getTime() %></td>
                    <td>
                        <span class="badge bg-warning text-dark">Pending</span>
                    </td>
                    <td>
                        <form method="post" action="AcceptAppointmentServlet">
                            <input type="hidden" name="appointmentId" value="<%= app.getName() + app.getDate() + app.getTime() %>">
                            <button type="submit" class="btn btn-success btn-sm">Accept</button>
                        </form>
                    </td>
                </tr>
                <%
                        }
                    }
                } else {
                %>
                <tr>
                    <td colspan="5" class="text-center">No appointments found.</td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>