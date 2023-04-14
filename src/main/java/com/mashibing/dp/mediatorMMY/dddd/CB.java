package com.mashibing.dp.mediatorMMY.dddd;

public class CB extends Component{
    public CB(Mediator mediator) {
        super(mediator);
    }

    public void send(String message) {
        mediator.sendMessage(message,this);
    }

    public void receive(String message) {
        System.out.println("B接到A的消息："+message);
    }
}
