package com.mashibing.dp.observerMMY.javaObserver;

import java.util.Observable;
import java.util.Observer;

class User implements Observer {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Product) {
            Product product = (Product) o;
            System.out.println(name + " 收到产品价格变化通知：产品名称 - " + product.getName() +
                    ", 新价格 - " + product.getPrice());
        } else if (o instanceof Order) {
            Order order = (Order) o;
            System.out.println(name + " 收到订单金额变化通知：订单编号 - " + order.getOrderId() +
                    ", 新金额 - " + order.getTotalAmount());
        }
    }
}

