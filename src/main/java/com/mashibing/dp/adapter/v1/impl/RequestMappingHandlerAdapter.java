package com.mashibing.dp.adapter.v1.impl;

import com.mashibing.dp.adapter.v1.HandlerAdapter;
import com.mashibing.dp.adapter.v1.handler.impl.RequestMappingHandler;

public class RequestMappingHandlerAdapter implements HandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof RequestMappingHandler);
    }

    @Override
    public void handle(Object handler) {
        ((RequestMappingHandler) handler).handleRequest();
    }
}
