package com.general.geeks.array;

import java.util.Arrays;

/**
 * Given an array A of non-negative integers, return an array consisting of all
 * the even elements of A, followed by all the odd elements of A.
 * 
 * You may return any answer array that satisfies this condition.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [3,1,2,4] Output: [2,4,3,1] The outputs [4,2,3,1], [2,4,1,3], and
 * [4,2,1,3] would also be accepted.
 * 
 * 
 * Note:
 * 
 * 1 <= A.length <= 5000 0 <= A[i] <= 5000
 * 
 * @author skadavath
 *
 */
public class SortArrayByParity {

	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(new SortArrayByParity().sortArrayByParity(new int[] {3,1,2,4})));

	}

	public int[] sortArrayByParity(int[] A) {

		int[] resp = new int[A.length];

		int left = 0;
		int right = A.length - 1;
		
		while(left<right) {
		if (A[right] % 2 == 0 && A[left] % 2 != 0) {

			swap(A, left, right);
			left++;
			right--;

		}

		else if (A[right] % 2 != 0)
			right--;
		else if (A[left] % 2 == 0)
			left++;

		}
		return A;

	}

	private void swap(int[] arr, int a, int b) {

		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

}
