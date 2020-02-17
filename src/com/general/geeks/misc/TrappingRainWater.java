package com.general.geeks.misc;

import java.util.Stack;

/**
 * 
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Accepted
273,805
Submissions
643,764
 * 
 * @author skadavath
 *
 */
public class TrappingRainWater {
	
	public static void main(String[] args) {
		
		System.out.println(new TrappingRainWater().trap2(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
		
	}
	
	public int trap2(int[] A) {
		
		int resp = 0;
		int n = A.length;
		 int left=0; int right=n-1;
	        int res=0;
	        int maxleft=0, maxright=0;
	        while(left<=right){
	            if(A[left]<=A[right]){
	                if(A[left]>=maxleft) maxleft=A[left];
	                else res+=maxleft-A[left];
	                left++;
	            }
	            else{
	                if(A[right]>=maxright) maxright= A[right];
	                else res+=maxright-A[right];
	                right--;
	            }
	        }
	        return res;
	    }

	

	public int trap(int[] height) {

		int resp = 0;

		Stack<Integer> stack = new Stack<>();
		int i = 0;
		int maxWater = 0;
		while (i < height.length) {

			if (stack.isEmpty() || height[i] <= height[stack.peek()]) {
				stack.push(i++);
			} else {

				int peek = stack.pop();
				maxWater = stack.isEmpty() ? 0
						: (Math.min(height[stack.peek()], height[i]) - height[peek]) * (i - stack.peek() - 1);
				resp += maxWater;

			}
		}
		return resp;

	}

}
