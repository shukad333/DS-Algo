package com.general.geeks.array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

/**
 * 
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

Example:

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7] 
Explanation: 

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Note: 
You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?

 * 
 * @author skadavath
 *
 */
public class SlidingWindowMaximum {
	
	public static void main(String[] args) {
		
		Deque<Integer> dequeu = new ArrayDeque<>();
		
		dequeu.add(1);
		dequeu.add(2);
		dequeu.add(3);
		System.out.println(dequeu.peekLast());
		System.out.println(dequeu.peek());
		System.out.println(Arrays.toString(new SlidingWindowMaximum().maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3)));
		
	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		
		int len = nums.length;
		int[] resp = new int[len-k+1];
		
		Deque<Integer> dequeu = new ArrayDeque<>();
		
		int respIndex = 0;
		for(int i=0;i<len;i++) {
			
			//remove out of range numbers
			
			while(!dequeu.isEmpty() && dequeu.peek()<i-k+1)
				dequeu.poll();
			
			while(!dequeu.isEmpty() && nums[dequeu.peekLast()]<nums[i]) {
				dequeu.pollLast();
				
			}
			
			dequeu.offer(i);
			if(i>=k-1)
				resp[respIndex++] = nums[dequeu.peek()];
		}
		
		return resp;

	}

}
