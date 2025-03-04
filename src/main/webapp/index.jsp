<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MediCare - Accueil</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="Home.css">
</head>
<body>


<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <a class="navbar-brand" href="#">MediCare</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ms-auto">
            <li class="nav-item">
                <a class="nav-link" href="Patient/Patient.jsp">Espace Patient</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="doctor/Doctor.jsp">Espace Médecin</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="Login.jsp">Login</a>
            </li>

        </ul>
    </div>
</nav>

<div class="container text-center mt-5">
    <h1 class="fw-bold">Bienvenue sur MediCare</h1>
    <p class="lead">Prenez rendez-vous médical en ligne et suivez vos consultations en toute simplicité.</p>

    <a href="Patient/Patint.jsp" class="btn btn-success btn-lg me-3">Espace Patient</a>
    <a href="doctor/Doctor.jsp" class="btn btn-primary btn-lg">Espace Médecin</a>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
