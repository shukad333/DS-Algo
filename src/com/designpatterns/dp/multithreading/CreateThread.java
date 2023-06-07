package com.designpatterns.dp.multithreading;

public class CreateThread {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MT());
        t1.start();
        t1.join();
        new MT2().start();
    }
}


class MT implements Runnable {
    @Override
    public void run() {
        System.out.println("shu : "+Thread.currentThread().getName());
    }
}

class MT2 extends  Thread {
    @Override
    public void run() {
        System.out.println("XXXX :"+Thread.currentThread().getName());
    }
}
