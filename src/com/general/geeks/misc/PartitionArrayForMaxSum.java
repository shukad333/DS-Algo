package com.general.geeks.misc;

/**
 * Given an integer array A, you partition the array into (contiguous) subarrays
 * of length at most K. After partitioning, each subarray has their values
 * changed to become the maximum value of that subarray.
 * 
 * Return the largest sum of the given array after partitioning.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: A = [1,15,7,9,2,5,10], K = 3 Output: 84 Explanation: A becomes
 * [15,15,15,9,10,10,10]
 * 
 * 
 * Note:
 * 
 * 1 <= K <= A.length <= 500 0 <= A[i] <= 10^6
 * 
 * 
 * 
 * @author skadavath
 *
 */
public class PartitionArrayForMaxSum {
	
	public static void main(String[] args) {
		
		System.out.println(new PartitionArrayForMaxSum().maxSumAfterPartitioning(new int[] {1,15,7,9,2,5,10}, 3));
		
	}

	public int maxSumAfterPartitioning(int[] A, int K) {
		
		int[] dp = new int[A.length];
		
		for(int i=0;i<A.length;i++) {
			
			int currMax = 0;
			for(int k=1;k<=K && k<=i+1;k++) {
				
				currMax = Math.max(currMax, A[i-k+1]);
				dp[i] = Math.max(dp[i], (i>=k?dp[i-k]:0)+currMax*k);
			}
		}
		
		return dp[A.length-1];

	}

}
