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
    public static void main(String[] args) {
        port(8002);

        staticFileLocation("/public");

        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Methods", "GET");
            response.header("Access-Control-Allow-Headers", "Content-Type, Authorization");
        });

        DataSource dataSource = DatabaseConnection.getDataSource();
        ProductDao productDao = new ProductDaoImpl(dataSource);

        get("products/:category", (req, res) -> {
            String category = req.params(":category");
            res.type("application/json");
            Gson gson = new Gson();
            List<Product> products = productDao.getByCategory(category);
            return gson.toJson(products);
        });

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