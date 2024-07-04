package com.example.course.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnection {
    private final String url = "url";
    private final String user = "username";
    private final String password = "pass";

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Подключились к Постгрес!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
}
