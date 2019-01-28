package com.general.geeks.array.dynamicprogramming;

import java.util.Arrays;

/**
 * You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.

Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.

Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. You can select pairs in any order.

Example 1:
Input: [[1,2], [2,3], [3,4]]
Output: 2
Explanation: The longest chain is [1,2] -> [3,4]
Note:
The number of given pairs will be in the range [1, 1000].

 * @author skadavath
 *
 */
public class MaximumLengthOfPairChain {
	
	public static void main(String[] args) {
		System.out.println(new MaximumLengthOfPairChain().findLongestChain(new int[][] {{1,2},{3,4},{2,3}}));
	}

	public int findLongestChain(int[][] pairs) {
		
		Arrays.sort(pairs,(a,b)->(a[1]-b[1]));
		int[] dp = new int[pairs.length+1];
		dp[0] = 1;
		for(int i=1;i<pairs.length;i++) {
			
			for(int j=0;j<i;j++) {
				dp[i] = Math.max(dp[i], pairs[i][0]>pairs[j][1]?dp[j]+1:dp[j]);
			}
		}
		return dp[pairs.length-1];

	}

}
