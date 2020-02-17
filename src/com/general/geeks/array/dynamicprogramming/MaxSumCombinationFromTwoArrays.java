package com.general.geeks.array.dynamicprogramming;

/**
 * 
 * Given two arrays arr1[] and arr2[] each of size N. The task is to choose some elements from both the arrays such that no two elements have the same index and no two consecutive numbers can be selected from a single array. Find the maximum sum possible of above-chosen numbers.

Examples:

Input : arr1[] = {9, 3, 5, 7, 3}, arr2[] = {5, 8, 1, 4, 5}
Output : 29
Select first, third and fivth element from the first array.
Select the second and fourth element from the second array.

Input : arr1[] = {1, 2, 9}, arr2[] = {10, 1, 1}
Output : 19
Select last element from the first array and first element from the second array.
 * 
 * @author skadavath
 *
 */
public class MaxSumCombinationFromTwoArrays {
	
	public static void main(String[] args) {
		
		System.out.println(new MaxSumCombinationFromTwoArrays().maxSum(new int[] {9, 3, 5, 7, 3}, new int[] {5, 8, 1, 4, 5}));
		
	}
	
	public int maxSum(int[] arr1 , int[] arr2) {
		
		int[][] dp = new int[arr1.length][2];
		
		for(int i=0;i<arr1.length;i++) {
			
			if(i==0) {
				dp[i][0] = arr1[i];
				dp[i][1] = arr2[i];
				continue;
			}
			
			dp[i][0] = Math.max(dp[i-1][0], arr1[i]+dp[i-1][1]);
			dp[i][1] = Math.max(dp[i-1][1], arr2[i]+dp[i-1][0]);
			
		}
		
		return Math.max(dp[arr1.length-1][0],dp[arr1.length-1][1]);
		
	}

}
