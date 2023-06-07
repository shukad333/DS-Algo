package com.designpatterns.dp.multithreading;

import java.util.Random;

public class ThreadLocalEx extends Thread{

    ThreadLocal<Integer> tl = new ThreadLocal<>();

    void setTl(int i) {
        tl.set(i);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        Random rnd = new Random();
        tl.set(rnd.nextInt(100));
        System.out.println(tl.get());
    }

    public static void main(String[] args) {

        ThreadLocalEx t1 = new ThreadLocalEx();
        ThreadLocalEx t2 = new ThreadLocalEx();

        t1.start();
        t2.start();


    }
}
