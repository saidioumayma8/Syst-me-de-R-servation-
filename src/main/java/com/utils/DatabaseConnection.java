package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static DatabaseConnection instance = null;
    private static Connection connection = null;

    private DatabaseConnection() throws SQLException {
        //init();
    }

    public static DatabaseConnection getInstance() {
        synchronized (DatabaseConnection.class) {
            try {
                if (instance == null || !instance.connection.isClosed()) {
                    instance = new DatabaseConnection();
                }
                return instance;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void closeConnection() {
        if (instance != null) {
            try {
                instance.getConnection().close();
                instance = null;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static Connection conect() throws SQLException {
        final String url = "jdbc:mysql://localhost:3305/doctorrv";
        final String username = "root";
        final String password = "admin";
        try {
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return connection;
    }

    public Connection getConnection() {
        return connection;
    }
}