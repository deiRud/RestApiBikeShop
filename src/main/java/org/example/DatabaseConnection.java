package org.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseConnection {
    private static HikariDataSource dataSource;


    static {
        Properties properties = new Properties();
        try (InputStream input = DatabaseConnection.class.getClassLoader().getResourceAsStream("database.properties")) {
            if (input == null) {
                System.out.println("unable to find database.properties");
            } else {
                properties.load(input);
                HikariConfig config = new HikariConfig();
                config.setJdbcUrl(properties.getProperty("jdbc.url"));
                config.setUsername(properties.getProperty("jdbc.username"));
                config.setPassword(properties.getProperty("jdbc.password"));
                dataSource = new HikariDataSource(config);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}
