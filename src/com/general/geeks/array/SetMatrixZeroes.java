package com.general.geeks.array;

import java.util.Arrays;

/**
 * 
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:

Input: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
Example 2:

Input: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
Follow up:

A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?


 * 
 * @author skadavath
 *
 */
public class SetMatrixZeroes {
	
	public static void main(String[] args) {
		
		int[][] mat = new int[][] {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
		new SetMatrixZeroes().setZeroes(mat);
		System.out.println(Arrays.deepToString(mat));
		
	}

	public void setZeroes(int[][] matrix) {
		
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		boolean fullRow = false;
		boolean fullCol = false;
		
		for(int i=0;i<rows;i++) {
			
			for(int j=0;j<cols;j++) {
				
				if(matrix[i][j]==0) {
					if(i==0)fullRow = true;
					if(j==0)fullCol = true;
					matrix[i][0] = matrix[0][j] = 0;
				}
			}
			
		}
		
		for(int i=1;i<rows;i++) {
			for(int j=1;j<cols;j++) {
				if(matrix[i][0]==0 || matrix[0][j]==0)
					matrix[i][j] = 0;
			}
		}
		
		if(fullCol) {
			for(int i=0;i<cols;i++)
				matrix[0][i] = 0;
		}
		
		if(fullRow)
			for(int j=0;j<rows;j++)
				matrix[j][0] = 0;

	}

}
