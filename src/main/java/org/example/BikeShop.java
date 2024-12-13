package org.example;
import static spark.Spark.*;

public class BikeShop {
    public static void main(String[] args) {
        port(8002);

        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
            response.header("Access-Control-Allow-Headers", "Content-Type, Authorization");
        });

        get("/hello", (req, res) -> "A placeholder for a product");

        get("/products/:name", (req, res) -> "Placement for " + req.params(":name"));
    }
}