package com.designpatterns.dp.multithreading;

import java.util.Queue;

public class ProducerConsumerWaitNotify {
}


class ProducerW extends Thread {

    final int MAX_ALLOWED = 10;
    Queue<String> queue;
    String s;

    @Override
    public void run() {
        while(true) {

            synchronized (queue) {
                while (queue.size() == MAX_ALLOWED) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                queue.notifyAll();
            }
        }
    }
}
