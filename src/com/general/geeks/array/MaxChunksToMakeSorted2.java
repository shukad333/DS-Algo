package com.general.geeks.array;

/**
 * 
 * Given an array arr of integers (not necessarily distinct), we split the array into some number of "chunks" (partitions), and individually sort each chunk.  After concatenating them, the result equals the sorted array.

What is the most number of chunks we could have made?

Example 1:

Input: arr = [5,4,3,2,1]
Output: 1
Explanation:
Splitting into two or more chunks will not return the required result.
For example, splitting into [5, 4], [3, 2, 1] will result in [4, 5, 1, 2, 3], which isn't sorted.
Example 2:

Input: arr = [2,1,3,4,4]
Output: 4
Explanation:
We can split into two chunks, such as [2, 1], [3, 4, 4].
However, splitting into [2, 1], [3], [4], [4] is the highest number of chunks possible.
Note:

arr will have length in range [1, 2000].
arr[i] will be an integer in range [0, 10**8].
 
 * 
 * @author skadavath
 *
 */
public class MaxChunksToMakeSorted2 {
	
	public static void main(String[] args) {
		
		int a=1,b=2,c=3;
		a+=b+=c;
		//a=b=c;
		System.out.println(a+" "+b+" "+c);
		System.out.println(new MaxChunksToMakeSorted2().maxChunksToSorted(new int[] { 1, 0, 1, 3, 2 }));
	}

	public int maxChunksToSorted(int[] arr) {

		int resp = 0;

		int N = arr.length;
		int[] leftMax = new int[N];
		int[] rightMin = new int[N];

		leftMax[0] = arr[0];
		for (int i = 1; i < N; i++) {
			leftMax[i] = Math.max(arr[i], leftMax[i-1]);
		}

		rightMin[N - 1] = arr[N - 1];
		for (int i = N - 2; i >= 0; i--) {
			rightMin[i] = Math.min(rightMin[i + 1], arr[i]);
		}

		for (int i = 0; i < N - 1; i++) {
			if (leftMax[i] <= rightMin[i + 1])
				resp++;
		}

		return resp + 1;

	}

}
