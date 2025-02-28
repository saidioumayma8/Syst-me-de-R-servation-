package com.DAO;

import com.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {

    public  boolean loginByUserNameAndPassword(String username,String password) throws SQLException {

        String sql = "INSERT INTO patient (name, phone, email, password) VALUES (?, ?, ?, ?)";
        Connection connection = DatabaseConnection.conect();
        try (PreparedStatement stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, username);
            stmt.setString(4, password);

            if (stmt.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
