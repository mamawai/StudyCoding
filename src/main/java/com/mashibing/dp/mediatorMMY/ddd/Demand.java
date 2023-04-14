package com.mashibing.dp.mediatorMMY.ddd;

public class Demand extends Employee{
    public Demand(String name) {
        super();
        this.name = "【需求】" + name;
    }

    @Override
    void receive(String msg) {
        System.out.println(name + "接受到信息：" + msg);
    }

    @Override
    String send(String msg) {
        return msg;
    }
}
