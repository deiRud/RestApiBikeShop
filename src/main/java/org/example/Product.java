package org.example;

import java.util.UUID;

public class Product {
    private UUID productId;
    private String brand;
    private String model;
    private String specifications;
    private double price;
    private Color[] colors;

    public Product() {
    }

    public Product(UUID productId,String brand, String model) {
        this.productId = productId;
        this.brand = brand;
        this.model = model;
    }

    public Product(UUID productId, String brand, String model, String specifications, double price, Color[] colors) {
        this.productId = productId;
        this.brand = brand;
        this.model = model;
        this.specifications = specifications;
        this.price = price;
        this.colors = colors;
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Color[] getColors() {
        return colors;
    }

    public void setColors(Color[] colors) {
        this.colors = colors;
    }


}
