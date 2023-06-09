package com.mashibing.dp.bridge.MMYBridge;

public class Desktop extends Computer{
    public Desktop(Brand brand) {
        super(brand);
    }

    @Override
    public String name() {
        return brand.name()+" 台式机";
    }
}
