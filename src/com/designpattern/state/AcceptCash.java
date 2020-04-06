package com.designpattern.state;

public class AcceptCash extends State {

    @Override
    void updateState(Context context) {
        System.out.println("Accpeted Cash");
    }


    static State getInstance() {
        return new AcceptCash();
    }
}
