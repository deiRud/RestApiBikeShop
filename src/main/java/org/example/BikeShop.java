package org.example;
import static spark.Spark.*;

public class BikeShop {
    public static void main(String[] args) {
        port(8002);

        get("/hello", (req, res) -> "Hello, Bike Shop");

        get("/products", (req, res) -> "Hello. " + req.params(":name"));
    }
}