<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2 class="mt-5">Register</h2>

    <c:if test="${not empty errorMsg}">
        <div class="alert alert-danger">
                ${errorMsg}
        </div>
    </c:if>

    <form action="RegisterServlet" method="POST">

        <div class="form-group">
            <label for="role">I am a:</label>
            <select class="form-control" id="role" name="role" required>
                <option value="Patient">Patient</option>
                <option value="Doctor">Doctor</option>
            </select>
        </div>


        <div class="form-group">
            <label for="username">Username</label>
            <input type="text" class="form-control" id="username" name="username" required>
        </div>

        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>

        <div id="patientFields">
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" class="form-control" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="phone">Phone</label>
                <input type="text" class="form-control" id="phone" name="phone" required>
            </div>
        </div>

        <div id="doctorFields" style="display: none;">
            <div class="form-group">
                <label for="specialization">Specialization</label>
                <input type="text" class="form-control" id="specialization" name="specialization">
            </div>
        </div>

        <button type="submit" class="btn btn-primary">Register</button>
    </form>
</div>

<script>
    document.getElementById("role").addEventListener("change", function () {
        var patientFields = document.getElementById("patientFields");
        var doctorFields = document.getElementById("doctorFields");

        if (this.value === "Doctor") {
            doctorFields.style.display = "block";
            patientFields.style.display = "none";
        } else {
            doctorFields.style.display = "none";
            patientFields.style.display = "block";
        }
    });
</script>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
