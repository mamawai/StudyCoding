package com.mashibing.dp.mmy.Factory;

public class F2 implements Factory {

    @Override
    public AP createProductA() {
        return new AP2();
    }

    @Override
    public BP createProductB() {
        return new BP2();
    }

    @Override
    public CP createProductC() {
        return new CP2();
    }
}
