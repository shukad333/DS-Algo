package com.general.geeks.misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into sets of k consecutive numbers
Return True if its possible otherwise return False.

 

Example 1:

Input: nums = [1,2,3,3,4,4,5,6], k = 4
Output: true
Explanation: Array can be divided into [1,2,3,4] and [3,4,5,6].
Example 2:

Input: nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
Output: true
Explanation: Array can be divided into [1,2,3] , [2,3,4] , [3,4,5] and [9,10,11].
Example 3:

Input: nums = [3,3,2,2,1,1], k = 3
Output: true
Example 4:

Input: nums = [1,2,3,4], k = 3
Output: false
Explanation: Each array should be divided in subarrays of size 3.
 

Constraints:

1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
1 <= k <= nums.length
 * 
 * @author skadavath
 *
 */
public class DivideArrayInSetsOfKConsecutiveNumbers {

	public boolean isPossibleDivide(int[] nums, int k) {

		Arrays.sort(nums);
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		for (int i : nums) {
			if (map.get(i) > 0) {
				int times = map.get(i);
				for (int j = i; j < k + i; j++) {
					if (!map.containsKey(j) || map.get(j) < times)
						return false;
					map.put(j, map.get(j) - times);
				}
			}
		}
		return true;

	}

}
