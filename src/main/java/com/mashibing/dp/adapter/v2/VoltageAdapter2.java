package com.mashibing.dp.adapter.v2;

public class VoltageAdapter2 implements IVoltage5V{
    private final Voltage220V voltage220V;

    public VoltageAdapter2 () {
        this.voltage220V = new Voltage220V();
    }

    @Override
    public int outPut5V() {
        return voltage220V.output220V()/44;
    }
}
