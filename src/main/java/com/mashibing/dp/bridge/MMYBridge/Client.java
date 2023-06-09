package com.mashibing.dp.bridge.MMYBridge;

public class Client {
    public static void main(String[] args) {
        Computer computer1 = new Desktop(new Apple());
        Computer computer2 = new Laptop(new HuaWei());
        System.out.println(computer1.name());
        System.out.println(computer2.name());
    }
}
