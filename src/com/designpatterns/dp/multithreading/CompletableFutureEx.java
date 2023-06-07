package com.designpatterns.dp.multithreading;

import java.util.Objects;
import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;


class Point {
    int x , y;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        String s;
        
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
public class CompletableFutureEx {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> cf = CompletableFuture.supplyAsync(()->{

                try {
                    System.out.println("Wiating execution");
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();


            }

                return "Shu";
        });

        CompletableFuture<String> litchi = cf.thenApply((name)->{return "Litchi says hi to "+name;});
        System.out.println(litchi.get());
    }

}
