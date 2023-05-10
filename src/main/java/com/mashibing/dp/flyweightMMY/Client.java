package com.mashibing.dp.flyweightMMY;

public class Client {
    public static void main(String[] args) {
        Car car1 = CarFactory.getCar("SedanV6");
        car1.configure("Red","V6",300);
        car1.printConfiguration();

        Car car2 = CarFactory.getCar("SedanV8");
        car2.configure("Blue","V8",400);
        car2.printConfiguration();

        Car sedan = CarFactory.getCar("SedanV6");
        sedan.printConfiguration();
    }
}
