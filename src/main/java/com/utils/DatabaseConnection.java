package com.utils;

//import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String dbURI = "jdbc:mysql://localhost:3305/doctorrv?useSSL=false";
    private static final String dbUsername = "root";
    private static final String dbPassword = "admin";

    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                // ✅ Use correct MySQL driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // ✅ Establish the connection
                connection = DriverManager.getConnection(dbURI, dbUsername, dbPassword);
                System.out.println("✅ Database connected successfully!");

            } catch (ClassNotFoundException e) {
                throw new SQLException("❌ MySQL Driver not found. Make sure `mysql-connector-java` is in dependencies.", e);
            } catch (SQLException e) {
                throw new SQLException("❌ Failed to connect to database. Check URL, username, password, and MySQL server.", e);
            }
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("✅ Database connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
