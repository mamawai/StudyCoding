package com.mashibing.dp.adapter.v1;

import com.mashibing.dp.adapter.v1.handler.Handler;
import com.mashibing.dp.adapter.v1.impl.HttpRequestHandlerAdapter;
import com.mashibing.dp.adapter.v1.impl.RequestMappingHandlerAdapter;
import com.mashibing.dp.adapter.v1.impl.SimpleServletHandlerAdapter;

import java.util.ArrayList;
import java.util.List;

public class DispatcherServlet {
    List<HandlerAdapter> handlerAdapters = new ArrayList<>();
    {
        handlerAdapters.add(new HttpRequestHandlerAdapter());
        handlerAdapters.add(new RequestMappingHandlerAdapter());
        handlerAdapters.add(new SimpleServletHandlerAdapter());
    }
    public void doDispatch(Handler handler){
        /*这里的获取适配器 在源码里实际是是获取适配器接口 比如大体上可以获取A B C三个适配器接口，而ABC三个接口又有很多个实现类 如
        A1A2A3 比如A2去适配，适配到了A接口调用handleRequest这一接口方法 进而再调用A2自己的handleRequest方法*/
        HandlerAdapter handlerAdapter = getHandlerAdapter(handler);
        assert handlerAdapter != null;
        handlerAdapter.handle(handler);
    }

    private HandlerAdapter getHandlerAdapter(Handler handler) {
        for (HandlerAdapter adapter : this.handlerAdapters){
            if (adapter.supports(handler)){
                return adapter;
            }
        }
        return null;
    }
}
