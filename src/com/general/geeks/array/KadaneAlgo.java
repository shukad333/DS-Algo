package com.general.geeks.array;

/**
 * 
 * Write an efficient program to find the sum of contiguous subarray within a
 * one-dimensional array of numbers which has the largest sum.
 * 
 * 
 * 
 * @author skadavath
 *
 */
public class KadaneAlgo {
	
	public static void main(String[] args) {
		
		System.out.println(new KadaneAlgo().maxSubArraySum(new int[] {-2, -3, 4, -1, -2, 1, 5, -3}));
		
	}
	
	public int maxSubArraySum(int[] arr) {
		
		int maxTillHere=arr[0],maxSoFar=arr[0];
		
		for(int i=1;i<arr.length;i++) {
			
			maxTillHere = Math.max(arr[i], arr[i]+maxTillHere);
			maxSoFar = Math.max(maxTillHere, maxSoFar);
		}
		
		return maxSoFar;
		
	}

}
