package com.general.geeks.array;

import java.util.HashSet;
import java.util.Set;


/**
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 * Example:
 * 
 * Input: [100, 4, 200, 1, 3, 2] Output: 4 Explanation: The longest consecutive
 * elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * 
 * @author skadavath
 *
 */
public class LongestConsecutiveSeuquence {

	public static void main(String[] args) {

		System.out.println(new LongestConsecutiveSeuquence().longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));

	}

	public int longestConsecutive(int[] nums) {

		Set<Integer> set = new HashSet<>();

		for (int i : nums)
			set.add(i);

		int resp = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {

			if (!set.contains(nums[i] - 1)) {

				int curr = nums[i];
				int count = 1;
				while (set.contains(++curr))
					count++;

				resp = Math.max(resp, count);
			}

		}

		return resp;

	}

}
