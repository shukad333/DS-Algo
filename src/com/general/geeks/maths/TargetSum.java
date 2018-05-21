package com.general.geeks.maths;

import java.util.HashMap;

/**
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target,
 * S. Now you have 2 symbols + and -. For each integer, you should choose one
 * from + and - as its new symbol.
 * 
 * Find out how many ways to assign symbols to make sum of integers equal to
 * target S.
 * 
 * Example 1: Input: nums is [1, 1, 1, 1, 1], S is 3. Output: 5 Explanation:
 * 
 * -1+1+1+1+1 = 3 +1-1+1+1+1 = 3 +1+1-1+1+1 = 3 +1+1+1-1+1 = 3 +1+1+1+1-1 = 3
 * 
 * There are 5 ways to assign symbols to make the sum of nums be target 3. Note:
 * The length of the given array is positive and will not exceed 20. The sum of
 * elements in the given array will not exceed 1000. Your output answer is
 * guaranteed to be fitted in a 32-bit integer.
 * 
 * @author skadavath
 *
 */
public class TargetSum {
	
	public static void main(String[] args) {
		
		System.out.println(new TargetSum().findTargetSumWays(new int[] {1,1,1,1,1}, 3));
	}

	public int findTargetSumWays(int[] nums, int S) {
		
		
		return findTargetSumWaus(nums, 0, 0, S, new HashMap<String,Integer>());
	}
	
	
	public int findTargetSumWaus(int[] nums , int index ,int currentSum, int S , HashMap<String, Integer> cache) {
		
		String key = index + "#" + currentSum;
		
		if(cache.containsKey(key)) {
			return cache.get(key);
		}
		
		if(index == nums.length) {
			if(currentSum == S)  {
				return 1;
			}
			else {
				return 0;
			}
		}
		
		int sumWay = findTargetSumWaus(nums, index+1, currentSum-nums[index], S, cache);
		int diffWay = findTargetSumWaus(nums, index+1, currentSum + nums[index], S, cache);
		cache.put(key, sumWay+diffWay);
		return sumWay+diffWay;
	}

}
