package com.mashibing.dp.observerMMY;

public class ObserverB implements Observer{
    private Boolean OIsOverFive;
    @Override
    public void resolveEvent(Event event) {
        Subject s = (Subject) event.getSource();
        update(event.getState(), event.getTime());
    }

    @Override
    public void update(Integer updateNum,long time) {
        OIsOverFive = updateNum > 5;
        System.out.println("B观察者状态改为："+ OIsOverFive+" "+time);
    }
}
