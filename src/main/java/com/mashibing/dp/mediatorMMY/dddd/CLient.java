package com.mashibing.dp.mediatorMMY.dddd;

public class CLient {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();
        CA ca = new CA(mediator);
        CB cb = new CB(mediator);
        ca.send("我要请你吃饭");
        cb.send("好呀！谢谢你老A");
    }
}
