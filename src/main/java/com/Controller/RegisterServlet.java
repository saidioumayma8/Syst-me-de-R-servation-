package com.Controller;

import com.DAO.PatientDAO;
import com.DAO.DoctorDAO;
import com.DAO.UserDao;
import com.Model.Patient;
import com.Model.Doctor;
import com.Model.User;
import com.Model.Role;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private PatientDAO patientDAO;
    private DoctorDAO doctorDAO;
    private UserDao userDAO;

    @Override
    public void init() {
        try {
            userDAO = new UserDao();
            patientDAO = new PatientDAO();
            doctorDAO = new DoctorDAO();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String role = req.getParameter("role");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");

        if ("patient".equals(role)) {
            User user = new User(name, email, password, new Role("Patient"));
            int userId = 0;
            try {
                userId = userDAO.addUser(user);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            if (userId != -1) {
                Patient patient = new Patient(name, email, password, new Role("Patient"), phone);
                int patientId = patientDAO.addPatient(patient);
                if (patientId != -1) {
                    res.sendRedirect("Patient/Patient.jsp");
                } else {
                    req.setAttribute("errorMsg", "Failed to register patient details.");
                    req.getRequestDispatcher("/Register.jsp").forward(req, res);
                }
            } else {
                req.setAttribute("errorMsg", "Failed to register user.");
                req.getRequestDispatcher("/Register.jsp").forward(req, res);
            }
        } else if ("doctor".equals(role)) {
            User user = new User(name, email, password, new Role("Doctor"));
            int userId = 0;
            try {
                userId = userDAO.addUser(user);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            if (userId != -1) {
                String specialty = req.getParameter("specialty");
                Doctor doctor = new Doctor( name, email, password, new Role("doctor"), specialty);
                int doctorId = doctorDAO.addDoctor(doctor);
                if (doctorId != -1) {
                    res.sendRedirect("Doctor/Doctor.jsp");
                } else {
                    req.setAttribute("errorMsg", "Failed to register doctor details.");
                    req.getRequestDispatcher("/Register.jsp").forward(req, res);
                }
            } else {
                req.setAttribute("errorMsg", "Failed to register user.");
                req.getRequestDispatcher("/Register.jsp").forward(req, res);
            }
        } else {
            req.setAttribute("errorMsg", "Invalid role.");
            req.getRequestDispatcher("/Register.jsp").forward(req, res);
        }
    }
}


