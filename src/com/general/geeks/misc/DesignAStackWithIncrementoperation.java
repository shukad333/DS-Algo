package com.general.geeks.misc;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class DesignAStackWithIncrementoperation {

    public static void main(String[] args) {

        Map<Integer,Integer> map = null;
       // System.out.println(map.isEmpty());
        List<Integer> list = Arrays.asList();
        System.out.println(list.stream().findAny().get().toString());

    }

    Stack<Integer> stack = new Stack<>();
    int[] inc;
    int n;
    public DesignAStackWithIncrementoperation(int maxSize) {

        inc = new int[maxSize];
        n = maxSize;

    }

    public void push(int x) {

        if(stack.size()<n)
            stack.push(x);

    }

    public int pop() {

        int i = stack.size();
        if(i<0)
            return -1;
        if(i>0)
        inc[i-1] += inc[i];

        int popped =  stack.pop()+inc[i];
        inc[i] = 0;
        return popped;


    }

    public void increment(int k, int val) {

        int i = Math.min(k,stack.size())-1;
        if(i>0)
            inc[i] += val;


    }
}
