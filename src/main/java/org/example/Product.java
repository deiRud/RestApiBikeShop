package org.example;

public class Product {
    String brand;
    String model;
    String specifications;
    String price;
    Color[] colors;

    public Product(String brand, String model, String specifications, String price, Color[] colors) {
        this.brand = brand;
        this.model = model;
        this.specifications = specifications;
        this.price = price;
        this.colors = colors;
    }
}
