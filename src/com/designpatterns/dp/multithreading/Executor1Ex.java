package com.designpatterns.dp.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Executor1Ex {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService ex = Executors.newFixedThreadPool(1);
        ex.execute(new NotifyUsers("shu"));
        ex.shutdown();
        ExecutorService ex1 = Executors.newFixedThreadPool(2);
        Future<String> future = ex1.submit(new SendAndRecieve());
        System.out.println(future.get());
        ex1.shutdown();

    }
}

class SendAndRecieve implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "Message";
    }
}



class NotifyUsers implements Runnable {

    String message;
    public NotifyUsers(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println("Executing started, "+Thread.currentThread().getName());
        System.out.println("Message , "+message);
    }
}
