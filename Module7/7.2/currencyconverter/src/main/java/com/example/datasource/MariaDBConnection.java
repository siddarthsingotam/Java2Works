package com.example.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDBConnection {

    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(
                        "jdbc:mariadb://localhost:3306/currency_app?user=appuser&password=password123");
            } catch (SQLException e) {
                System.out.println("Connection failed");
                return null;
            }
        }
        return conn;
    }

    // Method to close the connection
    public static void terminate() {
        if (conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

