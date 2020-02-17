package com.general.geeks.misc;

import java.util.PriorityQueue;

/**
 * 
 * Given an m x n matrix of positive integers representing the height of each
 * unit cell in a 2D elevation map, compute the volume of water it is able to
 * trap after raining.
 * 
 * 
 * 
 * Note:
 * 
 * Both m and n are less than 110. The height of each unit cell is greater than
 * 0 and is less than 20,000.
 * 
 * 
 * 
 * @author skadavath
 *
 */
public class TrappingRainWater2 {

	public static void main(String[] args) {

		int[][] heightMap = { { 1, 4, 3, 1, 3, 2 }, { 3, 2, 1, 3, 2, 4 }, { 2, 3, 3, 2, 3, 1 } };
		System.out.println(new TrappingRainWater2().trapRainWater(heightMap));

	}

	public int trapRainWater(int[][] heightMap) {

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

		int m = heightMap.length;
		int n = heightMap[0].length;

		boolean[][] visited = new boolean[m][n];

		for (int i = 0; i < m; i++) {

			visited[i][0] = true;
			visited[i][n - 1] = true;
			pq.offer(new int[] { i, 0, heightMap[i][0] });
			pq.offer(new int[] { i, n - 1, heightMap[i][n - 1] });

		}

		for (int i = 1; i < n - 1; i++) {

			visited[0][i] = true;
			visited[m - 1][i] = true;
			pq.offer(new int[] { 0, i, heightMap[0][i] });
			pq.offer(new int[] { m - 1, i, heightMap[m - 1][i] });

		}

		int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
		int resp = 0;
		while (!pq.isEmpty()) {

			int[] cell = pq.poll();

			for (int[] dir : dirs) {

				int x = dir[0] + cell[0];
				int y = dir[1] + cell[1];

				if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
					visited[x][y] = true;
					resp += Math.max(0, cell[2] - heightMap[x][y]);
					pq.offer(new int[] { x, y, Math.max(cell[2], heightMap[x][y]) });
				}

			}

		}

		return resp;

	}

}
