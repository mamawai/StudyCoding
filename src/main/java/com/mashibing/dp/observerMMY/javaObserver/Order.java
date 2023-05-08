package com.mashibing.dp.observerMMY.javaObserver;

import java.util.Observable;

class Order extends Observable {
    private String orderId;
    private double totalAmount;

    public Order(String orderId, double totalAmount) {
        this.orderId = orderId;
        this.totalAmount = totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
        setChanged();
        notifyObservers();
    }

    public String getOrderId() {
        return orderId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}

