package com.mashibing.dp.CommandMacroMMY;

public class Invoker {
    private Command command;
    public void setCommand(Command command){
        this.command = command;
    }
    public void click(){
        System.out.println("点击Invoker");
        command.execute();
    }
}
