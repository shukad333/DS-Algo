package com.general.geeks.misc;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers and an integer k, find out whether there are two
 * distinct indices i and j in the array such that nums[i] = nums[j] and the
 * absolute difference between i and j is at most k.
 * 
 * 
 * @author skadavath
 *
 */
public class ContainsDuplicates2 {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3, 1, 2, 3 };
		System.out.println(new ContainsDuplicates2().containsNearbyDuplicate(nums, 3));

	}

	public boolean containsNearbyDuplicate(int[] nums, int k) {

		Set<Integer> set = new HashSet();

		for (int i = 0; i < nums.length; i++) {

			if (set.contains(nums[i])) {
				return true;
			}

			set.add(nums[i]);

			if (i >= k) {
				set.remove(nums[i - k]);
			}
		}
		return false;
	}

}
