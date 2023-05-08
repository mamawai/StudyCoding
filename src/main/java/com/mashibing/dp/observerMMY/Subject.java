package com.mashibing.dp.observerMMY;

public interface Subject {
    // 添加观察者
    void registerObserver(Observer observer);
    // 移除观察者
    void removeObserver(Observer observer);
    // 通知观察者
    void notifyObservers(Integer state);
    // Subject自己的一个方法
    void fire();
}
