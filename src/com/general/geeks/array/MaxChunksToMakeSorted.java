package com.general.geeks.array;

/**
 * 
 * Given an array arr that is a permutation of [0, 1, ..., arr.length - 1], we split the array into some number of "chunks" (partitions), and individually sort each chunk.  After concatenating them, the result equals the sorted array.

What is the most number of chunks we could have made?

Example 1:

Input: arr = [4,3,2,1,0]
Output: 1
Explanation:
Splitting into two or more chunks will not return the required result.
For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.
Example 2:

Input: arr = [1,0,2,3,4]
Output: 4
Explanation:
We can split into two chunks, such as [1, 0], [2, 3, 4].
However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.
Note:

arr will have length in range [1, 10].
arr[i] will be a permutation of [0, 1, ..., arr.length - 1].

 * 
 * @author skadavath
 *
 */
public class MaxChunksToMakeSorted {
	
	public static void main(String[] args) {
		
		System.out.println(new MaxChunksToMakeSorted()._maxChunksToSorted(new int[] {0,1,2,4,3}));
		
	}

	public int maxChunksToSorted(int[] arr) {
		
		int resp = 0;
		int max = 0;
		
		for(int i=0;i<arr.length;i++) {
			
			max = Math.max(max, arr[i]);
			if(i==max)
				resp++;
		}
		
		return resp;

	}
	
public int _maxChunksToSorted(int[] arr) {
		
		int resp = 0;
		
		int N = arr.length;
		int[] leftMax = new int[N];
		int[] rightMin = new int[N];
		
		leftMax[0] = arr[0];
		for(int i=1;i<N;i++) {
			leftMax[i] = Math.max(arr[i], leftMax[i-1]);
		}
		
		rightMin[N-1] = arr[N-1];
		for(int i=N-2;i>=0;i--) {
			rightMin[i] = Math.min(rightMin[i+1], arr[i]);
		}
		
		for(int i=0;i<N-1;i++) {
			if(leftMax[i]<=rightMin[i+1])
				resp++;
		}
		
		return resp+1;

	}

}
