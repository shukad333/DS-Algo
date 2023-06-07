package com.advanced.functional;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


@FunctionalInterface
interface TriFunction<A,B,C,R> {

    R apply(A a, B b, C c);

    default <V> TriFunction<A, B, C, V> andThen(
            Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (A a, B b, C c) -> after.apply(apply(a, b, c));
    }
}


class CheckForNull implements Predicate {
    @Override
    public boolean test(Object o) {
        return o != null;
    }
}

public class FunctionalEx {

    public static void main(String[] args) {

        Consumer<Integer> c = (a) -> {
            System.out.println(a);
        };

        c.accept(12);

        TriFunction<Boolean, Integer, Long, String> tri = (x,y,z) -> ""+x+","+y+","+z;
        System.out.println(tri.apply(false,2,3l));;

//        Arrays.stream()

    }
}
