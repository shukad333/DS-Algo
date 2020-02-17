package com.general.geeks.array;

/**
 * 
 * You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
Example 2:

Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
 * 
 * @author skadavath
 *
 */
public class RotateImage {

	public void rotate(int[][] matrix) {
		
		//first transport i.e matrix[i][j] and matrix[j][i] swapped
		// then swap left and right cols
		
		for(int i=0;i<matrix.length;i++)
			for(int j=i;j<matrix[0].length;j++)
				swap(matrix,i,j,j,i);
		
		for(int i=0;i<matrix.length;i++) {
			for(int j=0,k=matrix[0].length-1;j<k;j++,k--) {
				swap(matrix,i,j,i,k);
			}
		}

	}

	private void swap(int[][] matrix, int a, int b, int c, int d) {

		int temp = matrix[a][b];
		matrix[a][b] = matrix[c][d];
		matrix[c][d] = temp;
	}

}
