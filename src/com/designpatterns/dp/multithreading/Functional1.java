package com.designpatterns.dp.multithreading;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Functional1 {

    public static void main(String[] args) {

        Function<Integer,String> fn = (integer) ->integer+" r ";
        System.out.println(fn.apply(12));

        Consumer<String> cosumer = s-> {System.out.println(s+" ccc ");};
        cosumer.accept("XXXX ");

        Supplier<String> supplier = ()->{return "shu";};
        System.out.println(supplier.get());

        Predicate<Integer> predicate = (s) -> s>=100;
        System.out.println(predicate.test(10));
        System.out.println(predicate.test(101));

    }
}
