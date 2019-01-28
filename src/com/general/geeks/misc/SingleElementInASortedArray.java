package com.general.geeks.misc;

/**
 * Given a sorted array consisting of only integers where every element appears
 * twice except for one element which appears once. Find this single element
 * that appears only once.
 * 
 * Example 1: Input: [1,1,2,3,3,4,4,8,8] Output: 2 Example 2: Input:
 * [3,3,7,7,10,11,11] Output: 10 Note: Your solution should run in O(log n) time
 * and O(1) space.
 * 
 * @author skadavath
 *
 */
public class SingleElementInASortedArray {

	//if mid is even , there will odd numbers on the left and just prove nums[mid]==nums[mid-1]
	//if mid is odd , there will be even numbers on the left and just prove nums[mid]==nums[mid+1]
	public int singleNonDuplicate(int[] nums) {
		int low = 0, high = nums.length - 1;
		while (low < high) {
			int mid = low + (high - low) / 2;

			if ((mid - 1 >= 0 && nums[mid] == nums[mid - 1] && mid % 2 == 1)
					|| (mid + 1 < nums.length && mid % 2 == 0 && nums[mid] == nums[mid + 1]))
				low = mid + 1;
			else
				high = mid - 1;
		}
		return nums[low];
	}

}
