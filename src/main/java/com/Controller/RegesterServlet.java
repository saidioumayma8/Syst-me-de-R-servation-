package com.Controller;

import com.Model.Patient;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/RegisterPatientServlet")
public class RegesterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException, ServletException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String phoneNumber = request.getParameter("phoneNumber");

        Patient patient = new Patient(username, email, password, name, phoneNumber);

        boolean isRegistered = patient.register();

        if (isRegistered) {
            response.sendRedirect("login.jsp");
        } else {
            request.setAttribute("errorMsg", "Username already exists");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}

