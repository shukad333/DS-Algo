package com.general.geeks.maths;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given a circular array (the next element of the last element is the first
 * element of the array), print the Next Greater Number for every element. The
 * Next Greater Number of a number x is the first greater number to its
 * traversing-order next in the array, which means you could search circularly
 * to find its next greater number. If it doesn't exist, output -1 for this
 * number.
 * 
 * Example 1: Input: [1,2,1] Output: [2,-1,2] Explanation: The first 1's next
 * greater number is 2; The number 2 can't find next greater number; The second
 * 1's next greater number needs to search circularly, which is also 2. Note:
 * The length of given array won't exceed 10000.
 * 
 * 
 * @author skadavath
 *
 */
public class NextGreaterElement2 {
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new NextGreaterElement2()._nextGreaterElements(new int[] {1,2,1})));
	}
	
	public int[] _nextGreaterElements(int[] nums) {
		
		Stack<Integer> stack = new Stack<>();
		int[] resp = new int[nums.length];
		Arrays.fill(resp, -1);
		int n = nums.length;
		for(int i=0;i<2*nums.length;i++) {
			while(!stack.isEmpty() && stack.peek()<nums[i%n]) {
				resp[stack.pop()] = nums[i%n];
			}
			stack.push(i);
		}
		
		return resp;
		
	}

	public int[] nextGreaterElements(int[] nums) {
		
		int[] numsExtended = new int[2*nums.length];
		int max = Integer.MIN_VALUE;
		for(int i=0;i<2*nums.length;i++) {
			numsExtended[i] = nums[i%nums.length];
			max = Math.max(numsExtended[i], max);
		}
		
		int[] resp = new int[nums.length];
		
		for(int i=0;i<nums.length;i++) {
			resp[i] = -1;
			if(nums[i]==max)continue;
			for(int j=i+1;j<2*nums.length;j++) {
				if(numsExtended[j]>nums[i]) {
					resp[i] = numsExtended[j];
					break;
				}
			}
		}
		return resp;

	}

}
