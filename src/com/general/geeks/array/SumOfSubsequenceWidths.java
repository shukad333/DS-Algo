package com.general.geeks.array;

import java.util.Arrays;

/**
 * 
 * Given an array of integers A, consider all non-empty subsequences of A.
 * 
 * For any sequence S, let the width of S be the difference between the maximum
 * and minimum element of S.
 * 
 * Return the sum of the widths of all subsequences of A.
 * 
 * As the answer may be very large, return the answer modulo 10^9 + 7.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [2,1,3] Output: 6 Explanation: Subsequences are [1], [2], [3], [2,1],
 * [2,3], [1,3], [2,1,3]. The corresponding widths are 0, 0, 0, 1, 1, 2, 2. The
 * sum of these widths is 6.
 * 
 * 
 * Note:
 * 
 * 1 <= A.length <= 20000 1 <= A[i] <= 20000
 * 
 * 
 * @author skadavath
 *
 */
public class SumOfSubsequenceWidths {

	public static void main(String[] args) {

		System.out.println(new SumOfSubsequenceWidths().sumSubseqWidths(new int[] {2,3,1}));

	}

	/**
	 * 
	 * The order in initial arrays doesn't matter, my first intuition is to sort the
	 * array.
	 * 
	 * For A[i]: There are i smaller numbers, so there are 2 ^ i sequences in which
	 * A[i] is maximum. we should do res += A[i] * (2 ^ i)
	 * 
	 * There are n - i - 1 bigger numbers, so there are 2 ^ (n - i - 1) sequences in
	 * which A[i] is minimum. we should do res -= A[i] * 2 ^ (n - i - 1)
	 * 
	 * Done.
	 * 
	 * Time Complexity: O(NlogN)
	 * 
	 * @param A
	 * @return
	 */
	public int sumSubseqWidths(int[] A) {

		Arrays.sort(A);

		long c = 1;
		long mod = (long) 1e9 + 7;// 100000007
		long resp = 0;
		for (int i = 0; i < A.length; i++, c = (c << 1) % mod) {

			resp = (resp + A[i] * c - A[A.length - i - 1] * c) % mod;

		}
		return (int)((resp)%mod);

	}
}
