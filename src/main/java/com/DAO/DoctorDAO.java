package com.DAO;

import com.Model.Doctor;
import com.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DoctorDAO {

    private Connection connection = DatabaseConnection.getInstance().getConnection();

    public int ajouterDoctor(String doctorName, String specialty) {
        String sql = "INSERT INTO doctor (name, specialty) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, doctorName);
            stmt.setString(2, specialty);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1);  // Return generated doctorID
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int ajouterDoctor(Doctor doctor) {

    }
}
