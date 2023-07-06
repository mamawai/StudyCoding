package com.mashibing.dp.adapter.v1;

public interface HandlerAdapter {
    boolean supports(Object handler);
    void handle(Object handler);
}
