package com.mashibing.dp.mediatorMMY.ddd;

public class Open extends Employee{
    public Open(String name) {
        super();
        this.name = "【开发】" + name;
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
