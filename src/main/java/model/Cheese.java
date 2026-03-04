package com.checkmarx.cheese.model;

public class Cheese {
    private Long id;
    private String name;
    private String category;
    private String country;
    private double price;
    private int quantity;

    public Cheese() {}

    public Cheese(Long id, String name, String category, String country, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.country = country;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
