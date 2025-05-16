<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Doctor Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Cardio Care</a>
        <div class="d-flex">
            <span class="navbar-text text-white me-3">Logged in as: Dr. S Herath</span>
            <a href="logout.jsp" class="btn btn-outline-light btn-sm">Logout</a>
        </div>
    </div>
</nav>

<div class="container mt-5">
    <!-- Doctor Info -->
    <div class="card mb-4">
        <div class="card-body">
            <h4 class="card-title">Welcome, Dr. S Herath</h4>
            <p><strong>Email:</strong> sherath@gmail.com</p>
            <p><strong>Location:</strong> Floor: 02 Room No: 05</p>
        </div>
    </div>

    <!-- Appointments Table -->
    <div class="card">
        <div class="card-header bg-primary text-white">
            <h5 class="mb-0">Appointments</h5>
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
                <!-- Example Appointment 1 -->
                <tr>
                    <td>Isuri</td>
                    <td>2025-05-10</td>
                    <td>10:00 AM</td>
                    <td><span class="badge bg-warning text-dark">Pending</span></td>
                    <td>
                        <form method="post" action="AcceptAppointmentServlet">
                            <input type="hidden" name="appointmentId" value="101">
                            <button type="submit" class="btn btn-success btn-sm">Accept</button>
                        </form>
                    </td>
                </tr>

                <!-- Example Appointment 2 -->
                <tr>
                    <td>Yonal <span style="color: red; font-weight: bold;">(Urgent)</span></td>
                    <td>2025-05-11</td>
                    <td>02:00 PM</td>
                    <td><span class="badge bg-success">Accepted</span></td>
                    <td></td> <!-- Keep this completely empty -->
                </tr>

                <!-- Add more rows dynamically using JSP/Servlets -->
                </tbody>
            </table>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>