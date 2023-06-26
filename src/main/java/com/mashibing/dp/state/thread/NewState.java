package com.mashibing.dp.state.thread;

import static com.mashibing.dp.state.thread.Action.msg.end;
import static com.mashibing.dp.state.thread.Action.msg.start;

public class NewState implements ThreadState_ {
    private Thread_ t;

    public NewState(Thread_ t) {
        this.t = t;
    }

    @Override
    public void move(Action input) {
        if(input.getMsg() == start) {
            t.state = new RunningState(t);
            t.run();
        }
    }

    @Override
    public void run() {
        System.out.println("new 一个线程");
        Action action = new Action();
        action.setM(start);
        t.move(action);
    }
}
