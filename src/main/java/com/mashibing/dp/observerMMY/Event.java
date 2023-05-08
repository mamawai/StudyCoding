package com.mashibing.dp.observerMMY;

abstract class Event<T> {
    abstract T getSource();

    abstract Integer getState();
    abstract long getTime();
}
