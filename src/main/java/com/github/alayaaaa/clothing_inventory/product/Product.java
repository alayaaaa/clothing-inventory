package com.github.alayaaaa.clothing_inventory.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Product {

    private int id;
    private String name;
    private String category;
    private double price;
    private int stockCount;

    public Product(int id, String name, String category, double price, int stockCount) {

        this.id = id;
        this.name = name;
     
    }

    public int getId() {

        return id;

    }

    public String getName() {

        return name;

    }

    public String getCategory() {

        return category;

    }

    public double getPrice() {

        return price;

    }

    public int getStockCount() {

        return stockCount;

    }

    public void setStockCount(int stockCount) {

        this.stockCount = stockCount;

    }

}