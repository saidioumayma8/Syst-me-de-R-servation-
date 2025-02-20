<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-expand-custom navbar-mainbg">
    <a class="navbar-brand navbar-logo" href="#">MediCare</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <i class="fas fa-bars text-white"></i>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav ml-auto">
            <div class="hori-selector"><div class="left"></div><div class="right"></div></div>
            
            <li class="nav-item ">
                <a class="nav-link" href="patient/Patient.jsp"><i class="far fa-address-book"></i>Patient</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="Doctor/Doctor.jsp"><i class="far fa-copy"></i>Doctor</a>
            </li>
        </ul>
    </div>
</nav>
</body>
</html>