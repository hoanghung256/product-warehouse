package com.app.models;

import com.app.Configuration;

/**
 *
 * @author hoang hung
 */
public class Product {
    private int id;
    private String name;
    private int quantity;
    private int price;
    private String imagePath;

    public Product() {
    }
    
    public Product(String name, int quantity, int price, String imagePath) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.imagePath = imagePath;
    }

    public Product(int id, String name, int quantity, int price, String imagePath) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.imagePath = imagePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    
    @Override
    public String toString() {
        return Configuration.gson.toJson(this);
    }
}
