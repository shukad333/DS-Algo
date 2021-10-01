package com.geeks.hackerrank;

import java.util.*;

 class Solution {


    public static void main(String[] args) {
//
//        String s = "ababacdad";
//
//        process(s);


        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        process(s);

    }

    private static int getUniq(String s) {
        Set<Character> set = new HashSet<>();
        int uniq = 0;
        for(char c : s.toCharArray()) {
            if(set.add(c)) {
                uniq += c-'a'+1;
            }
        }

        return uniq;
    }


    private static  int dotP(int[] X , int[] R) {

        int MOD = 1000_000_00_7;

        int resp = 0;
        for(int i=0;i<X.length;i++) {

            resp += (X[i] * R[i]) % MOD;
        }

        return resp;
    }

    private static void process(String s) {

        Map<Character,Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++) {
            map.put(s.charAt(i),i);
        }


        int curr = 0;
        List<Integer> resp = new ArrayList<>();
        for(int i=0;i<s.length();i++) {

            int val = map.get(s.charAt(i));
            curr = Math.max(curr,val);
            if(curr<=i) {
                resp.add(i+1);
            }

        }







        int[] X = new int[resp.size()] , R = new int[resp.size()];

        for(int i=0;i<resp.size();i++) {

            X[i] = i==0?resp.get(i):resp.get(i)-resp.get(i-1);
            R[i] = getUniq(i==0?s.substring(0,resp.get(i)): s.substring(resp.get(i-1),resp.get(i)));
        }

        System.out.println(Arrays.toString(X));

        System.out.println(Arrays.toString(R));

        int dot = dotP(X,R);
        System.out.println(dot);
    }
}
