package com.mashibing.dp.state.thread;

import static com.mashibing.dp.state.thread.Action.msg.end;
import static com.mashibing.dp.state.thread.Action.msg.start;

public class RunningState implements ThreadState_ {
    private Thread_ t;

    public RunningState(Thread_ t) {
        this.t = t;
    }

    @Override
    public void move(Action input) {
        if(input.getMsg()== end) {
            t.state = new TerminatedState(t);
            t.run();
        }
    }

    @Override
    public void run() {
        System.out.println("运行一个线程");
        Action action = new Action();
        action.setM(end);
        t.move(action);
    }
}
