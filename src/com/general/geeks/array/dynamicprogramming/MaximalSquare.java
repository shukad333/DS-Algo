package com.general.geeks.array.dynamicprogramming;

/**
 * 
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square
 * containing only 1's and return its area.
 * 
 * Example:
 * 
 * Input:
 * 
 * 1 0 1 0 0 1 0 1 1 1 1 1 1 1 1 1 0 0 1 0
 * 
 * Output: 4
 * 
 * @author skadavath
 *
 */
public class MaximalSquare {

	public static void main(String[] args) {

		System.out.println(new MaximalSquare().maximalSquare(new char[][] { { '1', '0', '1', '0', '0' },
				{ '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' }, { '1', '0', '0', '0', '1', '0' } }));

	}

	public int maximalSquare(char[][] matrix) {

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;

		int m = matrix.length, n = matrix[0].length;

		// dp(i, j) represents the length of the square
		// whose lower-right corner is located at (i, j)
		// dp(i, j) = min{ dp(i-1, j-1), dp(i-1, j), dp(i, j-1) }
		int[][] dp = new int[m + 1][n + 1];
		int resp = 0;

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {

				if (matrix[i - 1][j - 1] == '1') {
					dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
					resp = Math.max(resp, dp[i][j]);
				}

			}
		}

		return resp * resp;

	}
}
