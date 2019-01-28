package com.general.geeks.array;

import java.util.Arrays;

/**
 * 
 * Given an array of integers A sorted in non-decreasing order, return an array
 * of the squares of each number, also in sorted non-decreasing order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [-4,-1,0,3,10] Output: [0,1,9,16,100] Example 2:
 * 
 * Input: [-7,-3,2,3,11] Output: [4,9,9,49,121]
 * 
 * 
 * Note:
 * 
 * 1 <= A.length <= 10000 -10000 <= A[i] <= 10000 A is sorted in non-decreasing
 * order.
 * 
 * 
 * @author skadavath
 *
 */
public class SquaresOfSortedArray {

	public static void main(String[] args) {

		System.out.println(Arrays.toString(new SquaresOfSortedArray().sortedSquares(new int[] { -7, -3, 2, 3, 11 })));

	}

	public int[] sortedSquares(int[] A) {

		int n = A.length;
		int[] resp = new int[n];

		for (int i = 0, j = n - 1, r = n - 1; r >= 0; r--) {

			if (Math.abs(A[i]) > Math.abs(A[j])) {
				resp[r] = A[i] * A[i];
				i++;
			} else {
				resp[r] = A[j] * A[j];
				j--;
			}
		}

		return resp;

	}

}
