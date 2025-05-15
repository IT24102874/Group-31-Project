<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            display: flex;
            background-color: #f4f6f9;
        }
        .sidebar {
            width: 250px;
            background-color: #2c3e50;
            color: white;
            height: 100vh;
            padding: 20px;
            position: fixed;
        }
        .sidebar h2 {
            margin: 0;
            font-size: 24px;
            margin-bottom: 20px;
        }
        .sidebar a {
            color: white;
            text-decoration: none;
            display: block;
            padding: 10px;
            margin-bottom: 10px;
            border-radius: 5px;
        }
        .sidebar a:hover {
            background-color: #34495e;
        }
        .main-content {
            margin-left: 270px;
            padding: 20px;
            width: calc(100% - 270px);
        }
        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: white;
            padding: 10px 20px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            margin-bottom: 20px;
        }
        .overview {
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            gap: 20px;
            margin-bottom: 20px;
        }
        .card {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            text-align: center;
        }
        .card h3 {
            margin: 0;
            font-size: 18px;
            color: #2c3e50;
        }
        .card p {
            font-size: 24px;
            margin: 10px 0 0;
            color: #e74c3c;
        }
        .table-container {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            margin-bottom: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f4f6f9;
        }
        .chart-placeholder {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            text-align: center;
        }
        .chart-placeholder img {
            max-width: 100%;
            height: auto;
        }
        @media (max-width: 768px) {
            .sidebar {
                width: 200px;
            }
            .main-content {
                margin-left: 220px;
                width: calc(100% - 220px);
            }
            .overview {
                grid-template-columns: 1fr;
            }
        }
    </style>
</head>
<body>
<div class="sidebar">
    <h2>Exam System</h2>
    <a href="#exams">Exams</a>
    <a href="#licenses">Licenses</a>
    <a href="#users">Users</a>
    <a href="#analytics">Analytics</a>
    <a href="#settings">Settings</a>
</div>
<div class="main-content">
    <div class="header">
        <h1>Admin Dashboard</h1>
        <div>
            <span>Admin: John Doe</span> | <a href="#logout">Logout</a>
        </div>
    </div>
    <div class="overview">
        <div class="card">
            <h3>Total Exams</h3>
            <p>25</p>
        </div>
        <div class="card">
            <h3>Active Licenses</h3>
            <p>150</p>
        </div>
        <div class="card">
            <h3>Pending Reviews</h3>
            <p>10</p>
        </div>
    </div>
    <div class="table-container">
        <h2>Exams</h2>
        <table>
            <thead>
            <tr>
                <th>Exam Name</th>
                <th>Status</th>
                <th>Date</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Math 101</td>
                <td>Active</td>
                <td>2025-05-01</td>
                <td><a href="#edit">Edit</a> | <a href="#delete">Delete</a></td>
            </tr>
            <tr>
                <td>Science 201</td>
                <td>Draft</td>
                <td>2025-05-15</td>
                <td><a href="#edit">Edit</a> | <a href="#delete">Delete</a></td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="chart-placeholder">
        <h2>Pass/Fail Rate</h2>
        <img src="https://via.placeholder.com/600x300" alt="Pass/Fail Chart">
    </div>
</div>
</body>
</html>