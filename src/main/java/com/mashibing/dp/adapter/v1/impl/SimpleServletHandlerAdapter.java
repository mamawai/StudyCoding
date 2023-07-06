package com.mashibing.dp.adapter.v1.impl;

import com.mashibing.dp.adapter.v1.HandlerAdapter;
import com.mashibing.dp.adapter.v1.handler.impl.SimpleServletHandler;

public class SimpleServletHandlerAdapter implements HandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof SimpleServletHandler);
    }

    @Override
    public void handle(Object handler) {
        ((SimpleServletHandler) handler).handleRequest();
    }
}
