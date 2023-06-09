package com.mashibing.dp.bridge.MMYBridge;

public abstract class Computer {
    protected Brand brand;

    public Computer(Brand brand){
        this.brand = brand;
    }

    public abstract String name();
}
