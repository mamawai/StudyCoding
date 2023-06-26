package com.mashibing.dp.state.thread;

public class Action {
    enum msg {start,end,over}
    private msg m;
    public msg getMsg(){
        return m;
    }

    public void setM(msg m) {
        this.m = m;
    }
}
