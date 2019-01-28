package com.general.geeks.array;

/**
 * 
 * On a 2-dimensional grid, there are 4 types of squares:
 * 
 * 1 represents the starting square. There is exactly one starting square. 2
 * represents the ending square. There is exactly one ending square. 0
 * represents empty squares we can walk over. -1 represents obstacles that we
 * cannot walk over. Return the number of 4-directional walks from the starting
 * square to the ending square, that walk over every non-obstacle square exactly
 * once.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]] Output: 2 Explanation: We have the
 * following two paths: 1.
 * (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2) 2.
 * (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2) Example 2:
 * 
 * Input: [[1,0,0,0],[0,0,0,0],[0,0,0,2]] Output: 4 Explanation: We have the
 * following four paths: 1.
 * (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3) 2.
 * (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3) 3.
 * (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3) 4.
 * (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
 * Example 3:
 * 
 * Input: [[0,1],[2,0]] Output: 0 Explanation: There is no path that walks over
 * every empty square exactly once. Note that the starting and ending square can
 * be anywhere in the grid.
 * 
 * 
 * @author skadavath
 *
 */
public class UniquePaths3 {
	
	public static void main(String[] args) {
		
		System.out.println(new UniquePaths3().uniquePathsIII(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,2,-1}}));
		
	}

	int empty = 1;
	int sx, sy = 0;
	int ex, ey = 0;
	int resp = 0;

	public int uniquePathsIII(int[][] grid) {

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					sx = i;
					sy = j;
				} else if (grid[i][j] == 2) {
					ex = i;
					ey = j;
				} else if(grid[i][j]==0)
					empty++;
			}
		}

		dfs(grid, sx, sy);
		return resp;

	}

	private void dfs(int[][] grid, int x, int y) {
		if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] < 0)
			return;

		if (x == ex && y == ey && empty == 0) {
			resp++;
			return;
		}

		empty--;
		grid[x][y] = -2;
		dfs(grid, x, y + 1);
		dfs(grid, x + 1, y);
		dfs(grid, x - 1, y);
		dfs(grid, x, y - 1);
		grid[x][y] = 0;
		empty++;
	}

}
