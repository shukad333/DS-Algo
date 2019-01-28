package com.general.geeks.misc;

import java.util.Arrays;

/**
 * Given an unsorted array of integers, find the length of longest increasing
 * subsequence.
 * 
 * Example:
 * 
 * Input: [10,9,2,5,3,7,101,18] Output: 4 Explanation: The longest increasing
 * subsequence is [2,3,7,101], therefore the length is 4. Note:
 * 
 * There may be more than one LIS combination, it is only necessary for you to
 * return the length. Your algorithm should run in O(n2) complexity. Follow up:
 * Could you improve it to O(n log n) time complexity?
 * 
 * 
 * @author skadavath
 *
 */
public class LongestIncreasingSubsequence {
	
	public static void main(String[] args) {
		System.out.println(new LongestIncreasingSubsequence().lengthOfLISDP(new int[] {3,4,5,4,8}));
	}

	 public int lengthOfLIS(int[] nums) {            
	        int[] dp = new int[nums.length];
	        int len = 0;

	        for(int x : nums) {
	            int i = Arrays.binarySearch(dp, 0, len, x);
	            if(i < 0) i = -(i + 1);
	            dp[i] = x;
	            if(i == len) len++;
	        }

	        return len;
	    }
	 
	public int lengthOfLISDP(int[] nums) {
		
		int[] lis = new int[nums.length];
		int max = 0;
		for(int i=0;i<nums.length;i++) {
			lis[i] = 1;
			for(int j=0;j<i;j++) {
				if(nums[j]<nums[i] && lis[i]<lis[j]+1) {
					lis[i] = lis[j]+1;
				}
			}
		}
		for(int i=0;i<nums.length;i++)
			max = Math.max(max, lis[i]);
		
		
		return max;

	}

}
