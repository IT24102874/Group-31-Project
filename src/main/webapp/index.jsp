<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cardiology Appointment System</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Bootstrap & Google Fonts -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;700&display=swap" rel="stylesheet">

    <style>
        body {
            font-family: 'Poppins', sans-serif;
            background-color: #f9f9f9;
        }

        .hero-section {
            background: linear-gradient(rgba(0,0,0,0.4), rgba(0,0,0,0.6)), url('<%= request.getContextPath() %>/images/banner1.jpg') no-repeat center center;
            background-size: cover;
            color: white;
            padding: 100px 0;
            text-align: center;
        }

        .hero-section h1 {
            font-size: 48px;
            font-weight: 700;
        }

        .hero-section p {
            font-size: 20px;
            font-weight: 300;
        }

        .features {
            padding: 60px 0;
            background-color: white;
        }

        .features .card {
            transition: all 0.3s ease;
        }

        .features .card:hover {
            transform: scale(1.05);
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.15);
        }

        footer {
            background-color: #f1f1f1;
            text-align: center;
            padding: 20px 0;
            font-size: 14px;
        }
    </style>
</head>
<body>

<!-- NAVBAR -->
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

<!-- HERO SECTION -->
<section class="hero-section">
    <div class="container">
        <h1>Welcome to CardioCare</h1>
        <p>Your trusted platform for cardiology appointments with top specialists</p>
        <a href="<%= request.getContextPath() %>/register.jsp" class="btn btn-lg btn-light mt-4">Register Now</a>
    </div>
</section>

<!-- FEATURES SECTION -->
<section class="features">
    <div class="container">
        <div class="text-center mb-5">
            <h2>Why Choose Us?</h2>
            <p class="text-muted">We provide seamless and secure cardiology appointment services</p>
        </div>
        <div class="row g-4">
            <div class="col-md-4">
                <div class="card p-4 h-100 text-center">
                    <img src="<%= request.getContextPath() %>/images/experts.jpg" alt="Cardiologist">

                    <h5>Expert Cardiologists</h5>
                    <p>Consult with highly qualified and experienced specialists.</p>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card p-4 h-100 text-center">
                    <img src="<%= request.getContextPath() %>/images/easyAppointment.jpg" class="img-fluid mb-3 rounded" alt="Easy Booking">
                    <h5>Easy Appointment</h5>
                    <p>Book appointments quickly and manage your schedule online.</p>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card p-4 h-100 text-center">
                    <img src="<%= request.getContextPath() %>/images/secure.jpg" class="img-fluid mb-3 rounded" alt="Secure Data">
                    <h5>Secure Platform</h5>
                    <p>Your information is safe and confidential with us.</p>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- FOOTER -->
<footer>
    &copy; 2025 CardioCare | All rights reserved.
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
