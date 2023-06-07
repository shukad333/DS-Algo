package com.general.geeks.misc;

import java.util.TreeMap;
import java.util.TreeSet;

public class AlexSeat {

    public static void main(String[] args) {

        System.out.println(maxDistToClosest(new int[]{1,0,0,0,1,0,1}));

    }

    public static int maxDistToClosest(int[] seats) {

        TreeSet<Integer> set = new TreeSet<>();
        int n = seats.length;
        for(int i=0;i<n;i++) {
            if(seats[i]==1)
                set.add(i);
        }

        int resp = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            if(seats[i]==1)
                continue;
            if(i==0)
                resp = Math.max(resp,set.ceiling(i)==null?0:set.ceiling(i));
            if(i==n-1)
                resp = Math.max(resp,set.floor(i)==null?0:set.floor(i));

            int left = set.floor(i) == null ? 0 : set.floor(i);
            int right= set.ceiling(i)==null?0:set.ceiling(i);
            resp = Math.max(resp,Math.abs(left-right));
        }

        return resp;

    }


}
