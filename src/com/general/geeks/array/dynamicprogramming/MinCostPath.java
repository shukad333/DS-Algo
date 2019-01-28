package com.general.geeks.array.dynamicprogramming;

/**
 * Given a cost matrix cost[][] and a position (m, n) in cost[][], write a
 * function that returns cost of minimum cost path to reach (m, n) from (0, 0).
 * Each cell of the matrix represents a cost to traverse through that cell.
 * Total cost of a path to reach (m, n) is sum of all the costs on that path
 * (including both source and destination). You can only traverse down, right
 * and diagonally lower cells from a given cell, i.e., from a given cell (i, j),
 * cells (i+1, j), (i, j+1) and (i+1, j+1) can be traversed. You may assume that
 * all costs are positive integers.
 * 
 * @author skadavath
 *
 */
public class MinCostPath {
	
	public static void main(String[] args) {
		int[][] arr =  { {1, 2, 3},
                {4, 8, 2},
                {1, 5, 3} };
		
		System.out.println(new MinCostPath().minCost(arr));
	}
	
	private int minCost(int[][] arr) {
		
		int m = arr.length;
		int n = arr[0].length;
		
		int[][] dp = new int[m+1][n+1];
		
		dp[0][0] = arr[0][0];
		
		//initialize first row
		for(int i=1;i<m;i++)
			dp[i][0] = dp[i-1][0]+arr[i][0];
		
		//initialize first column
		for(int j=1;j<n;j++)
			dp[0][j] = dp[0][j-1] + arr[0][j];
		
		
		for(int i=1;i<m;i++) {
			for(int j=1;j<n;j++) {
				
				dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]) + arr[i][j];
				
			}
		}
		
		return dp[m-1][n-1];

	}

}
