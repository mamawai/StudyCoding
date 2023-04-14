package com.mashibing.dp.mediatorMMY.ddd;

public class Test extends Employee{
    public Test(String name) {
        super();
        this.name = "【测试】" + name;
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
