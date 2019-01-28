package com.general.geeks.misc;

/**
 * Given an array nums of n integers where n > 1, return an array output such
 * that output[i] is equal to the product of all the elements of nums except
 * nums[i].
 * 
 * Example:
 * 
 * Input: [1,2,3,4] Output: [24,12,8,6] Note: Please solve it without division
 * and in O(n).
 * 
 * Follow up: Could you solve it with constant space complexity? (The output
 * array does not count as extra space for the purpose of space complexity
 * analysis.)
 * 
 * @author skadavath
 *
 */
public class ProductOfArrayExceptSelf {
	
	public static void main(String[] args) {
		
		System.out.println(new ProductOfArrayExceptSelf().productExceptSelf(new int[] {1,2,3,4}));
		
	}

	public int[] productExceptSelf(int[] nums) {
		
		int l = nums.length;
		int[] resp = new int[l];
		resp[0] = 1;
		for(int i=1;i<l;i++)
			resp[i] = nums[i-1] * resp[i-1];
		
		int r=1;
		
		for(int i=l-1;i>=0;i--) {
			resp[i] = resp[i] * r;
			r = r * nums[i];
		}
			
		
		return resp;

	}

}
