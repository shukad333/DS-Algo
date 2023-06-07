package com.general.geeks.array.dynamicprogramming;

public class MaximumLengthOfRepeatedSubArray {

    public static void main(String[] args) {

        System.out.println(new MaximumLengthOfRepeatedSubArray().findLength(new int[]{1,2,3,4,5},new int[]{3,4,5,1,2}));

    }

    public int findLength(int[] A, int[] B) {

        int a = A.length;
        int b = B.length;

        if(a==0 || b==0)
            return 0;

        int[][]dp = new int[a+1][b+1];
        int max = 0;
        for(int i=a-1;i>=0;i--) {
            for(int j=b-1;j>=0;j--) {
                max = Math.max(max,dp[i][j] = A[i]==B[j]?1+dp[i+1][j+1] : 0);
            }
        }
        return max;
    }


}
