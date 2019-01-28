package com.general.geeks.misc;

/**
 * Given an array of n positive integers and a positive integer s, find the
 * minimal length of a contiguous subarray of which the sum ≥ s. If there isn't
 * one, return 0 instead.
 * 
 * Example:
 * 
 * Input: s = 7, nums = [2,3,1,2,4,3] Output: 2 Explanation: the subarray [4,3]
 * has the minimal length under the problem constraint. Follow up: If you have
 * figured out the O(n) solution, try coding another solution of which the time
 * complexity is O(n log n).
 * 
 * @author skadavath
 *
 */
public class MinimumSizeSubArraySum {
	
	public static void main(String[] args) {
		
		System.out.println(new MinimumSizeSubArraySum().minSubArrayLen(10, new int[] {2,3,1,2,4,3}));
		
	}

	public int minSubArrayLen(int s, int[] nums) {
		
		int min = Integer.MAX_VALUE;
		
		int j=0,sum=0;
		for(int i=0;i<nums.length;i++) {
			
			sum+=nums[i];
			
			while(sum>=s) {
				min = Integer.min(min, i-j+1);
				sum-=nums[j++];
				
			}
			
		}
		
		return min==Integer.MAX_VALUE?0:min;

	}

}
