package com.mashibing.dp.adapter.v1.impl;

import com.mashibing.dp.adapter.v1.HandlerAdapter;
import com.mashibing.dp.adapter.v1.handler.impl.HttpRequestHandler;

public class HttpRequestHandlerAdapter implements HandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof HttpRequestHandler);
    }

    @Override
    public void handle(Object handler) {
        ((HttpRequestHandler) handler).handleRequest();
    }
}
