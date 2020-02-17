package com.general.geeks.misc;

/**
 * 
 * Given an integer array arr and an integer k, modify the array by repeating it k times.

For example, if arr = [1, 2] and k = 3 then the modified array will be [1, 2, 1, 2, 1, 2].

Return the maximum sub-array sum in the modified array. Note that the length of the sub-array can be 0 and its sum in that case is 0.

As the answer can be very large, return the answer modulo 10^9 + 7.

 

Example 1:

Input: arr = [1,2], k = 3
Output: 9
Example 2:

Input: arr = [1,-2,1], k = 5
Output: 2
Example 3:

Input: arr = [-1,-2], k = 7
Output: 0
 

Constraints:

1 <= arr.length <= 10^5
1 <= k <= 10^5
-10^4 <= arr[i] <= 10^4
 * 
 * @author skadavath
 *
 */
public class KConcatenationMaxSubArray {
	
	public static void main(String[] args) {
		
		System.out.println(new KConcatenationMaxSubArray().kConcatenationMaxSum(new int[] {1, -2,1},3));
		
	}

	final int mod = 1000_000_00_7;
	public int kConcatenationMaxSum(int[] ar, int k) {
		
		long kadanes= kadane(ar);
        if(k==1){
            return (int)kadanes;
        }
        long prefixSum= prefixSum(ar);
        long suffixSum=suffixSum(ar);
        long sum=0;
        for (int i1 : ar) {
            sum += i1;
        }
        if(sum>0){
            return (int)(Math.max(((sum*(k-2))%mod+suffixSum%mod+prefixSum%mod)%mod,kadanes%mod));
        }
        else{
            return (int)(Math.max((prefixSum%mod+suffixSum%mod)%mod,kadanes%mod));
        }

	}
	
	private long prefixSum(int[] arr) {
		int currSum=0,maxSum = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			currSum = (currSum+arr[i])%mod;
			maxSum = Math.max(maxSum, currSum);
		}
		return maxSum;
	}
	
	private long suffixSum(int[] arr) {
		int currSum=0,maxSum = Integer.MIN_VALUE;
		for(int i=arr.length-1;i>=0;i--) {
			currSum = (currSum+arr[i])%mod;
			maxSum = Math.max(maxSum, currSum);
		}
		return maxSum;
	}
	
	private long kadane(int[] arr) {
		
		long maxEndingHere=arr[0],maxSoFar = 0;
		
		for(int i=1;i<arr.length;i++) {
			
			maxEndingHere = Math.max(arr[i], (arr[i]+maxEndingHere)%mod);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
			
		}
		
		return maxSoFar;
		
	}

}
