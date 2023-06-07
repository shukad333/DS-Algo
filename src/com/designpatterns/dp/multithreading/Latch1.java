package com.designpatterns.dp.multithreading;

import java.util.concurrent.CountDownLatch;

public class Latch1 {



    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(3);
        ServiceStart ser1 = new ServiceStart("A1",latch);
        ServiceStart ser2 = new ServiceStart("A2",latch);
        ServiceStart ser3 = new ServiceStart("A3",latch);

        ser1.start();
        ser2.start();
        ser3.start();

        latch.await();
        System.out.println("All processed ");



    }

}


class ServiceStart extends Thread {

    String name;
    CountDownLatch latch;
    public ServiceStart(String name, CountDownLatch latch) {
        this.name = name;
        this.latch = latch;
    }
    @Override
    public void run() {
        System.out.println("Starting "+name);
        this.latch.countDown();
    }
}
