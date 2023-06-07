package com.advanced.functional;

import java.util.ArrayList;
import java.util.function.Supplier;

public class BiSupplier {

    public static void main(String[] args) {


        BiConsumer<String,Integer> bi = (a,b) -> {
            System.out.println(a+"   ->  "+b);
        };

        Supplier<ArrayList> s = ()-> new ArrayList<Integer>();



        bi.accept("Shuhail",12);

        Runnable r1 = ()-> {
            String n  = Thread.currentThread().getName();

            System.out.println(n);
        };

        Thread t = new Thread(r1);
        t.start();
        String n  = Thread.currentThread().getName();
        System.out.println(n);
    }
}

@FunctionalInterface
interface BiConsumer<U,V> {

    void accept(U u , V v);

}
