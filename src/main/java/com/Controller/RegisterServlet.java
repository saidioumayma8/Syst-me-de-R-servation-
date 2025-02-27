package com.Controller;

import com.DAO.PatientDAO;
import com.DAO.DoctorDAO;
import com.Model.Patient;
import com.Model.Doctor;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    private PatientDAO patientDAO;
    private DoctorDAO doctorDAO;

    @Override
    public void init() {
        patientDAO = new PatientDAO();
        doctorDAO = new DoctorDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String role = req.getParameter("role");
        String name = req.getParameter("name");
        String email = req.getParameter("email");  // Now we are handling the email
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");

        if ("patient".equals(role)) {
            Patient patient = new Patient(name, password, phone, email);  // Create patient with email
            int patientId = patientDAO.ajouterPatient(patient);
            if (patientId != -1) {
                res.sendRedirect("Patient/Patient.jsp");
            } else {
                req.setAttribute("errorMsg", "Failed to register patient.");
                req.getRequestDispatcher("/register.jsp").forward(req, res);
            }
        } else if ("doctor".equals(role)) {
            String specialty = req.getParameter("specialty");
            Doctor doctor = new Doctor(name, password, specialty);
            int doctorId = doctorDAO.ajouterDoctor(doctor);
            if (doctorId != -1) {
                res.sendRedirect("Doctor/Doctor.jsp");
            } else {
                req.setAttribute("errorMsg", "Failed to register doctor.");
                req.getRequestDispatcher("/register.jsp").forward(req, res);
            }
        } else {
            req.setAttribute("errorMsg", "Invalid role.");
            req.getRequestDispatcher("/register.jsp").forward(req, res);
        }
    }
}
