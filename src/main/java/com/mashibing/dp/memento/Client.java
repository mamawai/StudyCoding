package com.mashibing.dp.memento;

public class Client {
    public static void main(String[] args) {
        Originator originator1 = new Originator("red", 2, 3);
        CareTaker careTaker = new CareTaker();

        Memento memento = originator1.createMemento();
        careTaker.setMemento(memento);
        careTaker.saveStateInFile("C:/Users/mamingyang/Desktop/BackUp.data");
        System.out.println("修改状态前：" + originator1);
        System.out.println("进行了第一次备份");
        originator1.setY(4);
        originator1.setX(0);
        originator1.setState("blue");

        Memento memento1 = originator1.createMemento();
        careTaker.setMemento(memento1);
        careTaker.saveStateInFile("C:/Users/mamingyang/Desktop/BackUpBlue.data");
        System.out.println("修改状态后：" + originator1);
        System.out.println("修改状态后进行了第二次备份");
        originator1 = careTaker.loadFromFile(originator1,"C:/Users/mamingyang/Desktop/BackUp.data");
        System.out.println("读取第一次备份后：" + originator1);

        originator1 = careTaker.loadFromFile(originator1,"C:/Users/mamingyang/Desktop/BackUpBlue.data");
        System.out.println("读取第二次备份后：" + originator1);
        System.out.println("当前状态：" + originator1);
    }
}
