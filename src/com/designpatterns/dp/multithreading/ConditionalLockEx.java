package com.designpatterns.dp.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionalLockEx {
    public static void main(String[] args) {
        Class<?> clazz = ConditionalLockEx.class;
        clazz.getDeclaredFields();
    }
}

class Item {
    private Object[] t;
    private int curr = 0;
    private final Lock lock;
    private final Condition empty;
    private final Condition full;

    public Item(int cap) {
        this.t = new Object[cap];
        lock = new ReentrantLock();
        empty = lock.newCondition();
        full = lock.newCondition();
    }

    public void add(Object item) throws InterruptedException{
        lock.lock();

        while(curr>=t.length)
            full.await();

        t[curr++] = item;

        empty.signal();
    }
}

class ProducerC extends Thread {

}