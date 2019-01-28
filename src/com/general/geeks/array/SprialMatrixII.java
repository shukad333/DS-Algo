package com.general.geeks.array;

import java.util.Arrays;

import com.general.geeks.misc.SpiralMatrixIII;

/**
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

 * @author skadavath
 *
 */
public class SprialMatrixII {

	public static void main(String[] args) {
		
		System.out.println(Arrays.deepToString(new SprialMatrixII().generateMatrix(3)));

	}

	public int[][] generateMatrix(int s) {

		int[][] matrix = new int[s][s];
		int m = matrix.length, n = matrix[0].length;
		int k = 0, l = 0;

		int num = 1;
		while (k <=m && l <= n) {

			for (int i = l; i < n; i++) {
				matrix[k][i] = num++;
			}
			k++;

			for (int i = k; i < m; i++) {
				matrix[i][n - 1] = num++;
			}
			n--;
			if (k < m) {
				for (int i = n - 1; i >= l; i--) {
					matrix[m - 1][i] = num++;
				}
				m--;
			}
			if (l < n) {
				for (int i = m; i >= k; i--) {
					matrix[i][l - 1] = num++;
				}
				l++;
			}

		}

		return matrix;

	}
}
