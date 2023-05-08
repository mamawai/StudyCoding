package com.mashibing.dp.observerMMY.observerAndCOR;

import java.util.regex.Pattern;

public class UsernameHandler extends Handler {
    @Override
    public void handleRequest(RegistrationRequest request, HandlerChain handlerChain) {
        String username = request.getUsername();
        String regex = "^[a-zA-Z]+$";
        boolean usernameIsValid = Pattern.matches(regex, username);
        if (usernameIsValid){
            // 用户名合法,转发请求
            handlerChain.forward(request);
        }else {
            // 不合法通知观察者
            setChanged();
            notifyObservers(" validation failed");
        }
    }
}
