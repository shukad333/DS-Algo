package com.general.geeks.array;

/**
 * 
 * Nearly every one have used the Multiplication Table. But could you find out
 * the k-th smallest number quickly from the multiplication table?
 * 
 * Given the height m and the length n of a m * n Multiplication Table, and a
 * positive integer k, you need to return the k-th smallest number in this
 * table.
 * 
 * Example 1: Input: m = 3, n = 3, k = 5 Output: Explanation: The Multiplication
 * Table: 1 2 3 2 4 6 3 6 9
 * 
 * The 5-th smallest number is 3 (1, 2, 2, 3, 3). Example 2: Input: m = 2, n =
 * 3, k = 6 Output: Explanation: The Multiplication Table: 1 2 3 2 4 6
 * 
 * The 6-th smallest number is 6 (1, 2, 2, 3, 4, 6). Note: The m and n will be
 * in the range [1, 30000]. The k will be in the range [1, m * n]
 * 
 * @author skadavath
 *
 */
public class KthSmallestNumberInMultTable {

	public static void main(String[] args) {

		System.out.println(new KthSmallestNumberInMultTable().findKthNumber(2, 3, 4));

	}

	public int findKthNumber(int m, int n, int k) {
		int left = 1 * 1;
		int right = m * n;
		while (left < right) {
			int mid = left + (right - left) / 2;
			int count = count(mid, m, n);
			if (count < k) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return right;
	}

	private int count(int value, int m, int n) {
		int i = m, j = 1;
		int count = 0;
		while (i >= 1 && j <= n) {
			if (i * j <= value) {
				count += i;
				j++;
			} else {
				i--;
			}
		}
		return count;
	}

}
