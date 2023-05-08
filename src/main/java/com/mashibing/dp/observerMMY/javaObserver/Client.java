package com.mashibing.dp.observerMMY.javaObserver;

public class Client {
    public static void main(String[] args) {
        Product product = new Product("手机", 1000.0);
        Order order = new Order("20230506", 2000.0);

        User user1 = new User("Alice");
        User user2 = new User("Bob");

        product.addObserver(user1);
        product.addObserver(user2);
        order.addObserver(user1);
        order.addObserver(user2);

        product.setPrice(800.0);
        order.setTotalAmount(1500.0);
    }
}

