package com.mashibing.dp.adapter.v2;

public class Phone {
    public void charging(IVoltage5V iVoltage5V){
        int outPut = iVoltage5V.outPut5V();
        if (outPut == 5){
            System.out.println("电压为5V，可以充电");
        }else if (outPut > 5){
            System.out.println("不可充电");
        }
    }
}
