package org.example;
import java.util.Arrays;
import java.util.List;

public class Product {
    private int productId;
    private String brand;
    private String model;
    private String specifications;
    private String price;
    private Color[] colors;

    public Product(int productId,String brand, String model, String specifications, String price, org.example.Color[] colors) {
        this.productId = productId;
        this.brand = brand;
        this.model = model;
        this.specifications = specifications;
        this.price = price;
        this.colors = colors;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Color[] getColors() {
        return colors;
    }

    public void setColors(Color[] colors) {
        this.colors = colors;
    }


}
