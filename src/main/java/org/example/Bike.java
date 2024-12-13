package org.example;

public class Bike {
    private int bikeId;
    private String nameModel;
    private String company;
    private double price;
    private String description;

    public Bike(int bikeId, String nameModel, String company, double price, String description) {
        this.bikeId = bikeId;
        this.nameModel = nameModel;
        this.company = company;
        this.price = price;
        this.description = description;
    }

    public void setBikeId(int bikeId) {
        this.bikeId = bikeId;
    }

    public String getNameModel() {
        return nameModel;
    }

    public void setNameModel(String nameModel) {
        this.nameModel = nameModel;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBikeId(){
        return "";
    }

}
