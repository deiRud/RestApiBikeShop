package org.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class DatabaseConnection {
    private static HikariDataSource dataSource;

    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/online_bike_shop";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "tArakan123!";

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(JDBC_URL);
        config.setUsername(USERNAME);
        config.setPassword(PASSWORD);
        dataSource = new HikariDataSource(config);
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}
