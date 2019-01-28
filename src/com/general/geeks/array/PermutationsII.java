package com.general.geeks.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * Example:
 * 
 * Input: [1,1,2] Output: [ [1,1,2], [1,2,1], [2,1,1] ]
 * 
 * @author skadavath
 *
 */
public class PermutationsII {

	public static void main(String[] args) {
		System.out.println(new PermutationsII().permuteUnique(new int[] { 1,1, 2, 3 }));
	}

	public List<List<Integer>> permuteUnique(int[] nums) {

		List<List<Integer>> resp = new ArrayList<>();
		permute(resp, new ArrayList<>(), nums, new boolean[nums.length]);
		return resp;
	}

	private void permute(List<List<Integer>> resp, List<Integer> temp, int[] nums, boolean[] used) {
		if (nums.length == temp.size()) {
			resp.add(new ArrayList<>(temp));
		} else {
			for (int i = 0; i < nums.length; i++) {
				
				//use the duplicate only if the other pair or pairs is used
				//Bingo!!!
				if (used[i] || i > 0 && nums[i - 1] == nums[i] && !used[i - 1])
					continue;
				used[i] = true;
				temp.add(nums[i]);
				permute(resp, temp, nums, used);
				temp.remove(temp.size() - 1);
				used[i] = false;
			}
		}
	}

}
