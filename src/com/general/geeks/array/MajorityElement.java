package com.general.geeks.array;

import java.util.HashMap;
import java.util.Map;

/*
 * 
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement {

	public static void main(String[] args) {
//
		 System.out.println(new MajorityElement()._majorityElement(new int[]{1,2,3,4,6,2,8,2,2,2,2,2}));
	}

	private static int sum(int k) {
		return k + 1;
	}

	public int _majorityElement(int[] nums) {

		int[] bit = new int[32];
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < 32; j++) {
				bit[j] += (nums[i] >> j) & 1;
			}
		}
		int majority = 0;
		for (int j = 0; j < 32; j++) {
			bit[j] = bit[j] > (nums.length / 2)? 1 : 0;
			majority += bit[j] << j;
		}
		return majority;

	}

	public int majorityElement(int[] nums) {

		/**
		 * 
		 * https://gregable.com/2013/10/majority-vote-algorithm-find-majority.html
		 */
		int count = 1, majorityElement = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (count == 0) {
				majorityElement = nums[i];
			}
			if (nums[i] == majorityElement)
				count++;
			else
				count--;

		}
		count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (majorityElement == nums[i]) {
				count++;
			}
		}
		if (count > nums.length / 2) {
			return majorityElement;
		}

		return -1;

	}

}
