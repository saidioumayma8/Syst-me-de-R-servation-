<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Patient - MediCare</title>
    
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    
    <!-- Link to CSS (correct path) -->
    <link rel="stylesheet" href="../Home.css"> <!-- Adjusted path for patient folder -->
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="../index.jsp">MediCare</a>
  <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" 
          aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="../index.jsp">Home</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="Patient.jsp">Patient <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="../doctor/Doctor.jsp">Doctor</a>
      </li>
    </ul>
  </div>
</nav>

<!-- Patient Form -->
<div class="container mt-4">
    <h2>Patient Form</h2>
<form action="/Medicare/reservation/controller/AjouterReservationServlet" method="post">
    <div class="form-group">
        <label for="PatientName">Nom du Patient</label>
        <input type="text" class="form-control" name="PatientName" id="PatientName" required>
    </div>
    <div class="form-group">
        <label for="PatientPhone">Numéro de Téléphone</label>
        <input type="text" class="form-control" name="PatientPhone" id="PatientPhone" required>
    </div>

    <div class="form-group">
        <label for="Motif">Motif</label>
        <input type="text" class="form-control" name="Motif" id="Motif" required>
    </div>
    <div class="form-group">
        <label for="Status">Statut</label>
        <input type="text" class="form-control" name="Status" id="Status" required>
    </div>

    <div class="form-group">
        <label for="dateReservation">Date de Réservation</label>
        <input type="date" class="form-control" name="dateReservation" id="dateReservation">
    </div>

    <button type="submit" class="btn btn-primary">Réserver</button>
</form>





</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<!-- jQuery -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<!-- Link to JavaScript (correct path) -->
<script src="../Home.js"></script>

</body>
</html>
