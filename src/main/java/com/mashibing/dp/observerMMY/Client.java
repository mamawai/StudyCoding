package com.mashibing.dp.observerMMY;

public class Client {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        subject.registerObserver(new ObserverA());
        subject.registerObserver(new ObserverB());
        subject.setState(890);
    }
}
