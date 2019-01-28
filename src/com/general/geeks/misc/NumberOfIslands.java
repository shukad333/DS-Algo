package com.general.geeks.misc;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3

 * @author skadavath
 *
 */
public class NumberOfIslands {
	
	public static void main(String[] args) {
		//System.out.println(new NumberOfIslands().numIslands(new char[]));
	}

	public int numIslands(char[][] grid) {
		
		int count = 0;
		
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(grid[i][j]==1) {
					dfs(grid, i, j, grid.length, grid[0].length);
					count++;
				}
			}
		}
		return count;

	}
	
	private void dfs(char[][] grid , int startX , int startY , int m , int n) {
		if(startX<0 || startY >= n || startX>=m || startY<0 || grid[startX][startY]!='1') {
			return;
		}
		
		grid[startX][startY] = '0';
		
		dfs(grid, startX+1, startY, m, n);
		dfs(grid, startX-1, startY, m, n);
		dfs(grid, startX, startY+1, m, n);
		dfs(grid, startX+1, startY-1, m, n);
	}

}
