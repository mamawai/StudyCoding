package com.mashibing.dp.state.thread;

public class Client {
    public static void main(String[] args) {
        Thread_ thread = new Thread_();
        NewState state = new NewState(thread);
        thread.setState(state);
        thread.run();

    }
}
