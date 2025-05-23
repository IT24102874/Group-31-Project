<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="models.User" %>



<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { padding: 20px; }
        .dashboard-card { padding: 20px; border-radius: 10px; background-color: #f8f9fa; }
        .card-box { padding: 15px; border-radius: 8px; color: white; }
        .card-blue { background-color: #0d6efd; }
    </style>
</head>
<body>

<div class="container">
    <div class="dashboard-card">
        <h2>Admin Dashboard</h2>
        <p>Welcome, System Admin</p>

        <!-- Dashboard Summary Cards -->
        <div class="row mb-4">
            <div class="col-md-3">
                <div class="card-box card-blue">
                    <h5>Total Users</h5>
                    <p>
                        <%
                            List<User> users = (List<User>) request.getAttribute("users");
                            out.print(users != null ? users.size() : 0);
                        %>
                    </p>
                </div>
            </div>
            <!-- Add other summary cards here if needed -->
        </div>

        <!-- Manage User Accounts -->
        <h4>Manage User Accounts</h4>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Username</th>
                <th>Role</th>
                <th>Email</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <%
                if (users != null) {
                    for (User user : users) {
            %>
            <tr>
                <td><%= user.getUserName() %></td>
                <td><%= user.getRole() %></td>
                <td><%= user.getEmail() %></td>
                <td>
                    <form action="deleteUser" method="post" onsubmit="return confirm('Delete user <%= user.getUserName() %>?');">
                        <input type="hidden" name="username" value="<%= user.getUserName() %>">
                        <button type="submit" class="btn btn-danger btn-sm">Delete</button>
                    </form>
                </td>
            </tr>
            <%
                    }
                }
            %>
            </tbody>
        </table>


        <!-- Approve Payments -->
        <h4>Approve Payments</h4>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Reference No</th>
                <th>Patient</th>
                <th>Doctor</th>
                <th>Date</th>
                <th>Time</th>
                <th>Status</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <%
                List<models.Payment> payments = (List<models.Payment>) request.getAttribute("payments");
                if (payments != null && !payments.isEmpty()) {
                    for (models.Payment payment : payments) {
                        models.Appointment appointment = payment.getAppointment();
            %>
            <tr>
                <td><%= payment.getReferenceNumber() %></td>
                <td><%= appointment.getName() %></td>
                <td><%= appointment.getDoctor() %></td>
                <td><%= appointment.getDate() %></td>
                <td><%= appointment.getTime() %></td>
                <td><%= payment.getStatus() %></td>
                <td>
                    <form action="<%= request.getContextPath() %>/ApprovePaymentServlet" method="post" class="d-inline">
                        <input type="hidden" name="referenceNumber" value="<%= payment.getReferenceNumber() %>">
                        <input type="hidden" name="action" value="accept">
                        <button type="submit" class="btn btn-success btn-sm" <%= !"Pending".equals(payment.getStatus()) ? "disabled" : "" %>>
                            Approve
                        </button>
                    </form>
                    <form action="<%= request.getContextPath() %>/ApprovePaymentServlet" method="post" class="d-inline">
                        <input type="hidden" name="referenceNumber" value="<%= payment.getReferenceNumber() %>">
                        <input type="hidden" name="action" value="reject">
                        <button type="submit" class="btn btn-danger btn-sm" <%= !"Pending".equals(payment.getStatus()) ? "disabled" : "" %>>
                            Reject
                        </button>
                    </form>
                </td>
            </tr>
            <%
                }
            } else {
            %>
            <tr>
                <td colspan="7">No payments found.</td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>



        <a href="logout.jsp" class="btn btn-secondary mt-3">Logout</a>
    </div>
</div>

</body>
</html>