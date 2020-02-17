package com.general.geeks.misc;

import java.util.Arrays;
import java.util.Stack;

public class MaxArray {
	
	public static void main(String[] args) {
		
		
		System.out.println(Arrays.toString(new MaxArray().maxArray(new int[] {5, 7,4,9},3)));
		
	}
	
	private int[] maxArray(int[] nums, int len) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < nums.length; i++) {
            while (stack.size() + nums.length - i > len && !stack.empty() && stack.peek() < nums[i]) {
                stack.pop();
            }
            if (stack.size() < len) {
                stack.push(nums[i]);
            }
        }
        int[] result = new int[len];
        for (int i = len - 1; i >= 0; i--) {
          result[i] = stack.pop(); 
        }
        return result;
    }

}
