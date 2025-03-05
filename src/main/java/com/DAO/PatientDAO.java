package com.DAO;

import com.utils.DatabaseConnection;
import com.Model.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/medicare";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    private Connection connection;

    public PatientDAO() throws SQLException {
        this.connection = DatabaseConnection.getConnection();
    }

    private static final String SELECT_PATIENTS =
            "SELECT u.id, u.name, u.email, u.password, p.telephone " +
                    "FROM user u " +
                    "JOIN patient p ON u.id = p.id";

    public static void getConnection() {
    }

    public List<Patient> getPatientList() {
        List<Patient> patients = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_PATIENTS);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Patient patient = new Patient(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        null,
                        rs.getString("telephone")
                );

                patients.add(patient);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }

    public int addPatient(Patient patient) {
        String sql = "INSERT INTO patient (name, email, password, telephone) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, patient.getusername());
            stmt.setString(2, patient.getEmail());
            stmt.setString(3, patient.getPassword());
            stmt.setString(4, patient.getPhone());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1); // Return generated patient ID
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
