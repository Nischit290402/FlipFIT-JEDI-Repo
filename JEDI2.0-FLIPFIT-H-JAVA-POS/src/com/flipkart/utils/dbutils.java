package com.flipkart.utils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class dbutils {
    private static Connection connection = null;
    public static Connection getConnection() throws SQLException {
        if (connection != null) {
            return connection;
        }
        else{
            String url = "jdbc:mysql://localhost:3306/flipfit";
            String user = "root";
            String password = "root@123";
            connection = DriverManager.getConnection(url, user, password);
        }

        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
