package com.Controller;

import com.DAO.PatientDAO;
import com.utils.DatabaseConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private Connection connection;

    public void PatientDAO() throws SQLException {
        this.connection = DatabaseConnection.getConnection();
    }
    private PatientDAO patientDAO;
    @Override
    public void init() throws ServletException {
        super.init();
        try {
            patientDAO = new PatientDAO();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("Login Success for user: " + username);

        response.sendRedirect("/webapp/Patient/Patient.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect("login.jsp");

        PatientDAO.getConnection();
    }
}
