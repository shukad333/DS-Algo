package com.general.geeks.misc;

/**
 * 
 * Given an unsorted array return whether an increasing subsequence of length 3
 * exists or not in the array.
 * 
 * Formally the function should:
 * 
 * Return true if there exists i, j, k such that arr[i] < arr[j] < arr[k] given
 * 0 ≤ i < j < k ≤ n-1 else return false. Note: Your algorithm should run in
 * O(n) time complexity and O(1) space complexity.
 * 
 * Example 1:
 * 
 * Input: [1,2,3,4,5] Output: true Example 2:
 * 
 * Input: [5,4,3,2,1] Output: false
 * 
 * 
 * @author skadavath
 *
 */
public class IncreasingTripletSequence {

	public static void main(String[] args) {

		System.out.println(new IncreasingTripletSequence().increasingTriplet(new int[] { 1, 2, 0, 5 }));

	}

	public boolean increasingTriplet(int[] nums) {

		int max = Integer.MAX_VALUE;
		int secondMax = Integer.MAX_VALUE;

		for (int i : nums) {
			if (i <= max)
				max = i;
			else if (i <= secondMax)
				secondMax = i;
			else
				return true;
		}

		return false;

	}

}
