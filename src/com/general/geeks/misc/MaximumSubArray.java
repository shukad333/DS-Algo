package com.general.geeks.misc;

/**
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 * 
 * Example:
 * 
 * Input: [-2,1,-3,4,-1,2,1,-5,4], Output: 6 Explanation: [4,-1,2,1] has the
 * largest sum = 6. Follow up:
 * 
 * If you have figured out the O(n) solution, try coding another solution using
 * the divide and conquer approach, which is more subtle.
 * 
 * 
 * @author skadavath
 *
 */
public class MaximumSubArray {

	public int maxSubArray(int[] nums) {
		
		int[] dp = new int[nums.length+1];
		dp[0] = nums[0];
		
		int max = nums[0];
		
		for(int i=1;i<nums.length;i++) {
			
			dp[i] = nums[i] + (dp[i-1]>0 ? dp[i-1] : 0);
			max = Math.max(max, dp[i]);
		}
		return max;

	}
	
	public int maxSubArrayApproach2(int[] nums) {
		int maxEndingHere = nums[0],maxSoFar = nums[0];
		for(int i=1;i<nums.length;i++) {
			maxEndingHere = Math.max(nums[i], nums[i]+maxEndingHere);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}
		
		return maxSoFar;
	}

}
