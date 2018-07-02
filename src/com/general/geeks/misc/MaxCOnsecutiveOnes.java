package com.general.geeks.misc;

import java.util.Stack;

/**
 * Given a binary array, find the maximum number of consecutive 1s in this
 * array.
 * 
 * Example 1: Input: [1,1,0,1,1,1] Output: 3 Explanation: The first two digits
 * or the last three digits are consecutive 1s. The maximum number of
 * consecutive 1s is 3. Note:
 * 
 * The input array will only contain 0 and 1. The length of input array is a
 * positive integer and will not exceed 10,000
 * 
 * @author skadavath
 *
 */
public class MaxCOnsecutiveOnes {
	
	public static void main(String[] args) {
		System.out.println(new MaxCOnsecutiveOnes().findMaxConsecutiveOnes(new int[] {1,1,0,1,1,1}));
	}

	public int findMaxConsecutiveOnes(int[] nums) {
		
		
		Stack<Integer> stack= new Stack<>();
		int max = Integer.MIN_VALUE;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]==1) {
				stack.push(nums[i]);
			}
			else {
				if(stack.size()>max) {
					max = stack.size();
				}
				stack.clear();
			}
		}
		return max>stack.size()?max:stack.size();

	}

}
