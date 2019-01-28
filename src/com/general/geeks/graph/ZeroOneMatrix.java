package com.general.geeks.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for
 * each cell.
 * 
 * The distance between two adjacent cells is 1. Example 1: Input:
 * 
 * 0 0 0 0 1 0 0 0 0 Output: 0 0 0 0 1 0 0 0 0 Example 2: Input:
 * 
 * 0 0 0 0 1 0 1 1 1 Output: 0 0 0 0 1 0 1 2 1 Note: The number of elements of
 * the given matrix will not exceed 10,000. There are at least one 0 in the
 * given matrix. The cells are adjacent in only four directions: up, down, left
 * and right.
 * 
 * @author skadavath
 *
 */
public class ZeroOneMatrix {
	
	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(new ZeroOneMatrix().updateMatrix(new int[][] {{0,0,0,0},{0,1,1,0},{1,1,1,1},{1,1,1,1}})));
	}

	public int[][] updateMatrix(int[][] matrix) {
		
		int m = matrix.length;
		int n = matrix[0].length;
		
		Queue<int[]> queue = new LinkedList<>();
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(matrix[i][j]==0) {
					queue.add(new int[] {i,j});
				}
				else {
					//in case its one
					matrix[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i=0;i<size;i++) {
				int[] cell = queue.poll();
				for(int[] d : dirs) {
					int r = d[0]+cell[0];
					int c = d[1] + cell[1];
					
					if(r<0 || r>=m || c<0 || c>=n || matrix[r][c]<=matrix[cell[0]][cell[1]]+1) continue;
					queue.add(new int[] {r,c});
					matrix[r][c] = matrix[cell[0]][cell[1]]+1;
				}
				
			}
		}
		return matrix;

	}
}
