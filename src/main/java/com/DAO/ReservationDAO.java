package com.DAO;

import com.Model.Reservation;
import com.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {

    private Connection connection= DatabaseConnection.getInstance().getConnection();

    public ReservationDAO() {
    }

    public void ajouterReservation(Reservation reservation, int medID) {
        String sql = "INSERT INTO reservation (patient_id, status, motif, date_reservation, med_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, reservation.getPatientID());
            stmt.setString(2, reservation.getStatus());
            stmt.setString(3, reservation.getMotif());
            stmt.setDate(4, new java.sql.Date(reservation.getDateReservation().getTime()));  // Convert java.util.Date to java.sql.Date
            stmt.setInt(5, medID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

