package com.Controller;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.Model.Reservation;
import utils.DatabaseConnection;
import com.DAO.PatientDAO;
import com.DAO.ReservationDAO;

@WebServlet("/ReserveServlet")
public class ReservationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String patientName = request.getParameter("PatientName");
        String patientPhone = request.getParameter("PatientPhone");
        int patientID = -1;

        try (Connection connection = DatabaseConnection.getConnection()) {

            PatientDAO patientDAO = new PatientDAO(connection);
            ReservationDAO reservationDAO = new ReservationDAO(connection);

            if (patientName != null && !patientName.isEmpty()) {
                patientID = patientDAO.ajouterPatient(patientName, patientPhone);
            } else {
                patientID = Integer.parseInt(request.getParameter("PatientID"));
            }

            int medID = 1;
            String status = request.getParameter("Status");
            String motif = request.getParameter("Motif");

            String dateString = request.getParameter("dateReservation");
            Date dateReservation;

            if (dateString != null && !dateString.isEmpty()) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                dateReservation = sdf.parse(dateString);
            } else {
                dateReservation = new Date(); // Default to today
            }

            Reservation reservation = new Reservation(patientID, status, motif, dateReservation);
            reservationDAO.ajouterReservation(reservation, medID);

            response.sendRedirect("liste-reservations.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("index.jsp");
        }
    }
}
