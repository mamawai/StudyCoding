package com.mashibing.dp.mmy.Factory;

public class F1 implements Factory {

    @Override
    public AP createProductA() {
        return new AP1();
    }

    @Override
    public BP createProductB() {
        return new BP1();
    }

    @Override
    public CP createProductC() {
        return new CP1();
    }
}
