package com.mashibing.dp.composite.MMY;

public abstract class Component {
    protected String name;
    public Component(String name){
        this.name = name;
    }
    public abstract void display(int depth);

    public abstract void getName();
}
