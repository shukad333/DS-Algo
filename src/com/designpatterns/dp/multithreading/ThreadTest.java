package com.designpatterns.dp.multithreading;


import java.util.concurrent.Semaphore;

class TestRunnabel implements Runnable {
    @Override
    public void run() {
        System.out.println("TestRunnable");
    }
}

class TestRunnabel2 implements Runnable {
    @Override
    public void run() {
        System.out.println("TestRunnable - 2");
    }
}



public class ThreadTest implements  Runnable{
    TestRunnabel runnabel =  new TestRunnabel();
    TestRunnabel2 runnabel2 =  new TestRunnabel2();
    Semaphore one = new Semaphore(0);
    Semaphore two = new Semaphore(1);
    public static void main(String[] args) throws InterruptedException {



        ThreadTest t = new ThreadTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t.printH(t.runnabel);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t.printO(t.runnabel2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t.printH(t.runnabel);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();






    }

    void printH(Runnable r) throws InterruptedException {
        one.acquire(1);
        r.run();
        one.release();
    }

    void printO(Runnable r) throws InterruptedException {
//        two.acquire();
        r.run();
        two.release();
        one.release(1);
    }

    @Override
    public void run() {

    }
}
