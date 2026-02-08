package com.exam;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() throws Exception {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver не найден! Проверь Dependencies в Modules.");
            throw e;
        }

        String url = "jdbc:postgresql://localhost:5432/sql227";
        String user = "postgres";
        String password = "20220722";
        return DriverManager.getConnection(url, user, password);
    }
}