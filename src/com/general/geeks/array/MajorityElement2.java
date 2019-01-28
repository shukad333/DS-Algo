package com.general.geeks.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given an integer array of size n, find all elements that appear more than ⌊
 * n/3 ⌋ times.
 * 
 * Note: The algorithm should run in linear time and in O(1) space.
 * 
 * Example 1:
 * 
 * Input: [3,2,3] Output: [3] Example 2:
 * 
 * Input: [1,1,1,3,3,2,2,2] Output: [1,2]
 * 
 * 
 * @author skadavath
 *
 */
public class MajorityElement2 {

	public static void main(String[] args) {

		System.out.println(new MajorityElement2().majorityElement(new int[] { 1, 2, 3, 1, 2, 3, 1, 2 }));

	}

	public List<Integer> majorityElement(int[] nums) {

		/**
		 * 
		 * https://leetcode.com/problems/majority-element-ii/description/
		 * 
		 */
		List<Integer> resp = new ArrayList<>();

		int count1 = 0, count2 = 0, num1 = nums[0], num2 = nums[0];

		for (int i = 0; i < nums.length; i++) {

			if (nums[i] == num1)
				count1++;
			else if (nums[i] == num2)
				count2++;
			else if (count1 == 0) {
				count1 = 1;
				num1 = nums[i];
			} else if (count2 == 0) {
				count2 = 1;
				num2 = nums[i];
			} else {
				count1--;
				count2--;
			}
		}

		count1 = 0;
		count2 = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == num1)
				count1++;
			else if (nums[i] == num2)
				count2++;
		}

		if (count1 > nums.length / 3)
			resp.add(num1);
		if (count2 > nums.length / 3)
			resp.add(num2);

		return resp;

	}

}
