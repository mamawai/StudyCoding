package com.mashibing.dp.adapter.v1;

import com.mashibing.dp.adapter.v1.handler.impl.HttpRequestHandler;

public class Client {
    public static void main(String[] args) {
        new DispatcherServlet().doDispatch(new HttpRequestHandler());
    }
}
