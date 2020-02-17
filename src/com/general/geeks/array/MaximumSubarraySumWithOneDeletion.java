package com.general.geeks.array;

/**
 * 
 * Given an array of integers, return the maximum sum for a non-empty subarray (contiguous elements) with at most one element deletion. In other words, you want to choose a subarray and optionally delete one element from it so that there is still at least one element left and the sum of the remaining elements is maximum possible.

Note that the subarray needs to be non-empty after deleting one element.

 

Example 1:

Input: arr = [1,-2,0,3]
Output: 4
Explanation: Because we can choose [1, -2, 0, 3] and drop -2, thus the subarray [1, 0, 3] becomes the maximum value.
Example 2:

Input: arr = [1,-2,-2,3]
Output: 3
Explanation: We just choose [3] and it's the maximum sum.
Example 3:

Input: arr = [-1,-1,-1,-1]
Output: -1
Explanation: The final subarray needs to be non-empty. You can't choose [-1] and delete -1 from it, then get an empty subarray to make the sum equals to 0.
 

Constraints:

1 <= arr.length <= 10^5
-10^4 <= arr[i] <= 10^4
 * 
 * @author skadavath
 *
 */
public class MaximumSubarraySumWithOneDeletion {
	
	public static void main(String[] args) {
		
		System.out.println(new MaximumSubarraySumWithOneDeletion().maximumSum(new int[] {1,-2,0,3}));
		
	}

	public int maximumSum(int[] arr) {
		
		int[] maxEndingHere= new int[arr.length],maxStartingHere = new int[arr.length];
		int max = arr[0];
		maxEndingHere[0] = arr[0];
		for(int i=1;i<arr.length;i++) {
			
			maxEndingHere[i] = Math.max(arr[i], arr[i]+maxEndingHere[i-1]);
			max = Math.max(max, maxEndingHere[i]);
		}
		maxStartingHere[arr.length-1] = arr[arr.length-1];
		for(int i=arr.length-2;i>=0;i--) {
			maxStartingHere[i] = Math.max(maxStartingHere[i+1]+arr[i],arr[i]); 
		}
		
		for(int i=1;i<arr.length-1;i++) {
			max = Math.max(maxEndingHere[i-1]+maxStartingHere[i+1], max);
		}
		
		return max;

	}

}
