package com.mashibing.dp.composite.MMY;

import java.util.ArrayList;
import java.util.List;

public class Folder extends Component{

    List<Component> components;

    public Folder(String name) {
        super(name);
        components = new ArrayList<>();
    }

    public Folder addComponent(Component component){
        components.add(component);
        return this;
    }

    public void removeComponent(Component component){
        components.remove(component);
    }
    @Override
    public void display(int depth) {
        for (int i = 0;i<depth;i++) System.out.print("--");
        getName();
        for (Component component : components){
            component.display(depth+1);
        }
    }

    @Override
    public void getName() {
        System.out.println(name);
    }
}
