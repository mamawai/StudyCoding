package com.mashibing.dp.mediatorMMY;

public abstract class Component {
    protected Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    // 转发调用
    public void Changed(){
        mediator.componentChanged(this);
    }

    public abstract void update();
}
