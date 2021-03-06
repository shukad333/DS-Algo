package com.general.geeks.misc;

import java.util.Arrays;

/**
 * Given an array consists of non-negative integers, your task is to count the
 * number of triplets chosen from the array that can make triangles if we take
 * them as side lengths of a triangle. Example 1: Input: [2,2,3,4] Output: 3
 * Explanation: Valid combinations are: 2,3,4 (using the first 2) 2,3,4 (using
 * the second 2) 2,2,3 Note: The length of the given array won't exceed 1000.
 * The integers in the given array are in the range of [0, 1000].
 * 
 * @author skadavath
 *
 */
public class ValidTriangleNumber {
	
	public static void main(String[] args) {
		
		System.out.println(new ValidTriangleNumber().triangleNumber(new int[] {2,2,3,4}));
		
	}

	public int triangleNumber(int[] nums) {
		
		int size = nums.length;
		
		int resp = 0;
		
		Arrays.sort(nums);
		
		for(int i=2;i<size;i++) {
			int left=0,right=i-1;	
			while(left<right) {
				
				if(nums[left]+nums[right]>nums[i]) {
					resp += (right-left);
					right--;
				}
				else
					left++;
				
			}
			
		}
		
		return resp;

	}

}
