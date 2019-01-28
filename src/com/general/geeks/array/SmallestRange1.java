package com.general.geeks.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Given an array A of integers, for each integer A[i] we may choose any x with
 * -K <= x <= K, and add x to A[i].
 * 
 * After this process, we have some array B.
 * 
 * Return the smallest possible difference between the maximum value of B and
 * the minimum value of B.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: A = [1], K = 0 Output: 0 Explanation: B = [1] Example 2:
 * 
 * Input: A = [0,10], K = 2 Output: 6 Explanation: B = [2,8] Example 3:
 * 
 * Input: A = [1,3,6], K = 3 Output: 0 Explanation: B = [3,3,3] or B = [4,4,4]
 * 
 * 
 * Note:
 * 
 * 1 <= A.length <= 10000 0 <= A[i] <= 10000 0 <= K <= 10000
 * 
 * 
 * @author skadavath
 *
 */
public class SmallestRange1 {

	public static void main(String[] args) {

		System.out.println(new SmallestRange1().smallestRangeI(new int[] { 0, 10 }, 2));
		

	}

	public int smallestRangeI(int[] A, int K) {

		Arrays.sort(A);
		int min = A[0];
		int max = A[A.length - 1];

		return min + K >= max - K ? 0 : (max - K) - (min + K);

	}

}
