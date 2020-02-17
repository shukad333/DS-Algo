package com.general.geeks.array;

import java.util.Arrays;

/**
 * 
 * Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.

 

Example 1:

Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
Output: True
Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 

Note:

1 <= k <= len(nums) <= 16.
0 < nums[i] < 10000.

 * 
 * @author skadavath
 *
 */
public class PartitionToKEqualSumSubsets {
	
	public static void main(String[] args) {
		
		System.out.println(new PartitionToKEqualSumSubsets().canPartitionKSubsets(new int[] {4, 3, 2, 3, 5, 2, 1}, 4));
		
	}

	public boolean canPartitionKSubsets(int[] nums, int k) {
		
		Arrays.sort(nums);
		int sum = Arrays.stream(nums).sum();
		if(sum%k!=0)
			return false;
		
		return dfs(nums, sum/k, 0, 0, new boolean[nums.length], k);
		

	}
	
	private boolean dfs(int[] nums,int target , int currNum,int currSum,boolean[] visited,int k) {
		
		if(k==0)
			return true;
		
		if(currSum == target && dfs(nums, target, 0, 0, visited, k-1)) {
		 
			return true;
		}
		
		for(int i=currNum;i<nums.length;i++) {
			
			if(!visited[i] && currSum+nums[i]<=target) {
				visited[i] = true;
				 if(dfs(nums, target, i+1, currSum+nums[i], visited, k))
					 return true;
				 visited[i] = false;
			}
			
			
			
		}
		
		return false;
		
	}

}
