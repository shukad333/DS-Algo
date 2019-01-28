package com.general.geeks.array;

import java.util.Arrays;

/**
 * Given an integer array, you need to find one continuous subarray that if you
 * only sort this subarray in ascending order, then the whole array will be
 * sorted in ascending order, too.
 * 
 * You need to find the shortest such subarray and output its length.
 * 
 * Example 1: Input: [2, 6, 4, 8, 10, 9, 15] Output: 5 Explanation: You need to
 * sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in
 * ascending order. Note: Then length of the input array is in range [1,
 * 10,000]. The input array may contain duplicates, so ascending order here
 * means <=.
 * 
 * @author skadavath
 *
 */
public class ShortestUnsortedContinousSubArray {
	
	public static void main(String[] args) {
		
		System.out.println(new ShortestUnsortedContinousSubArray().findUnsortedSubarray(new int[] {2, 6, 4, 8, 10, 9, 15}));
	}

	public int findUnsortedSubarray(int[] nums) {
		
		int[] numsCopy = Arrays.copyOf(nums, nums.length);
		
		Arrays.sort(numsCopy);
		
		int s=0,e=nums.length-1;
		
		while(s<nums.length-1 && nums[s]==numsCopy[s])s++;
		while(e>0 && nums[e]==numsCopy[e])e--;
		
		if(s>e)
			return 0;
		return e-s+1;

	}

}
