package com.general.geeks.array;

import java.util.List;

public class SearchInRotatedArray {

	public static void main(String[] args) {

		Integer[] arr = { 4, 5, 6, 7, 1, 2, 3 };

		System.out.println(new SearchInRotatedArray().searchArr(arr, 4));

	}
	
	 public int search(final List<Integer> a, int b) {
	        
	        return searchArr(a.toArray(new Integer[a.size()]),b);
	    }

	public int searchArr(Integer[] nums, int target) {
		int pivot = findPivot(nums, 0, nums.length - 1);

		if (pivot == -1)
			return binarySearch(nums, 0, nums.length - 1, target);

		if (nums[0] > target)
			return binarySearch(nums, pivot, nums.length - 1, target);

		return binarySearch(nums, 0, pivot, target);

	}

	public int findPivot(Integer[] arr, int low, int high) {

		if (low > high) {
			return -1;
		}

		int mid = (low + high) / 2;

		if (mid < high && arr[mid] > arr[mid + 1]) {

			return mid;
		}

		if (mid > low && arr[mid] < arr[mid - 1]) {
			return low;
		}

		if (arr[low] > arr[mid])
			return findPivot(arr, low, mid - 1);
		return findPivot(arr, mid + 1, high);

	}

	private int binarySearch(Integer[] arr, int low, int high, int x) {

		while (low <= high) {
			int mid = (low + high) >> 1;
			if (arr[mid] == x)
				return mid;
			if (arr[mid] > x)
				high = mid - 1;
			else
				low = mid + 1;

		}

		return low;

	}
}
