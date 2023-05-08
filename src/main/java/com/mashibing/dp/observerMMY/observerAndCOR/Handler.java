package com.mashibing.dp.observerMMY.observerAndCOR;

import java.util.Observable;
import java.util.Observer;

public abstract class Handler extends Observable {
    public abstract void handleRequest(RegistrationRequest request,HandlerChain handlerChain);
}
