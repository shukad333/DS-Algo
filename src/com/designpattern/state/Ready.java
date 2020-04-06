package com.designpattern.state;

public class Ready extends State {

    @Override
    void updateState(Context context) {
        System.out.println("Wending Maching Ready!");
        context.updateState(AcceptCash.getInstance());
    }


    static State getInstance() {
        return new Ready();
    }
}
