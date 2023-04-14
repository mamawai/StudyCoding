package com.mashibing.dp.mediatorMMY.dddd;

public class ConcreteMediator implements Mediator{
    private CA ca;
    private CB cb;
    @Override
    public void sendMessage(String message,Component component) {
        if (ca == component){
            cb.receive(message);
        }else if (cb == component){
            ca.receive(message);
        }
    }
    @Override
    public void register(Component component) {
        if (component instanceof CA){
            ca = (CA)component;
        }else if (component instanceof CB){
            cb = (CB)component;
        }
    }
}
