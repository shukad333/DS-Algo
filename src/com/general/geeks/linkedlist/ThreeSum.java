package com.general.geeks.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 * @author skadavath
 *
 */
public class ThreeSum {

public List<List<Integer>> threeSum(int[] nums) {
		
		List<List<Integer>> resp = new ArrayList<>();
		
		Arrays.sort(nums);
		
		
		
		for(int i=0;i<nums.length-2;i++) {
			
			if(i>0 && nums[i]==nums[i-1])
				continue;
			
			int left=i+1,right=nums.length-1;
			
			int target = -nums[i];
			
			while(left<right) {
				if(nums[left]+nums[right]==target) {
					resp.add(Arrays.asList(nums[left],nums[i],nums[right]));
					left++;
					right--;
                    
                    while(left<nums.length && nums[left]==nums[left-1])left++;
                    while(right>=0 && nums[right]==nums[right+1])right--;
				}
				else if(nums[left]+nums[right]>target){
					right--;
					
				}
				else 
					left++;
			}
			
		}
		
		return resp;
	}
}
