package com.general.geeks.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Given an integer matrix, find the length of the longest increasing path.
 * 
 * From each cell, you can either move to four directions: left, right, up or
 * down. You may NOT move diagonally or move outside of the boundary (i.e.
 * wrap-around is not allowed).
 * 
 * Example 1:
 * 
 * Input: nums = [ [9,9,4], [6,6,8], [2,1,1] ] Output: 4 Explanation: The
 * longest increasing path is [1, 2, 6, 9]. Example 2:
 * 
 * Input: nums = [ [3,4,5], [3,2,6], [2,2,1] ] Output: 4 Explanation: The
 * longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 * 
 * @author skadavath
 *
 */
public class LongestIncreasingPathInAMatrix {

	public static void main(String[] args) {

		System.out.println(new LongestIncreasingPathInAMatrix()
				.longestIncreasingPath(new int[][] { { 3, 4, 5 }, { 3, 2, 6 }, { 2, 2, 1 } }));

	}

	public int longestIncreasingPath(int[][] matrix) {

		int[][] cache = new int[matrix.length][matrix[0].length];
		int longest = Integer.MIN_VALUE;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				longest = Math.max(longest, dfs(matrix, i, j, cache));
			}
		}
		return longest;

	}

	int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	private int dfs(int[][] matrix, int i, int j, int[][] cache) {

		if (cache[i][j] != 0)
			return cache[i][j];
		int longest = 1;
		for (int[] dir : dirs) {
			int dx = i + dir[0];
			int dy = j + dir[1];

			if (dx < 0 || dx >= matrix.length || dy < 0 || dy >= matrix[0].length || matrix[dx][dy] <= matrix[i][j])
				continue;

			int len = 1 + dfs(matrix, dx, dy, cache);
			longest = Math.max(longest, len);

		}

		cache[i][j] = longest;
		return longest;

	}

}
