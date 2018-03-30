package com.general.geeks.array;

/*
 * 
 * Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */

public class SIngleNumber {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 1, 2, 5, 4, 5 };
		System.out.println(new SIngleNumber().singleNumber(nums));
	}

	public int singleNumber(int[] nums) {

		int num = 0;
		for (int i : nums) {

			num = num ^ i;
		}

		return num;
	}

}
