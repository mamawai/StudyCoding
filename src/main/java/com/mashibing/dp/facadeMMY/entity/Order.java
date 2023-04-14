package com.mashibing.dp.facadeMMY.entity;

import com.mashibing.dp.facadeMMY.entity.Customer;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
        name = "cu_or_fk"
            ),
            nullable = false)
    private Customer customer;

    @Column(
            name = "order_Date",
            nullable = false
    )
    private Date orderDate;

    @Column(
            name = "total_Amount",
            nullable = false
    )
    private double totalAmount;


    public Order(Long id, Customer customer, Date orderDate, double totalAmount) {
        this.id = id;
        this.customer = customer;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
    }

    public Order() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerId=" + customer.getId() +
                ", orderDate=" + orderDate +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
