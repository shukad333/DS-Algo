package com.designpatterns.dp.multithreading;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class HO {

    Semaphore hydrogen = new Semaphore(2);
    Semaphore oxygen = new Semaphore(0);

    public static void main(String[] args) throws InterruptedException {

        new HO().print();
    }

    public void print() throws InterruptedException {
        Executor ex = Executors.newFixedThreadPool(2);

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("H");
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("O");
            }
        };
//
        for(int i=0;i<10;i++) {
            printH(r1);
            printO(r2);
            AtomicInteger ai = new AtomicInteger(1);

        }


    }



    private void printH(Runnable hy) throws InterruptedException {
        hydrogen.acquire();
        hy.run();
        oxygen.release();
    }

    private void printO(Runnable ox) throws InterruptedException {
        oxygen.acquire(2);
        ox.run();
        hydrogen.release(2);
    }
}


