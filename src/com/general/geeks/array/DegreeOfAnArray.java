package com.general.geeks.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty array of non-negative integers nums, the degree of this
 * array is defined as the maximum frequency of any one of its elements.
 * 
 * Your task is to find the smallest possible length of a (contiguous) subarray
 * of nums, that has the same degree as nums.
 * 
 * Example 1: Input: [1, 2, 2, 3, 1] Output: 2 Explanation: The input array has
 * a degree of 2 because both elements 1 and 2 appear twice. Of the subarrays
 * that have the same degree: [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1,
 * 2, 2], [2, 2, 3], [2, 2] The shortest length is 2. So return 2. Example 2:
 * Input: [1,2,2,3,1,4,2] Output: 6 Note:
 * 
 * nums.length will be between 1 and 50,000. nums[i] will be an integer between
 * 0 and 49,999.
 * 
 * @author skadavath
 *
 */
public class DegreeOfAnArray {

	public int findShortestSubArray(int[] nums) {

		int maxDegree = 0;
		int degree = 0;

		Map<Integer, Integer> degreeMap = new HashMap<>();
		Map<Integer, Integer[]> rangeMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {

			degreeMap.put(i, degreeMap.getOrDefault(nums[i], 1));
			maxDegree = Math.max(degreeMap.get(nums[i]), maxDegree);

			if (null == rangeMap.get(nums[i]))
				rangeMap.put(i, new Integer[2]);
			Integer[] range = rangeMap.get(nums[i]);
			if (null == range[0])
				range[0] = i;
			range[1] = i;

		}

		int minRange = nums.length;
		for (Map.Entry<Integer, Integer> entry : degreeMap.entrySet()) {
			int key = entry.getKey();
			if (entry.getValue() != maxDegree)
				continue;
			Integer[] range = rangeMap.get(key);
			minRange = Math.min(minRange, range[1] - range[0]+1);
		}

		return minRange;
	}

}
