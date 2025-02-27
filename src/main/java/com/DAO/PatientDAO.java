package com.DAO;

import com.utils.DatabaseConnection;
import com.Model.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PatientDAO {

    private Connection connection = DatabaseConnection.getInstance().getConnection();

    public int ajouterPatient(Patient patient) {
        String sql = "INSERT INTO patient (name, phone, email, password) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, patient.getName());
            stmt.setString(2, patient.getPhone());
            stmt.setString(3, patient.getEmail());
            stmt.setString(4, patient.getPassword());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                try (var generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1);  // Return generated patient ID
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}