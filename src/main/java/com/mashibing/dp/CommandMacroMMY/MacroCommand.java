package com.mashibing.dp.CommandMacroMMY;

import java.util.ArrayList;
import java.util.List;

public class MacroCommand implements Command {
    List<Command> commandList;
    public MacroCommand(){
        commandList = new ArrayList<>();
    }
    @Override
    public void execute() {
        for (Command command : commandList){
            command.execute();
        }
    }

    // @Override
    public void addCommand(Command command) {
        commandList.add(command);
    }

    // @Override
    public void removeCommand(Command command) {
        if (!commandList.isEmpty()){
            if(commandList.remove(command)){
                System.out.println("成功移除命令");
            }else {
                System.out.println("命令不存在");
            }
        }
    }
}
