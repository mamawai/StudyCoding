package com.mashibing.dp.observerMMY.observerAndCOR;

import java.util.Observable;
import java.util.Observer;

public class SignUpUser implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        String message = (String) arg;
        System.out.println("Registration Result:" + extractName(o.getClass().getSimpleName()) + message);
    }
    private String extractName(String simpleName) {
        int endIndex = simpleName.indexOf("Handler");
        if (endIndex != -1){
            return simpleName.substring(0,endIndex);
        }
        return simpleName;
    }
}
