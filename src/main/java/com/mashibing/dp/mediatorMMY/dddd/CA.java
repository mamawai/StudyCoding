package com.mashibing.dp.mediatorMMY.dddd;

public class CA extends Component{
    public CA(Mediator mediator) {
        super(mediator);
    }

    public void send(String messaage) {
        mediator.sendMessage(messaage,this);
    }

    public void receive(String message) {
        System.out.println("A接到B的消息："+message);
    }
}
