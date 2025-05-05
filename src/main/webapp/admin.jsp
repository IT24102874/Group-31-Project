<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/dashboard.css">

</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">Admin Dashboard</h2>

    <!-- Show operation status -->
    <%
        String status = request.getParameter("status");
        if (status != null) {
    %>
    <div class="alert alert-info">Action Status: <%= status %></div>
    <%
        }
    %>

    <!-- Payment Approval Section -->
    <div class="card mb-4">
        <div class="card-header">Payment Management</div>
        <div class="card-body">
            <form action="admin" method="post" class="form-inline mb-2">
                <input type="hidden" name="action" value="approvePayment">
                <input type="text" name="paymentId" placeholder="Payment ID" class="form-control mr-2" required>
                <button type="submit" class="btn btn-success">Approve Payment</button>
            </form>
            <form action="admin" method="post" class="form-inline">
                <input type="hidden" name="action" value="rejectPayment">
                <input type="text" name="paymentId" placeholder="Payment ID" class="form-control mr-2" required>
                <button type="submit" class="btn btn-danger">Reject Payment</button>
            </form>
        </div>
    </div>

    <!-- User Management Section -->
    <div class="card">
        <div class="card-header">User Management</div>
        <div class="card-body">
            <!-- Create User -->
            <h5>Create User</h5>
            <form action="admin" method="post" class="form-inline mb-3">
                <input type="hidden" name="action" value="createUser">
                <input type="text" name="username" placeholder="Username" class="form-control mr-2" required>
                <input type="email" name="email" placeholder="Email" class="form-control mr-2" required>
                <input type="text" name="role" placeholder="Role" class="form-control mr-2" required>
                <button type="submit" class="btn btn-primary">Create</button>
            </form>

            <!-- Update User -->
            <h5>Update User</h5>
            <form action="admin" method="post" class="form-inline mb-3">
                <input type="hidden" name="action" value="updateUser">
                <input type="text" name="userId" placeholder="User ID" class="form-control mr-2" required>
                <input type="email" name="email" placeholder="New Email" class="form-control mr-2">
                <input type="text" name="role" placeholder="New Role" class="form-control mr-2">
                <button type="submit" class="btn btn-warning">Update</button>
            </form>

            <!-- Delete User -->
            <h5>Delete User</h5>
            <form action="admin" method="post" class="form-inline">
                <input type="hidden" name="action" value="deleteUser">
                <input type="text" name="userId" placeholder="User ID" class="form-control mr-2" required>
                <button type="submit" class="btn btn-danger">Delete</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
