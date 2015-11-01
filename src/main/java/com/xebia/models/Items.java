package com.xebia.models;

public class Items {

    private int quantity;
    private String name;
    private double price;
    public Items(){}
    public Items(int quantity, String name, double price){
        this.quantity = quantity;
        this.name = name;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

}