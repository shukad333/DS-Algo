package com.general.geeks.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * In an array A of 0s and 1s, how many non-empty subarrays have sum S?

 

Example 1:

Input: A = [1,0,1,0,1], S = 2
Output: 4
Explanation: 
The 4 subarrays are bolded below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
 

Note:

A.length <= 30000
0 <= S <= A.length
A[i] is either 0 or 1.

 * 
 * @author skadavath
 *
 */
public class BinarySubArraysWithSum {
	
	public static void main(String[] args) {
		
		System.out.println(new BinarySubArraysWithSum().numSubarraysWithSum(new int[] {1, 0,1,0,1},2));
		
	}

	public int numSubarraysWithSum(int[] A, int S) {
		
		/**
		 * 
		 * TLDR; Two Sum + Prefix Sum Caching

Logic: In this problem we are required to find some interval [i:j] ,i < j where sum[i:j] = target. We know that sum[i:j] = A[i] + A[i+1] +... + A[j].
Then we also know that
Let's define prefixSum[j] = A[0] + A[1] + ... + A[j] 0 <= j <= n-1 (n = A.length)
It is easy to see that,
sum[i:j] = A[i] + A[i+1] ... + A[j] =
(A[0] + A[1] + ... A[i] ... + A[j]) - (A[0] + A[1] + ... A[i-1]) =
prefix[j] - prefix[i-1].

Now we the problem reduces to finding # of pairs (i, j) (i < j) such that
prefix[j] - prefix[i-1] = target
This becomes prefix[i-1] = prefix[j] - target with some algebra.
So we use the hashmap to find all pairs that satisfy the above equations.

We only need to track the prefix sum up to this point however, since we already saved all the previous results in the map.

if (sum == target) total++ Here I am checking for the case where the current element is equal to the sum (it needs no interval to produce the sum).
		 * 
		 */
		
		int resp = 0;
		int preSum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i : A) {
			
			preSum += i;
			if(map.get(preSum - S)!=null) {
				resp += map.get(preSum - S);
			}
			
			if(preSum == S)
				resp++;
			
			map.put(preSum, map.getOrDefault(preSum, 0)+1);
			
		}
		
		return resp;

	}

}
