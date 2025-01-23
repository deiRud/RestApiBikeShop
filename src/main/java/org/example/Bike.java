package org.example;

import java.util.UUID;

public class Bike  extends Product{
    private double weight;

    public Bike(UUID productId, String brand, String model, String specifications, double price, Color[] colors, double weight) {
        super(productId, brand, model, specifications, price, colors);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}