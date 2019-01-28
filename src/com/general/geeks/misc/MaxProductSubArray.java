package com.general.geeks.misc;

/**
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * @author skadavath
 *
 */
public class MaxProductSubArray {
	
	public static void main(String[] args) {
		
		int[] arr = {2,3,0,-2,-4};
		
		System.out.println(new MaxProductSubArray().maxProduct(arr));
		
	}

	public int maxProduct(int[] nums) {
		
		
		int resp  = nums[0];
		int min = nums[0],max = nums[0];
		
		for(int i=1;i<nums.length;i++) {
			
			int temp = max;
			max = Math.max(Math.max(nums[i]*max, nums[i]*min), nums[i]);
			min = Math.min(Math.min(nums[i]*temp, nums[i]*min), nums[i]);
			if(max>resp)
				resp = max;
			
		}
		return resp;

	}

}
