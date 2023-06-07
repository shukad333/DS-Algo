package com.general.geeks.misc;

import java.util.TreeMap;

public class RangeFrequencyQueries {

    public static void main(String[] args) {

        TreeMap<Integer,Integer> map = new TreeMap<>();
        map.put(12,100);
        map.put(1,5);
        map.put(100,1234);

        System.out.println(map.ceilingKey(2));

    }
}
