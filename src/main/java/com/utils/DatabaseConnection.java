package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/doctorrv";
            String user = "root";
            String password = "root";
            Connection connection = null;
             Class.forName("com.mysql.jdbc.Driver");
             try {
                 connection = DriverManager.getConnection(url, user, password);
             } catch (SQLException e) {
                 e.printStackTrace();
             }

            return connection;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

