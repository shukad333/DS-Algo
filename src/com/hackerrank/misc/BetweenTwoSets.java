package com.hackerrank.misc;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BetweenTwoSets {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] first = new int[n],second = new int[m];

        for(int i=0;i<n;i++)
            first[i] = scanner.nextInt();
        for(int j=0;j<m;j++)
            second[j] = scanner.nextInt();

        Set<Integer> set = new HashSet<>();
        for(int i=1;i<1000;i++) {
            boolean isF = true;
            for(int f : first) {
                isF = i%f==0;
                if(!isF)
                    break;
            }
            if(isF) {
                for(int f : second) {
                    isF = i%f==0;
                    if(!isF)
                        break;
                }
            }

            if(isF)
                set.add(i);

        }

        System.out.println(set.size());

    }
}
