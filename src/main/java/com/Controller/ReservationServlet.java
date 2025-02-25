package com.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.Model.Reservation;
import com.DAO.PatientDAO;
import com.DAO.ReservationDAO;

@WebServlet("/ReserveServlet")
public class ReservationServlet extends HttpServlet {

    private ReservationDAO reservationDAO;
    private PatientDAO patientDAO;

    @Override
    public void init() {
        reservationDAO = new ReservationDAO();
        patientDAO = new PatientDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        RequestDispatcher rd = req.getRequestDispatcher("/pages/reservation/create.jsp");
        rd.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String patientName = req.getParameter("PatientName");
        String patientPhone = req.getParameter("PatientPhone");
        String status = req.getParameter("Status");
        String motif = req.getParameter("Motif");
        String dateString = req.getParameter("dateReservation");

        int patientID = validatePatient(patientName, patientPhone);

        if (patientID != -1) {
            Date dateReservation = null;
            try {
                dateReservation = (dateString != null && !dateString.isEmpty()) ?
                        new SimpleDateFormat("yyyy-MM-dd").parse(dateString) : new Date();
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            Reservation reservation = new Reservation(patientID, status, motif, dateReservation);

            reservationDAO.ajouterReservation(reservation, 1);

            res.sendRedirect("liste-reservations.jsp");
        } else {
            req.setAttribute("error", "Invalid patient details.");
            req.getRequestDispatcher("/pages/reservation/create.jsp").forward(req, res);
        }
    }

    private int validatePatient(String patientName, String patientPhone) {
        int patientID = -1;
        if (patientName != null && !patientName.isEmpty()) {
            patientID = patientDAO.ajouterPatient(patientName, patientPhone);
        }
        return patientID;
    }
}



