package com.DAO;

import com.Model.User;

import java.sql.*;

public class UserDao {


    private static final String DB_URL = "jdbc:mysql://localhost:3306/medicare"; // Example URL
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public int addUser(User user) throws SQLException {
        String query = "INSERT INTO users (name, email, password, role_name) VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, user.getusername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getRole().getRoleName());

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1); // This returns the auto-generated user ID
                    }
                }
            }
            return -1; // If user could not be inserted
        }
    }

    public void addUser(String username, String password) {
        return;
    }
}
