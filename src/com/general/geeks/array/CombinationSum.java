package com.general.geeks.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a
 * target number (target), find all unique combinations in candidates where the
 * candidate numbers sums to target.
 * 
 * The same repeated number may be chosen from candidates unlimited number of
 * times.
 * 
 * Note:
 * 
 * All numbers (including target) will be positive integers. The solution set
 * must not contain duplicate combinations. Example 1:
 * 
 * Input: candidates = [2,3,6,7], target = 7, A solution set is: [ [7], [2,2,3]
 * ] Example 2:
 * 
 * Input: candidates = [2,3,5], target = 8, A solution set is: [ [2,2,2,2],
 * [2,3,3], [3,5] ]
 * 
 * @author skadavath
 *
 */
public class CombinationSum {

	public static void main(String[] args) {
		System.out.println(new CombinationSum().combinationSum(new int[] { 10,1,2,7,6,1,5}, 8));
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {

		List<List<Integer>> resp = new ArrayList<>();
		Arrays.sort(candidates);
		doDfs(resp, new ArrayList<>(), target, 0, candidates);
		return resp;

	}

	private void doDfs(List<List<Integer>> resp, List<Integer> temp, int remaining, int start, int[] nums) {

		if (remaining < 0)
			return;
		else if (remaining == 0) {
			resp.add(new ArrayList<>(temp));
		} else {
			for (int i = start; i < nums.length; i++) {
				//remove this if it can be reused
				if(i>start && nums[i-1]==nums[i])continue;
				temp.add(nums[i]);
				//only 'i' this if it can be reused
				doDfs(resp, temp, remaining - nums[i], i+1, nums);
				temp.remove(temp.size() - 1);
			}
		}
	}

}
