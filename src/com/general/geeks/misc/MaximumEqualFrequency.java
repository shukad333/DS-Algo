package com.general.geeks.misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given an array nums of positive integers, return the longest possible length
 * of an array prefix of nums, such that it is possible to remove exactly one
 * element from this prefix so that every number that has appeared in it will
 * have the same number of occurrences.
 * 
 * If after removing one element there are no remaining elements, it's still
 * considered that every appeared number has the same number of ocurrences (0).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [2,2,1,1,5,3,3,5] Output: 7 Explanation: For the subarray
 * [2,2,1,1,5,3,3] of length 7, if we remove nums[4]=5, we will get
 * [2,2,1,1,3,3], so that each number will appear exactly twice. Example 2:
 * 
 * Input: nums = [1,1,1,2,2,2,3,3,3,4,4,4,5] Output: 13 Example 3:
 * 
 * Input: nums = [1,1,1,2,2,2] Output: 5 Example 4:
 * 
 * Input: nums = [10,2,8,9,3,8,1,5,2,3,7,6] Output: 8
 * 
 * 
 * Constraints:
 * 
 * 2 <= nums.length <= 10^5 1 <= nums[i] <= 10^5
 * 
 * @author skadavath
 *
 */
public class MaximumEqualFrequency {
	
	
	public static void main(String[] args) {
		
		
		System.out.println(new MaximumEqualFrequency().maxEqualFreq(new int[] {2,2,1,1,5,3,3,5}));
		
	}
	
	public int maxEqualFreq(int[] nums) {
		
		Map<Integer, Integer> counts = new HashMap<>();
		Map<Integer,Integer> freqs = new HashMap<>();
		
		
		
		int resp = 0;
		for(int i=0;i<nums.length;i++) {
			
			counts.put(nums[i], counts.getOrDefault(nums[i], 0)+1);
			
			int count = counts.get(nums[i]);
			
			freqs.put(count,freqs.getOrDefault(count, 0)+1);
			
			if(count*freqs.get(count)==i+1) {
				int size = (i==nums.length-1)?i:i+2;
				resp = Math.max(resp, size);
				
			}
			else if(count*freqs.get(count)==i) {
				resp = Math.max(resp, i);
			}
		}
		
		return resp;
		
		
	}

}
