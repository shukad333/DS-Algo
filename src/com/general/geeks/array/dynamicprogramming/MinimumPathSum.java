package com.general.geeks.array.dynamicprogramming;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * Example:
 * 
 * Input: [ [1,3,1], [1,5,1], [4,2,1] ] Output: 7 Explanation: Because the path
 * 1→3→1→1→1 minimizes the sum.
 * 
 * @author skadavath
 *
 */
public class MinimumPathSum {
	
	public static void main(String[] args) {
		
		System.out.println(new MinimumPathSum().minPathSum(new int[][] {{1,3,1},{1,5,1},{4,2,1}}));
		
	}

	public int minPathSum(int[][] grid) {
		
		int[][] path = new int[grid.length][grid[0].length];
		
		path[0][0] = grid[0][0];
		for(int i=1;i<grid.length;i++) {
			path[i][0] = path[i-1][0] + grid[i][0];
		}
		
		for(int i=1;i<grid[0].length;i++) {
			path[0][i] = path[0][i-1] + grid[0][i];
		}
		
		for(int i=1;i<grid.length;i++) {
			for(int j=1;j<grid[0].length;j++) {
				path[i][j] = Math.min(path[i][j-1], path[i-1][j])+grid[i][j];
			}
		}
		
		return path[grid.length-1][grid[0].length-1];

	}

}
