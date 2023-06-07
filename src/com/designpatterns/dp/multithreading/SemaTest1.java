package com.designpatterns.dp.multithreading;

import java.util.concurrent.Semaphore;

public class SemaTest1 {

    public static void main(String[] args) throws InterruptedException {

        Semaphore s1 = new Semaphore(3);
        System.out.println(s1.availablePermits());
        s1.release();
        System.out.println(s1.availablePermits());
        s1.acquire();
        System.out.println(s1.availablePermits());

    }
}
