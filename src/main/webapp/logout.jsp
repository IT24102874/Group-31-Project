<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // Invalidate session on page load (logout logic)
    if (session != null) {
        session.invalidate();
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Logout</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<nav class="navbar navbar-dark bg-primary px-4">
    <span class="navbar-brand mb-0 h1">Cardio Care</span>
</nav>

<div class="container bg-white p-5 mt-5 rounded shadow">
    <h2 class="text-center text-danger mb-4">Logging Out...</h2>

    <div class="alert alert-warning text-center" role="alert">
        You are being logged out. Please wait.
    </div>

    <div id="logoutMsg" class="mt-4 text-success fw-bold text-center" style="display: none;">
        You have successfully logged out.
    </div>

    <button class="btn btn-primary w-100 mt-4" id="logoutBtn" onclick="logout()">Logout</button>
</div>

<script>
    function logout() {
        // Just show confirmation message
        document.getElementById("logoutMsg").style.display = "block";

        // Redirect to login page after 2 seconds
        setTimeout(function () {
            window.location.href = "login.jsp"; // Change to your login page path
        }, 2000);
    }
</script>

</body>
</html>
