package com.general.geeks.misc;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find
 * the one that is missing from the array.
 * 
 * Example 1
 * 
 * Input: [3,0,1] Output: 2 Example 2
 * 
 * Input: [9,6,4,2,3,5,7,0,1] Output: 8
 * 
 * Note: Your algorithm should run in linear runtime complexity. Could you
 * implement it using only constant extra space complexity?
 * 
 * @author skadavath
 *
 */
public class MissingNumber {
	
	public static void main(String[] args) {
		
		int[] nums = {0,2,1,5,4};
		System.out.println(new MissingNumber().missingNumber(nums));
	}

	public int missingNumber(int[] nums) {
		if(nums.length==0) {
			return -1;
		}
		
		int sum = (nums.length)*(nums.length+1)/2;
		
		int localSum = 0;
		for(int i : nums) {
			localSum+=i;
		}
		
		return sum-localSum;
	}

}
