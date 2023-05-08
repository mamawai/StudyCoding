package com.mashibing.dp.observerMMY;

public class SpecificEvent extends Event<Subject>{
    long timestamp;
    Integer state;
    Subject source;
    public SpecificEvent(long timestamp, Integer state, Subject source) {
        this.timestamp = timestamp;
        this.state = state;
        this.source = source;
    }
    @Override
    Subject getSource() {
        return source;
    }

    @Override
    Integer getState() {
        return state;
    }

    @Override
    public long getTime() {
        return timestamp;
    }
}
