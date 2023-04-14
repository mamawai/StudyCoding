package com.mashibing.dp.mediatorMMY.dddd;

public abstract class Component {
    protected Mediator mediator;
    public Component(Mediator mediator){
        this.mediator = mediator;
        mediator.register(this);
    }
}
