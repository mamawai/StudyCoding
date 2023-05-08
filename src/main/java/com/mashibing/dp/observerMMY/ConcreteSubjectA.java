package com.mashibing.dp.observerMMY;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubjectA implements Subject{
    private List<Observer> observers = new ArrayList<>();
    private Integer state;

    public void setState(Integer state) {
        this.state = state;
        notifyObservers(state);
    }
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Integer state) {
        SpecificEvent event = new SpecificEvent(System.currentTimeMillis(), state, this);
        for (Observer observer:observers){
            observer.resolveEvent(event);
        }
    }

    @Override
    public void fire() {
        System.out.println("dadada");
    }
}
