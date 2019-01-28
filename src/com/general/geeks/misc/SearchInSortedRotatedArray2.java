package com.general.geeks.misc;

/**
 * 
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

You are given a target value to search. If found in the array return true, otherwise return false.

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
Follow up:

This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
Would this affect the run-time complexity? How and why?

 * 
 * @author skadavath
 *
 */
public class SearchInSortedRotatedArray2 {

	public boolean search(int[] nums, int target) {

		int lo = 0, high = nums.length - 1;

		while (lo <= high) {

			int mid = lo + (high - lo) / 2;

			if (nums[mid] == target)
				return true;
			
			
			//if duplicates occur , the search will be unstable , the below removes duplicates
			if (nums[lo] == nums[mid] && nums[high] == nums[mid]) {
				lo++;
				high--;
			}
			// adjust the search area whether left or right of the pivot

			else if (nums[lo] <= nums[mid]) {
				if (target < nums[mid] && target >= nums[lo])
					high = mid - 1;
				else
					lo = mid + 1;
			}

			else if (nums[mid] <= nums[high]) {
				if (target > nums[mid] && target <= nums[high])
					lo = mid + 1;
				else
					high = mid - 1;
			}

		}

		return false;

	}

}
