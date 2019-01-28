package com.general.geeks.array.dynamicprogramming;

/**
 * Given two integer arrays A and B, return the maximum length of an subarray
 * that appears in both arrays.
 * 
 * Example 1: Input: A: [1,2,3,2,1] B: [3,2,1,4,7] Output: 3 Explanation: The
 * repeated subarray with maximum length is [3, 2, 1]. Note: 1 <= len(A), len(B)
 * <= 1000 0 <= A[i], B[i] < 100
 * 
 * @author skadavath
 *
 */
public class MaxLengthOfRepeatedSubArray {
	
	public static void main(String[] args) {
		System.out.println(new MaxLengthOfRepeatedSubArray().findLength(new int[] {1, 2,3,2,1},new int[] {3,2,1,4,7}));
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
