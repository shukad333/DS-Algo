package com.general.geeks.array;

/**
 * 
 * Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.

Return the number of closed islands.

Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
Output: 2
Explanation: 
Islands in gray are closed because they are completely surrounded by water (group of 1s).
Example 2:



Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
Output: 1
Example 3:

Input: grid = [[1,1,1,1,1,1,1],
               [1,0,0,0,0,0,1],
               [1,0,1,1,1,0,1],
               [1,0,1,0,1,0,1],
               [1,0,1,1,1,0,1],
               [1,0,0,0,0,0,1],
               [1,1,1,1,1,1,1]]
Output: 2
 

Constraints:

1 <= grid.length, grid[0].length <= 100
0 <= grid[i][j] <=1
 * 
 * @author skadavath
 *
 */
public class NumberOfClosedIslands {
	
	public static void main(String[] args) {
		
		System.out.println(new NumberOfClosedIslands().closedIsland(new int[] []{}));
		
	}

	public int closedIsland(int[][] grid) {
		
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(i*(i+1-grid.length) * j * (j+1-grid[0].length)==0)
					floodfill(grid,i,j);
			}
		}
		
		int resp = 0;
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
					resp += floodfill(grid,i,j);
			}
		}
		
		return resp;

	}
	
	private int floodfill(int[][] grid,int i,int j) {
		
		if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]!=0)
			return 0;
		
		return grid[i][j]=1 + floodfill(grid,i+1,j) + floodfill(grid,i,j+1) + floodfill(grid,i-1,j) + floodfill(grid,i,j-1);
		
	}

}
