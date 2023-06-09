package com.mashibing.dp.CommandMacroMMY;

public class Client {
    public static void main(String[] args) {
        MacroCommand rootCommand = new MacroCommand();

        MacroCommand macroCommand1 = new MacroCommand();
        macroCommand1.addCommand(new ConcreteCommandA());
        macroCommand1.addCommand(new ConcreteCommandB());

        MacroCommand macroCommand2 = new MacroCommand();
        macroCommand2.addCommand(new ConcreteCommandA());

        ConcreteCommandA concreteCommandA = new ConcreteCommandA();

        rootCommand.addCommand(macroCommand1);
        rootCommand.addCommand(macroCommand2);
        rootCommand.addCommand(concreteCommandA);

        Invoker invoker = new Invoker();
        invoker.setCommand(rootCommand);


        invoker.click();
    }
}
