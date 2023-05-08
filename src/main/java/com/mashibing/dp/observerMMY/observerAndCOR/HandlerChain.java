package com.mashibing.dp.observerMMY.observerAndCOR;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class HandlerChain {
    List<Handler> handlers = new ArrayList<>();
    int index = 0;
    /**
     * 构造方法初始化chain
     */
    public HandlerChain(){
        addObserverToAll(
                createObject(SignUpUser.class),
                createObject(UsernameHandler.class),
                createObject(EmailHandler.class)
        );
    }
    private void addObserverToAll(Observer observer,Handler... handlers) {
        for (Handler handler : handlers){
            handler.addObserver(observer);
            this.handlers.add(handler);
        }
    }
    private static<T> T createObject(Class<T> clazz){
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public void forward(RegistrationRequest request){
        if (index == handlers.size()) {
            return;
        }
        Handler handler = handlers.get(index);
        index++;
        handler.handleRequest(request,this);
    }

}
