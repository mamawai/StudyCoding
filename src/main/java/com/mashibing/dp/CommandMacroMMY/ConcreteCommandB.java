package com.mashibing.dp.CommandMacroMMY;

public class ConcreteCommandB implements Command{
    private ReceiverB receiverB;
    public ConcreteCommandB(){
        receiverB = new ReceiverB();
    }
    @Override
    public void execute() {
        receiverB.action();
    }
}
