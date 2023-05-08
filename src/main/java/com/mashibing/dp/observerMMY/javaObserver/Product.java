package com.mashibing.dp.observerMMY.javaObserver;

import java.util.Observable;

class Product extends Observable {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
        setChanged();
        notifyObservers();
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

