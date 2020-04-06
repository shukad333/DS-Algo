package com.designpattern.state;

public class Context {

    State state;

    public void updateState(State state) {
        this.state = state;
    }
}
