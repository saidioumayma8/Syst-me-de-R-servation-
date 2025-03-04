package com.DAO;

import com.Model.Doctor;
import com.Model.Patient;
import com.Model.Role;
import com.Model.User;
import com.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegesterDao {

    public static int createUser(User user, Role role) throws SQLException {
        // Use try-with-resources for connection and statements
        String roleQuery = "SELECT id FROM role WHERE TRIM(role_name) = ?";
        String userQuery = "INSERT INTO user (name, email, password, role_id) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement roleStmt = conn.prepareStatement(roleQuery);
             PreparedStatement stmt = conn.prepareStatement(userQuery, PreparedStatement.RETURN_GENERATED_KEYS)) {

            // Get the role_id from the Role table
            roleStmt.setString(1, role.getRoleName());
            System.out.println("Executing query: " + roleQuery + " with role: " + role.getRoleName());
            ResultSet rs = roleStmt.executeQuery();

            if (!rs.next()) {
                throw new SQLException("Role not found: " + role.getRoleName());
            }

            int roleId = rs.getInt("id");
            System.out.println("Role ID found: " + roleId);

            // Insert into users table
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setInt(4, roleId);

            int rowsAffected = stmt.executeUpdate();
            System.out.println("Rows affected by user insertion: " + rowsAffected);

            // Get generated user_id
            int userId = 0;
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    userId = generatedKeys.getInt(1);
                    System.out.println("Generated user ID: " + userId);
                }
            }

            return userId;

        } catch (SQLException e) {
            e.printStackTrace(); // Log exception
            throw e; // Re-throw exception after logging it
        }
    }

    public static void createDoctor(Doctor doctor) throws SQLException {
        String query = "INSERT INTO doctor (userID, specialty) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, doctor.getUserId());
            stmt.setString(2, doctor.getSpecialty());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(); // Log exception
            throw e; // Re-throw exception after logging it
        }
    }

    public static void createPatient(Patient patient) throws SQLException {
        String query = "INSERT INTO patient (id, telephone) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, patient.getUserId());
            stmt.setString(2, patient.getPhone());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(); // Log exception
            throw e; // Re-throw exception after logging it
        }
    }
}
