<%@ page import="java.util.List" %>
<%@ page import="models.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Appointment Scheduling</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5 mb-5">
    <div class="card shadow-lg p-4">
        <h2 class="mb-4 text-center">Book an Appointment</h2>
        <form action="<%= request.getContextPath() %>/appointment" method="post">
            <!-- Patient Details -->
            <div class="mb-3">
                <label for="patientName" class="form-label">Full Name</label>
                <input type="text" class="form-control" id="patientName" name="patientName" required>
            </div>
            <div class="mb-3">
                <label for="patientAge" class="form-label">Age</label>
                <input type="number" class="form-control" id="patientAge" name="patientAge" required>
            </div>
            <div class="mb-3">
                <label for="contactNumber" class="form-label">Contact Number</label>
                <input type="tel" class="form-control" id="contactNumber" name="contactNumber" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Gender</label>
                <select class="form-select" name="gender" required>
                    <option value="" disabled selected>Select Gender</option>
                    <option>Male</option>
                    <option>Female</option>
                    <option>Other</option>
                </select>
            </div>

            <!-- Doctor Selection -->
            <div class="mb-3">
                <label for="doctorSelect" class="form-label">Choose Doctor</label>
                <select class="form-select" id="doctorSelect" name="doctor" required>
                    <option value="" disabled selected>Select Doctor</option>
                    <%
                        List<User> doctorList = (List<User>) request.getAttribute("doctorList");
                        if (doctorList != null) {
                            for (User doctor : doctorList) {
                    %>
                    <option><%= doctor.getName() %> - <%= doctor.getRole() %></option>
                    <%
                            }
                        }
                    %>
                </select>
            </div>

            <!-- Date and Time -->
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="appointmentDate" class="form-label">Preferred Date</label>
                    <input type="date" class="form-control" id="appointmentDate" name="appointmentDate" required>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="appointmentTime" class="form-label">Preferred Time</label>
                    <input type="time" class="form-control" id="appointmentTime" name="appointmentTime" required>
                </div>
            </div>

            <!-- Urgency Questionnaire -->
            <h5 class="mt-4">Urgency Assessment</h5>
            <div class="mb-3">
                <label class="form-label">1) Are you experiencing severe chest pain or pressure?</label>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="q1" value="a" required>
                    <label class="form-check-label">Yes, it is unbearable</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="q1" value="b">
                    <label class="form-check-label">Mild to moderate level pain</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="q1" value="c">
                    <label class="form-check-label">No</label>
                </div>
            </div>

            <div class="mb-3">
                <label class="form-label">2) Are you having trouble breathing or feeling dizzy/faint?</label>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="q2" value="a" required>
                    <label class="form-check-label">Yes, severe difficulty</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="q2" value="b">
                    <label class="form-check-label">Mild difficulty</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="q2" value="c">
                    <label class="form-check-label">No</label>
                </div>
            </div>

            <div class="mb-4">
                <label class="form-label">3) Have you had a heart attack or serious heart condition before?</label>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="q3" value="a" required>
                    <label class="form-check-label">Yes, multiple times</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="q3" value="b">
                    <label class="form-check-label">Yes, once</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="q3" value="c">
                    <label class="form-check-label">No</label>
                </div>
            </div>

            <!-- Confirm Button -->
            <div class="d-grid">
                <button type="submit" class="btn btn-primary btn-lg">Confirm and Proceed to Payment</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
