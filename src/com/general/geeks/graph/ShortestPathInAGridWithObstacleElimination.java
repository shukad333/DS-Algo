package com.general.geeks.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Given a m * n grid, where each cell is either 0 (empty) or 1 (obstacle). In
 * one step, you can move up, down, left or right from and to an empty cell.
 * 
 * Return the minimum number of steps to walk from the upper left corner (0, 0)
 * to the lower right corner (m-1, n-1) given that you can eliminate at most k
 * obstacles. If it is not possible to find such walk return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: grid = [[0,0,0], [1,1,0], [0,0,0], [0,1,1], [0,0,0]], k = 1 Output: 6
 * Explanation: The shortest path without eliminating any obstacle is 10. The
 * shortest path with one obstacle elimination at position (3,2) is 6. Such path
 * is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).
 * 
 * 
 * Example 2:
 * 
 * Input: grid = [[0,1,1], [1,1,1], [1,0,0]], k = 1 Output: -1 Explanation: We
 * need to eliminate at least two obstacles to find such a walk.
 * 
 * 
 * Constraints:
 * 
 * grid.length == m grid[0].length == n 1 <= m, n <= 40 1 <= k <= m*n grid[i][j]
 * == 0 or 1 grid[0][0] == grid[m-1][n-1] == 0
 * 
 * @author skadavath
 *
 */
public class ShortestPathInAGridWithObstacleElimination {

	public int shortestPath(int[][] grid, int k) {

		Queue<int[]> queue = new LinkedList<int[]>();
		int m = grid.length, n = grid[0].length;
		int[][][] dist = new int[m][n][k + 1];
		for (int[][] dis : dist)
			for (int[] d : dis)
				Arrays.fill(d, Integer.MAX_VALUE);
		queue.offer(new int[] { 0, 0, k });
		dist[0][0][k] = 0;
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int x = curr[0], y = curr[1], currK = curr[2];
			int currDist = dist[x][y][currK];
			if (x == m - 1 && y == n - 1)
				return currDist;
			int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
			for (int[] dir : dirs) {
				int nextX = x + dir[0], nextY = y + dir[1], nextK = currK;
				if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n) {
					if (grid[nextX][nextY] == 1)
						nextK--;
					if (nextK >= 0 && currDist + 1 < dist[nextX][nextY][nextK]) {
						dist[nextX][nextY][nextK] = currDist + 1;
						queue.offer(new int[] { nextX, nextY, nextK });
					}
				}
			}
		}
		return -1;

	}

}
