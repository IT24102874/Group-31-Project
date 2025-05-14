<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>User Login</title>

  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom CSS (optional) -->
  <link rel="stylesheet" href="<%= request.getContextPath() %>/css/styles.css">

  <style>
    body {
      background-color: #b3ecff;
      font-family: Arial, sans-serif;
    }

    .wrapper {
      display: flex;
      width: 90%;
      max-width: 900px;
      background-color: white;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      overflow: hidden;
      margin: 80px auto 40px auto;
    }

    .image-side {
      flex: 1;
      background-image: url('<%= request.getContextPath() %>/images/login.jpg'); /* Make sure this image exists */
      background-size: cover;
      background-position: center;
    }

    .form-side {
      flex: 1;
      padding: 40px 30px;
    }

    h2 {
      margin-bottom: 20px;
      text-align: center;
    }

    .btn-success {
      width: 100%;
    }

    .register-link {
      display: block;
      text-align: center;
      margin-top: 15px;
    }

    @media (max-width: 768px) {
      .wrapper {
        flex-direction: column;
      }

      .image-side {
        height: 200px;
      }
    }
  </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container">
    <a class="navbar-brand" href="<%= request.getContextPath() %>/index.jsp">CardioCare</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" href="<%= request.getContextPath() %>/index.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<%= request.getContextPath() %>/login.jsp">Login</a>
        </li>
      </ul>
    </div>
  </div>
</nav>

<div class="wrapper">
  <div class="image-side"></div>
  <div class="form-side">
    <h2>User Login</h2>
    <form action="<%= request.getContextPath() %>/user_login" method="post">
      <div class="mb-3">
        <label class="form-label">Username</label>
        <input type="text" class="form-control" name="username" required>
      </div>
      <div class="mb-3">
        <label class="form-label">Password</label>
        <input type="password" class="form-control" name="password" required>
      </div>
      <button type="submit" class="btn btn-success">Login</button>
    </form>
    <span class="register-link">Don't have an account?
            <a href="<%= request.getContextPath() %>/register.jsp">Register here</a>
        </span>
  </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
