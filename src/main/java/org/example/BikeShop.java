package org.example;
import com.google.gson.Gson;
import org.example.bikeshop.dao.ProductDao;
import org.example.bikeshop.dao.ProductDaoImpl;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import static spark.Spark.*;


public class BikeShop {
    private static final int PORT = 8002;

    public static void main(String[] args) {
        configureServer();
        DataSource dataSource = DatabaseConnection.getDataSource();
        ProductDao productDao = new ProductDaoImpl(dataSource);
        configureRoutes(productDao);
        testDatabaseConnection(dataSource);
    }

    private static void configureServer() {
        port(PORT);
        staticFileLocation("/public");

        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Methods", "GET");
            response.header("Access-Control-Allow-Headers", "Content-Type, Authorization");
        });
    }

    private static void configureRoutes(ProductDao productDao) {
        get("products/:category", (req, res) -> {
            String category = req.params(":category");
            res.type("application/json");
            Gson gson = new Gson();
            List<Product> products = productDao.getByCategory(category);
            return gson.toJson(products);
        });
    }

    private static void testDatabaseConnection(DataSource dataSource) {
        try (Connection connection = dataSource.getConnection()) {
            if (connection != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }

    }
}