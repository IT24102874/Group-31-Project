<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            padding: 20px;
        }
        .dashboard-card {
            padding: 20px;
            border-radius: 10px;
            background-color: #f8f9fa;
        }
        .card-box {
            padding: 15px;
            border-radius: 8px;
            color: white;
        }
        .card-blue {
            background-color: #0d6efd;
        }
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
                    <p>1,234</p>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card-box card-blue">
                    <h5>Pending Approvals</h5>
                    <p>5</p>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card-box card-blue">
                    <h5>Marked for Deletion</h5>
                    <p>12</p>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card-box card-blue">
                    <h5>System Logs</h5>
                    <p>87</p>
                </div>
            </div>
        </div>

        <!-- Manage User Accounts -->
        <h4>Manage User Accounts</h4>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Username</th>
                <th>Role</th>
                <th>Email</th>
                <th>Status</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>john123</td>
                <td>Patient</td>
                <td>john@example.com</td>
                <td><button class="btn btn-danger btn-sm">Delete</button></td>
            </tr>
            <tr>
                <td>doc.kate</td>
                <td>Doctor</td>
                <td>kate@example.com</td>
                <td><button class="btn btn-danger btn-sm">Delete</button></td>
            </tr>
            <tr>
                <td>mike456</td>
                <td>Patient</td>
                <td>mike@example.com</td>
                <td><button class="btn btn-danger btn-sm">Delete</button></td>
            </tr>
            </tbody>
        </table>

        <!-- Approve Payments -->
        <h4>Approve Payments</h4>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Payment ID</th>
                <th>Patient</th>
                <th>Amount</th>
                <th>Status</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1001</td>
                <td>john123</td>
                <td>$200.00</td>
                <td>
                    <button class="btn btn-success btn-sm">Approve</button>
                </td>
            </tr>
            <tr>
                <td>1002</td>
                <td>mike456</td>
                <td>$150.00</td>
                <td>
                    <button class="btn btn-danger btn-sm">Reject</button>
                </td>
            </tr>
            </tbody>
        </table>

        <a href="logout.jsp" class="btn btn-secondary mt-3">Logout</a>
    </div>
</div>

</body>
</html>
