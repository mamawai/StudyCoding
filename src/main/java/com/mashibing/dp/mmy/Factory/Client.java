package com.mashibing.dp.mmy.Factory;

public class Client {
    public static void main(String[] args) {
        new F1().createProductA().workA();
        new F2().createProductB().workB();
        new F2().createProductC().workC();
    }
}
