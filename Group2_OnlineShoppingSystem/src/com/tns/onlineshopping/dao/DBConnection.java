package com.tns.onlineshopping.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/shopping";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() {
        Connection connection = null;

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create connection
            connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            System.out.println("✅ Database connection successful.");
        } catch (ClassNotFoundException e) {
            System.out.println("⚠ JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("⚠ Connection failed.");
            e.printStackTrace();
        }

        return connection;
    }

    // ✅ Main method for testing
    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                conn.close();
                System.out.println("✅ Connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
