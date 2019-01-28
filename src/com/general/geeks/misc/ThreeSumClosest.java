package com.general.geeks.misc;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers
 * in nums such that the sum is closest to target. Return the sum of the three
 * integers. You may assume that each input would have exactly one solution.
 * 
 * Example:
 * 
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * @author skadavath
 *
 */
public class ThreeSumClosest {

	public static void main(String[] args) {

		System.out.println(new ThreeSumClosest().threeSumClosest(new int[] { -1, 1, -1, 2, 4 }, -1));

	}

	public int threeSumClosest(int[] nums, int target) {

		Arrays.sort(nums);

		int sum = nums[0] + nums[1] + nums[2];

		for (int i = 2; i < nums.length; i++) {

			int left = 0, right = i - 1;

			while (left < right) {

				int localSum = nums[left] + nums[right] + nums[i];

				sum = Math.abs(localSum - target) < Math.abs(sum - target) ? localSum : sum;

				if (localSum > target) {
					right--;
				} else
					left++;

			}
		}

		return sum;

	}
}
