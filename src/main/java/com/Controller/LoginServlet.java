package com.Controller;

import com.Model.Patient;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Patient patient = new Patient(username, null, password, null, null); // Email is not needed for login
        boolean isValid = patient.validateLogin();

        if (isValid) {
            response.sendRedirect("dashboard.jsp");  // Redirect to the user's dashboard
        } else {
            request.setAttribute("errorMsg", "Invalid username or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}

