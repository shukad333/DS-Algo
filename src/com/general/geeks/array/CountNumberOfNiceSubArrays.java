package com.general.geeks.array;

/**
 * 
 * Given an array of integers nums and an integer k. A subarray is called nice if there are k odd numbers on it.

Return the number of nice sub-arrays.

 

Example 1:

Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
Example 2:

Input: nums = [2,4,6], k = 1
Output: 0
Explanation: There is no odd numbers in the array.
Example 3:

Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
Output: 16
 

Constraints:

1 <= nums.length <= 50000
1 <= nums[i] <= 10^5
1 <= k <= nums.length
 * 
 * @author skadavath
 *
 */
public class CountNumberOfNiceSubArrays {

	public static void main(String[] args) {
		System.out.println(new CountNumberOfNiceSubArrays().numberOfSubarrays(new int[]{2,2,2,1,2,2,1,2,2,2},2));
	}

	public int numberOfSubarrays(int[] A, int k) {
		int res = 0, i = 0, count = 0, n = A.length;
		for (int j = 0; j < n; j++) {
			if (A[j] % 2 == 1) {
				--k;
				count = 0;
			}
			while (k == 0) {
				k += A[i++] & 1;
				++count;
			}
			res += count;
		}
		return res;
	}
	
	public int _numberOfSubarrays(int[] nums, int k) {

		return atMostK(nums, k) - atMostK(nums, k - 1);
	}

	private int atMostK(int[] nums, int k) {

		int i = 0, resp = 0;
		for (int j = 0; j < nums.length; j++) {

			k -= nums[j] % 2;
			while (k < 0) {
				k += nums[i++] % 2;
			}
			resp += j - i + 1;
		}

		return resp;

	}

}
