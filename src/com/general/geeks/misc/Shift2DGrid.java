package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * Given a 2D grid of size n * m and an integer k. You need to shift the grid k times.

In one shift operation:

Element at grid[i][j] becomes at grid[i][j + 1].
Element at grid[i][m - 1] becomes at grid[i + 1][0].
Element at grid[n - 1][m - 1] becomes at grid[0][0].
Return the 2D grid after applying shift operation k times.

 

Example 1:

Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
Output: [[9,1,2],[3,4,5],[6,7,8]]
 * 
 * @author skadavath
 *
 */
public class Shift2DGrid {
	
	public static void main(String[] args) {
		
		int[][] grid = {{3,8,1,9},{19,7,2,5},{4,6,11,10},{12,0,21,13}};
		
		System.out.println(new Shift2DGrid().shiftGrid(grid, 4));
		
	}

	public List<List<Integer>> shiftGrid(int[][] grid, int k) {

		int m = grid.length, n = grid[0].length;

		int start = m * n - k % (m * n);
		LinkedList<List<Integer>> resp = new LinkedList<>();
		for (int i = start; i < start + (m * n); i++) {
			int j = i % (m * n), r = j / n, c = j % n;
			if ((i - start) % n == 0)
				resp.add(new ArrayList<>());

			resp.peekLast().add(grid[r][c]);

		}

		return resp;

	}

}
