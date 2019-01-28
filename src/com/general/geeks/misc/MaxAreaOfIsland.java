package com.general.geeks.misc;

import com.general.geeks.graph.DFS;

/**
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:
[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
Example 2:
[[0,0,0,0,0,0,0,0]]
Given the above grid, return 0.
Note: The length of each dimension in the given grid does not exceed 50.
 * @author skadavath
 *
 */
public class MaxAreaOfIsland {
	
	public static void main(String[] args) {
		
		int[][] islands = new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},
			 {0,0,0,0,0,0,0,1,1,1,0,0,0},
			 {0,1,1,0,1,0,0,0,0,0,0,0,0},
			 {0,1,0,0,1,1,0,0,1,0,1,0,0},
			 {0,1,0,0,1,1,0,0,1,1,1,0,0},
			 {0,0,0,0,0,0,0,0,0,0,1,0,0},
			 {0,0,0,0,0,0,0,1,1,1,0,0,0},
			 {0,0,0,0,0,0,0,1,1,0,0,0,0}};
			 
			 System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(islands));
		
	}

	public int maxAreaOfIsland(int[][] grid) {
		
		int maxArea = 0;
		
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(grid[i][j]==1)
				maxArea = Math.max(maxArea, maxArea(grid, i, j, grid.length, grid[0].length, 0));
			}
		}
		return maxArea;

	}
	
	private int maxArea(int[][] grid , int startX,int startY,int r,int c,int area) {
		
		if(startX<0 || startX>=r || startY<0 || startY>=c || grid[startX][startY]==0) {
			
			return area;
		}
		
		area++;
		grid[startX][startY] = 0;
		area = maxArea(grid, startX+1, startY, r, c, area);
		area = maxArea(grid, startX, startY+1, r, c, area);
		area = maxArea(grid, startX-1, startY, r, c, area);
		area = maxArea(grid, startX, startY-1, r, c, area);
		
		return area;
		
	}

}
