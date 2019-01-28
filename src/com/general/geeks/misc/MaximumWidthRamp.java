package com.general.geeks.misc;

/**
 * 
 * Given an array A of integers, a ramp is a tuple (i, j) for which i < j and A[i] <= A[j].  The width of such a ramp is j - i.

Find the maximum width of a ramp in A.  If one doesn't exist, return 0.

 

Example 1:

Input: [6,0,8,2,1,5]
Output: 4
Explanation: 
The maximum width ramp is achieved at (i, j) = (1, 5): A[1] = 0 and A[5] = 5.
Example 2:

Input: [9,8,1,0,1,9,4,0,4,1]
Output: 7
Explanation: 
The maximum width ramp is achieved at (i, j) = (2, 9): A[2] = 1 and A[9] = 1.
 

Note:

2 <= A.length <= 50000
0 <= A[i] <= 50000
 
 * 
 * @author skadavath
 *
 */
public class MaximumWidthRamp {
	
	public static void main(String[] args) {
		
		System.out.println(new MaximumWidthRamp().maxWidthRamp(new int[] {9,8,1,0,1,9,4,0,4,1}));
		
	}

	public int maxWidthRamp(int[] A) {
		
		//maintain minArr and maxArry
		
		int n = A.length;
		int[] min = new int[n];
		int[] max = new int[n];
		
		min[0] = A[0];
		for(int i=1;i<n;i++) {
			min[i] = Math.min(min[i-1], A[i]);
		}
		max[n-1] = A[n-1];
		for(int i=n-2;i>=0;i--) {
			max[i] = Math.max(max[i+1], A[i]);
		}
		
		int i=0,j=0;
		int resp = Integer.MIN_VALUE;
		while(i<n && j<n) {
			if(min[i]<=max[j]) {
				
				resp = Math.max(resp, j-i);
				j++;
			}
			else
				i++;
		}
		
		return resp;

	}

}
