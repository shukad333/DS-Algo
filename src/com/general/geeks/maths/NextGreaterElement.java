package com.general.geeks.maths;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s
 * elements are subset of nums2. Find all the next greater numbers for nums1's
 * elements in the corresponding places of nums2.
 * 
 * The Next Greater Number of a number x in nums1 is the first greater number to
 * its right in nums2. If it does not exist, output -1 for this number.
 * 
 * Example 1: Input: nums1 = [4,1,2], nums2 = [1,3,4,2]. Output: [-1,3,-1]
 * Explanation: For number 4 in the first array, you cannot find the next
 * greater number for it in the second array, so output -1. For number 1 in the
 * first array, the next greater number for it in the second array is 3. For
 * number 2 in the first array, there is no next greater number for it in the
 * second array, so output -1. Example 2: Input: nums1 = [2,4], nums2 =
 * [1,2,3,4]. Output: [3,-1] Explanation: For number 2 in the first array, the
 * next greater number for it in the second array is 3. For number 4 in the
 * first array, there is no next greater number for it in the second array, so
 * output -1.
 * 
 * [1,3,5,2,4] [6,5,4,3,2,1,7]
 * 
 * @author skadavath
 *
 */
public class NextGreaterElement {

	public static void main(String[] args) {

		int[] nums1 = { 1, 3, 5, 2, 4 };
		int[] nums2 = { 6, 5, 4, 3, 2, 1, 7 };

		int[] n = new NextGreaterElement().nextGreaterElement(nums1, nums2);
		for (int i = 0; i < n.length; i++) {
			System.out.print(n[i] + " ");
		}
	}

	public int[] nextGreaterElement(int[] nums1, int[] nums2) {

		Stack<Integer> stack = new Stack();
		Map<Integer, Integer> map = new HashMap();
		for (int i : nums2) {
			while (!stack.isEmpty() && stack.peek() < i) {
				map.put(stack.pop(), i);
			}
			stack.push(i);
		}

		for (int i = 0; i < nums1.length; i++) {
			nums1[i] = map.getOrDefault(nums1[i], -1);
		}
		return nums1;
	}
}
