package com.mashibing.dp.observerMMY.observerAndCOR;

public class Client {
    public static void main(String[] args) {
        RegistrationRequest request = new RegistrationRequest("mmy", "mamawai513@163.ccom");
        HandlerChain handlerChain = new HandlerChain();
        handlerChain.forward(request);
    }
}
