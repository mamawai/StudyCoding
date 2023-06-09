package com.mashibing.dp.bridge.MMYBridge;

public class Laptop extends Computer{
    public Laptop(Brand brand) {
        super(brand);
    }

    @Override
    public String name() {
        return brand.name()+" 笔记本";
    }
}
