package com.mashibing.dp.facadeMMY.entity;

import org.springframework.stereotype.Component;

@Component
public class OrderRequest {

    private Long customerId;
    private double totalAmount;

    @Override
    public String toString() {
        return "OrderRequest{" +
                "customerId=" + customerId +
                ", totalAmount=" + totalAmount +
                '}';
    }

    public OrderRequest() {
    }

    public OrderRequest(Long customerId, double totalAmount) {
        this.customerId = customerId;
        this.totalAmount = totalAmount;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
