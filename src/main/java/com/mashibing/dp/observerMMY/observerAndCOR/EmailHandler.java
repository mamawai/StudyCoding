package com.mashibing.dp.observerMMY.observerAndCOR;

import java.util.regex.Pattern;

public class EmailHandler extends Handler{
    @Override
    public void handleRequest(RegistrationRequest request, HandlerChain handlerChain) {
        String email = request.getEmail();
        String regex = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.com+$";
        boolean emailIsValid = Pattern.matches(regex, email);
        if (emailIsValid){
            handlerChain.forward(request);
            setChanged();
            notifyObservers("Congratulations！Passed Validation！");
        }else {
            setChanged();
            notifyObservers(" validation failed");
        }
    }
}
