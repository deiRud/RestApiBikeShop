package org.example;
import com.google.gson.Gson;

import static spark.Spark.*;

public class BikeShop {
    public static void main(String[] args) {
        port(8002);

        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
            response.header("Access-Control-Allow-Headers", "Content-Type, Authorization");
        });

        Product[] mountainbikes = {
                new Product("BULLS", "Copperhead 2 27,5", "Kettenschaltung | 20 Gang", "999,95",
                        new Color[]{new Color("#FF6347", "Copperhead_2_27_5.png"), new Color("#000000", "Copperhead_2_27_5_black.png")}),
                new Product("BULLS", "Copperhead 3 29", "Kettenschaltung | 11 Gang", "1.399,00",
                        new Color[]{new Color("#000000", "Copperhead_3_29_black.png"), new Color("#93C572", "Copperhead_3_29_green.png"), new Color("#75acb4", "Copperhead_3_29_blue.png")}),
                new Product("BULLS", "Sharptail 2 Disc 29", "Kettenschaltung | 27 Gang", "799,99",
                        new Color[]{new Color("#3b3b3b", "Sharptail_3_Disc_29_grey.png"), new Color("#D70040", "Sharptail_3_Disc_29_red.png"), new Color("#a6a6a6", "Sharptail_3_Disc_29_light_grey.png")})
        };

        Product[] emtbs = {
                new Product("KTM", "MACINA KAPOHO 7972", "Kettenschaltung | 12 Gang", "5.899,00",
                        new Color[]{new Color("#D3D3D3", "Macina_kapoho_7972.png")}),
                new Product("KTM", "MACINA KAPOHO 7973", "Kettenschaltung | 20 Gang", "5.299,00",
                        new Color[]{new Color("#000000", "Macina_kapoho_7973_black.png"), new Color("#0096FF", "Macina_kapoho_7973_blue.png")}),
                new Product("BULKTMLS", "MACINA KAPOHO 7971", "Kettenschaltung | 12 Gang", "6.299,00",
                        new Color[]{new Color("#8b0000", "Macina_kapoho_7971_red.png")})
        };

        Product[] accessories = {
                new Product("AXA", "RLC 140 Plus", "", "35,00", new Color[]{new Color("#000000", "rlc_140_plus.png")}),
                new Product("AXA", "RLC PLUS 100/5,5", "", "19,99", new Color[]{new Color("#000000", "rlc_plus_100_5_5.png")}),
                new Product("AXA", "Flex Mount", "", "11,00", new Color[]{new Color("#000000", "flex_mount.png")})
        };

        get("products/:category", (req, res) -> {
            String category = req.params(":category");
            res.type("application/json");
            Gson gson = new Gson();
            return switch (category) {
                case "mountainbikes" -> gson.toJson(mountainbikes);
                case "emtbs" -> gson.toJson(emtbs);
                case "accessories" -> gson.toJson(accessories);
                default -> gson.toJson(new Product[0]);
            };
        });


       // get("/hello", (req, res) -> "A placeholder for a product");

        //get("/products/:name", (req, res) -> "Placement for " + req.params(":name"));
    }
}