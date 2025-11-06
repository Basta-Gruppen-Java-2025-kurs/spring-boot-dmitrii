package com.example.hello_spring.model.dto;

public class ProductRequestDTO {
    private String name;
    private double price;

    private String internalRating;

    public ProductRequestDTO(String name, double price) {
        this.name = name;
        this.price = price;
        this.internalRating = "";
    }

    public ProductRequestDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getInternalRating() {
        return internalRating;
    }

    public void setInternalRating(String internalRating) {
        this.internalRating = internalRating;
    }
}
