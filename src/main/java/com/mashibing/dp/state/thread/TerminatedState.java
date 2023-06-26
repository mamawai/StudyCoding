package com.mashibing.dp.state.thread;

import static com.mashibing.dp.state.thread.Action.msg.over;

public class TerminatedState implements ThreadState_ {
    private Thread_ t;

    public TerminatedState(Thread_ t) {
        this.t = t;
    }

    @Override
    public void move(Action input) {
        System.out.println("我去垃圾站了");
    }

    @Override
    public void run() {
        System.out.println("线程终止了");
        Action action = new Action();
        action.setM(over);
        t.move(action);
    }
}
