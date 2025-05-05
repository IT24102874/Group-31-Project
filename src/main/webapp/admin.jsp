<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            min-height: 100vh;
            background-color: #f8f9fa;
        }
        .sidebar {
            height: 100vh;
            position: fixed;
            top: 0;
            left: 0;
            width: 250px;
            background-color: #343a40;
            color: white;
            padding-top: 20px;
        }
        .sidebar a {
            color: white;
            padding: 10px;
            display: block;
            text-decoration: none;
        }
        .sidebar a:hover {
            background-color: #495057;
        }
        .content {
            margin-left: 250px;
            padding: 20px;
        }
    </style>
</head>
<body>
<div class="sidebar">
    <h4 class="text-center">Admin Dashboard</h4>
    <a href="#dashboard">Dashboard</a>
    <a href="#user-mgmt">User Management</a>
    <a href="#payment-approval">Payment Approvals</a>
    <a href="#reports">Reports</a>
    <a href="#logout">Logout</a>
</div>
<div class="content">
    <h2 id="dashboard">Dashboard Overview</h2>
    <p>Welcome, Admin! Use the sidebar to manage users, approve payments, and view reports.</p>

    <section id="user-mgmt">
        <h3>User Management</h3>
        <button class="btn btn-primary mb-2">Add User</button>
        <table class="table table-striped">
            <thead>
            <tr><th>Name</th><th>Email</th><th>Role</th><th>Status</th><th>Actions</th></tr>
            </thead>
            <tbody>
            <tr><td>John Doe</td><td>john@example.com</td><td>Editor</td><td>Active</td><td><button class="btn btn-sm btn-warning">Edit</button> <button class="btn btn-sm btn-danger">Delete</button></td></tr>
            </tbody>
        </table>
    </section>

    <section id="payment-approval">
        <h3>Payment Approvals</h3>
        <table class="table table-bordered">
            <thead>
            <tr><th>Transaction ID</th><th>User</th><th>Amount</th><th>Status</th><th>Actions</th></tr>
            </thead>
            <tbody>
            <tr><td>TXN12345</td><td>Jane Smith</td><td>$100</td><td>Pending</td><td><button class="btn btn-sm btn-success">Approve</button> <button class="btn btn-sm btn-secondary">Reject</button></td></tr>
            </tbody>
        </table>
    </section>

    <section id="reports">
        <h3>Reports</h3>
        <p>Select a date range to generate reports.</p>
        <input type="date"> to <input type="date">
        <button class="btn btn-info">Generate</button>
        <div class="mt-3">
            <p><strong>Sales:</strong> $10,000</p>
            <p><strong>New Users:</strong> 50</p>
        </div>
    </section>

    <section id="logout">
        <h3>Logout</h3>
        <button class="btn btn-danger">Logout</button>
    </section>
</div>
</body>
</html>
