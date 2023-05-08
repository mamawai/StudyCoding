package com.mashibing.dp.observerMMY;

public interface Observer {
    void resolveEvent(Event event);
    void update(Integer updateNum,long time);
}
