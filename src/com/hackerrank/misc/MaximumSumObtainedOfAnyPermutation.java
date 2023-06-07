package com.hackerrank.misc;

import java.util.Arrays;

public class MaximumSumObtainedOfAnyPermutation {


    public static void main(String[] args) {

        new MaximumSumObtainedOfAnyPermutation().maxSumRangeQuery(new int[]{1,2,3,4,5},new int[][]{{1,3},{0,1}});

    }


    public int maxSumRangeQuery(int[] A, int[][] req) {
        long res = 0, mod = (long)1e9 + 7;
        int n = A.length, count[] = new int[n];
        for (int[] r: req) {
            count[r[0]] += 1;
            if (r[1] + 1 < n)
                count[r[1] + 1] -= 1;
        }
        for (int i = 1; i < n; ++i)
            count[i] += count[i - 1];
        Arrays.sort(A);
        Arrays.sort(count);
        for (int i = 0; i < n; ++i)
            res += (long)A[i] * count[i];
        return (int)(res % mod);
    }




}
