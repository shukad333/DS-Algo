package com.general.geeks.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

 * @author skadavath
 *
 */
public class Subsets {
	
	public static void main(String[] args) {
		
		
		System.out.println(new Subsets().subsets(new int[] {1,2,3,3}));
	}
	
	public List<List<Integer>> subsets(int[] nums) {
		
		List<List<Integer>> resp = new ArrayList<>();
		Arrays.sort(nums);
		findSubsets(resp, new ArrayList<>(), nums, 0);
		return resp;
		
	}
	
	private void findSubsets(List<List<Integer>> resp , List<Integer> temp , int[] nums , int start) {
		
		resp.add(new ArrayList<>(temp));
		for(int i=start;i<nums.length;i++) {
			temp.add(nums[i]);
			findSubsets(resp, temp, nums, i+1);
			temp.remove(temp.size()-1);
		}
	}

}
