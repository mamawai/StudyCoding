package com.mashibing.dp.observerMMY;

public class ObserverA implements Observer{
    private Integer Ostate;
    @Override
    public void resolveEvent(Event event) {
        Subject s = (Subject) event.getSource();
        s.fire();
        System.out.println(s.getClass().getName()+"类触发了事件");
        update(event.getState(),event.getTime());
    }

    @Override
    public void update(Integer updateNum,long time) {
        Ostate = updateNum;
        System.out.println("A观察者状态改为："+ Ostate+" "+time);
    }
}
