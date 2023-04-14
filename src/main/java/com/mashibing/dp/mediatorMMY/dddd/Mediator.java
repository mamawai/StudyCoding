package com.mashibing.dp.mediatorMMY.dddd;

interface Mediator {
    void sendMessage(String message,Component component);
    void register(Component component);
}
