<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Patient - MediCare</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../Home.css">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <a class="navbar-brand" href="../index.jsp">MediCare</a>
</nav>

<div class="container mt-4">
    <h2 class="text-center">Prendre un Rendez-vous</h2>
    <form action="${pageContext.request.contextPath}/ReserveServlet" method="post">
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
            <input type="date" class="form-control" name="dateReservation" id="dateReservation" required>
        </div>

        <button type="submit" class="btn btn-success mt-3 w-100">Réserver</button>
    </form>
</div>

<div class="container mt-5">
    <h3 class="text-center">Mes Rendez-vous</h3>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Date</th>
            <th>Motif</th>
            <th>Statut</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>2025-02-22</td>
            <td>Consultation Générale</td>
            <td>Confirmé</td>
            <td><button class="btn btn-danger btn-sm">Annuler</button></td>
        </tr>
        <tr>
            <td>2025-02-25</td>
            <td>Suivi Médical</td>
            <td>En attente</td>
            <td><button class="btn btn-danger btn-sm">Annuler</button></td>
        </tr>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>