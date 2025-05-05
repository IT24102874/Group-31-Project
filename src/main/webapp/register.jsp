<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Registration</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #b4ecff;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 100%;
            max-width: 500px;
            margin: 50px auto;
            padding: 20px;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        label {
            font-size: 14px;
            font-weight: bold;
            margin-bottom: 5px;
            display: block;
        }
        input[type="text"], input[type="email"], input[type="password"], select {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        button {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
        }
        button:hover {
            background-color: #42dc75;
        }
        p {
            text-align: center;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>User Registration</h2>

    <form action="<%= request.getContextPath() %>/register" method="post">
        <label for="name">Full Name</label>
        <input type="text" id="name" name="name" required>

        <label for="phone">Phone Number</label>
        <input type="text" id="phone" name="phone" required>

        <label for="email">Email Address</label>
        <input type="email" id="email" name="email" required>

        <label for="role">Role</label>
        <select id="role" name="role" required>
            <option value="">Select a role</option>
            <option value="Doctor">Doctor</option>
            <option value="Patient">Patient</option>
        </select>

        <label for="username">Username</label>
        <input type="text" id="username" name="username" required>

        <label for="password">Password</label>
        <input type="password" id="password" name="password" required>

        <button type="submit">Register</button>

        <p>Already have an account? <a href="<%= request.getContextPath() %>/login.jsp">Login here</a></p>
    </form>
</div>

</body>
</html>