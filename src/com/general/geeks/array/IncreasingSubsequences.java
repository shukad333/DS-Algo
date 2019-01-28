package com.general.geeks.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 
 * 
 * Given an integer array, your task is to find all the different possible
 * increasing subsequences of the given array, and the length of an increasing
 * subsequence should be at least 2 .
 * 
 * Example: Input: [4, 6, 7, 7] Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7,
 * 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]] Note: The length of the given array
 * will not exceed 15. The range of integer in the given array is [-100,100].
 * The given array may contain duplicates, and two equal integers should also be
 * considered as a special case of increasing sequence. Seen this question in a
 * real interview before?
 * 
 * 
 * @author skadavath
 *
 */
public class IncreasingSubsequences {

	public static void main(String[] args) {

		System.out.println(new IncreasingSubsequences().findSubsequences(new int[] { 4, 6, 7, 7 }));

	}

	public List<List<Integer>> findSubsequences(int[] nums) {

		List<List<Integer>> resp = new ArrayList<List<Integer>>();

		helper(resp, nums, 0, new LinkedList());

		return resp;

	}

	private void helper(List<List<Integer>> resp, int[] nums, int index, LinkedList<Integer> tempList) {

		if (tempList.size() > 1) {
			resp.add(new LinkedList<>(tempList));
		}
		Set<Integer> set = new HashSet<>();
		for (int i = index; i < nums.length; i++) {

			if (!set.contains(nums[i])) {

				if (tempList.size() == 0 || tempList.get(tempList.size() - 1) <= nums[i]) {
					tempList.add(nums[i]);
					set.add(nums[i]);
					helper(resp, nums, i + 1, tempList);
					tempList.remove(tempList.size() - 1);
				}

			}

		}

	}

}
