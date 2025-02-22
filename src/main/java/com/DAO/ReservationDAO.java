package com.DAO;

import com.Model.Reservation;
import utils.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {
    private Connection connection;

    public ReservationDAO(Connection connection) {
        this.connection = connection;
    }

    public void ajouterReservation(Reservation reservation, int medID) throws SQLException {
        String sql = "INSERT INTO reservation (MedID, PatientID, Status, Motif, dateReservation) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, medID);
            statement.setInt(2, reservation.getPatientID());
            statement.setString(3, reservation.getStatus());
            statement.setString(4, reservation.getMotif());
            statement.setDate(5, new java.sql.Date(reservation.getDateReservation().getTime()));
            statement.executeUpdate();
        }
    }

    public List<Reservation> getReservations() throws SQLException {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM reservation";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Reservation reservation = new Reservation();
                reservation.setReservID(resultSet.getInt("reservID"));
                reservation.setMedID(resultSet.getInt("MedID"));
                reservation.setPatientID(resultSet.getInt("PatientID"));
                reservation.setDateReservation(resultSet.getTimestamp("dateReservation"));
                reservation.setStatus(resultSet.getString("Status"));
                reservations.add(reservation);
            }
        }
        return reservations;
    }
}
