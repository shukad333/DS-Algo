package com.designpatterns.dp.multithreading;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumer {

    public static void main(String[] args) {
        BlockingQueue<Packet> queue = new LinkedBlockingQueue<>();
        Thread t1 = new Thread(new Producer(queue),"prod");
        Thread t2 = new Thread(new Cosumer(queue),"consumer");

        t1.start();
        t2.start();
    }
}



class Producer implements Runnable {

    BlockingQueue<Packet> queue;
    public Producer(BlockingQueue<Packet> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        for(int i=0;i<100;i++) {
            try {
                Thread.sleep(i*100);
                Packet p = new Packet("message - "+i);
                queue.put(p);
                System.out.println(p.getMessage());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class Cosumer implements Runnable {

    BlockingQueue<Packet> queue;
    public Cosumer(BlockingQueue<Packet> queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        Packet p;
        while(true) {
            try {
                if (!((p=queue.take()).getMessage()!="Exit")) break;
                System.out.println("Consumed "+p.getMessage());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

class Packet {
    String message;

    public Packet(String msg) {
        this.message = msg;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
