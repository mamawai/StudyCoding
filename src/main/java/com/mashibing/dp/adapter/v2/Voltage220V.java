package com.mashibing.dp.adapter.v2;

public class Voltage220V {
    // 输出220V电压--Adaptee
    public int output220V(){
        int src = 220;
        System.out.println("电压="+src+"伏");
        return src;
    }
}
