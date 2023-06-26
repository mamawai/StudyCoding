package com.mashibing.dp.state.thread;

public class Thread_ {
    ThreadState_ state;

    public void setState(ThreadState_ state) {
        this.state = state;
    }

    public void move(Action input) {
        state.move(input);
    }

    public void run() {
        state.run();
    }


}
