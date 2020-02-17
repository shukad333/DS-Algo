package com.general.geeks.misc;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * n a given grid, each cell can have one of three values:
 * 
 * the value 0 representing an empty cell; the value 1 representing a fresh
 * orange; the value 2 representing a rotten orange. Every minute, any fresh
 * orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 * 
 * Return the minimum number of minutes that must elapse until no cell has a
 * fresh orange. If this is impossible, return -1 instead.
 * 
 * Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Note:

1 <= grid.length <= 10
1 <= grid[0].length <= 10
grid[i][j] is only 0, 1, or 2.
 * 
 * @author skadavath
 *
 */
public class RottingOranges {
	
	public static void main(String[] args) {
		
		System.out.println(new RottingOranges().orangesRotting(new int[][] {{2,1,1},{1,1,0},{0,1,1}}));
	}

	public int orangesRotting(int[][] grid) {

		Queue<int[]> queue = new LinkedList<>();
		int freshCount = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {

				if (grid[i][j] == 2) {
					queue.add(new int[] { i, j });
				} else if (grid[i][j] == 1) {
					freshCount++;
				}

			}
		}

			if (freshCount == 0)
				return 0;

			int minutes = 0;
			int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
			while (!queue.isEmpty()) {

				int size = queue.size();
				for (int i = 0; i < size; i++) {
					int[] current = queue.poll();
					
					for(int[] dir : dirs) {
						
						int nextX = current[0] + dir[0];
						int nextY = current[1] + dir[1];
						
						if(nextX>=0 && nextX<grid.length && nextY>=0 && nextY<grid[0].length && grid[nextX][nextY]==1) {
							grid[nextX][nextY] = 2;
							queue.add(new int[] {nextX,nextY});
							freshCount--;
						}
						
					}
				}
				minutes++;
			}


		return freshCount==0?minutes-1:-1;

	}

}
