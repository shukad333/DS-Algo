package com.general.geeks.array.dynamicprogramming;

/**
 * 
 * Given a gold mine of n*m dimensions. Each field in this mine contains a
 * positive integer which is the amount of gold in tons. Initially the miner is
 * at first column but can be at any row. He can move only (right->,right up
 * /,right down\) that is from a given cell, the miner can move to the cell
 * diagonally up towards the right or right or diagonally down towards the
 * right. Find out maximum amount of gold he can collect.
 * 
 * Examples:
 * 
 * Input : mat[][] = {{1, 3, 3}, {2, 1, 4}, {0, 6, 4}}; Output : 12
 * {(1,0)->(2,1)->(2,2)}
 * 
 * Input: mat[][] = { {1, 3, 1, 5}, {2, 2, 4, 1}, {5, 0, 2, 3}, {0, 6, 1, 2}};
 * Output : 16 (2,0) -> (1,1) -> (1,2) -> (0,3) OR (2,0) -> (3,1) -> (2,2) ->
 * (2,3)
 * 
 * Input : mat[][] = {{10, 33, 13, 15}, {22, 21, 04, 1}, {5, 0, 2, 3}, {0, 6,
 * 14, 2}}; Output : 83
 * 
 * Source Flipkart Interview
 * 
 * @author skadavath
 *
 */
public class GoldMineProblem {

	public static void main(String[] args) {

		System.out.println(new GoldMineProblem()
				.getMaxGold(new int[][] { { 10, 33, 13, 15 }, { 22, 21, 04, 1 }, { 5, 0, 2, 3 }, { 0, 6, 14, 2 } }));

	}

	public int getMaxGold(int[][] gold) {
		int m = gold.length;
		int n = gold[0].length;

		int[][] goldDp = new int[m][n];

		for (int col = n - 1; col >= 0; col--) {
			for (int row = 0; row < n; row++) {

				// if possible go topRight and collect else 0
				int topRight = (col == n - 1 || row == 0) ? 0 : goldDp[row - 1][col + 1];

				// same for right
				int right = (col == n - 1) ? 0 : goldDp[row][col + 1];

				// same for down right
				int downRight = (row == m - 1 || col == n - 1) ? 0 : goldDp[row + 1][col + 1];

				goldDp[row][col] = gold[row][col] + Math.max(topRight, Math.max(right, downRight));

			}
		}

		int resp = 0;
		// first row will have the max
		for (int i = 0; i < m; i++) {
			resp = Math.max(resp, goldDp[i][0]);
		}

		return resp;
	}

}
