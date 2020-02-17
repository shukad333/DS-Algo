package com.general.geeks.graph;

import java.util.Set;

/**
 * 
 * In a 2D grid of 0s and 1s, we change at most one 0 to a 1.

After, what is the size of the largest island? (An island is a 4-directionally connected group of 1s).

Example 1:

Input: [[1, 0], [0, 1]]
Output: 3
Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
Example 2:

Input: [[1, 1], [1, 0]]
Output: 4
Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
Example 3:

Input: [[1, 1], [1, 1]]
Output: 4
Explanation: Can't change any 0 to 1, only one island with area = 4.
 

Notes:

1 <= grid.length = grid[0].length <= 50.
0 <= grid[i][j] <= 1.

 * 
 * @author skadavath
 *
 */
public class MakingALargeIsland {
	
	public static void main(String[] args) {
		
		System.out.println(new MakingALargeIsland().largestIsland(new int[][] {{0,0,0,0,0,0,0},{0,1,1,1,1,0,0},{0,1,0,0,1,0,0},{1,0,1,0,1,0,0},{0,1,0,0,1,0,0},{0,1,0,0,1,0,0},{0,1,1,1,1,0,0}}));
		
	}

	public int largestIsland(int[][] grid) {
		
		boolean hasSomeZeros = false;
		int M = grid.length,N=grid[0].length;
		int max = Integer.MIN_VALUE;
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(grid[i][j]==0) {
					grid[i][j] = 1;
					max = Math.max(max, dfs(grid, i, j, new boolean[M][N]));
					hasSomeZeros = true;
					if(max==M*N)
						return max;
					grid[i][j] = 0;
					
				}
			}
		}
		
		return hasSomeZeros?max:M*N;

	}
	
	private int dfs(int[][] grid,int x, int y,boolean[][] visited) {
		if(x<0 || x>=grid.length || y<0 || y>=grid[0].length || grid[x][y]==0 || visited[x][y])
			return 0;
		
		visited[x][y] = true;
		return 1+dfs(grid, x+1, y, visited)+dfs(grid, x, y+1, visited)+dfs(grid, x-1, y, visited)+dfs(grid, x, y-1, visited);
	}

}
