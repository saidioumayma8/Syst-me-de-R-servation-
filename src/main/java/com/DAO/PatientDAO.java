package com.DAO;

import com.utils.DatabaseConnection;
import java.sql.*;

public class PatientDAO {

    private Connection connection = DatabaseConnection.getInstance().getConnection();

    public PatientDAO() {

    }

    public int ajouterPatient(String patientName, String patientPhone) {
        String sql = "INSERT INTO patient (Username, Telephone) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, patientName);
            stmt.setString(2, patientPhone);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1);  // Return the generated patientID
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
