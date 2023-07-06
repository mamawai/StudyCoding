package com.mashibing.dp.adapter.v1.handler.impl;

import com.mashibing.dp.adapter.v1.handler.Handler;

public class HttpRequestHandler implements Handler {

    @Override
    public void handleRequest() {
        System.out.println("HttpRequest...");
    }
}
