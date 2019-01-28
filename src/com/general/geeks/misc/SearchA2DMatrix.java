package com.general.geeks.misc;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true
Example 2:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false

 * @author skadavath
 *
 */
public class SearchA2DMatrix {
	
	
	public static void main(String[] args) {
		
		int[][] mat = {
		               {1,1}}
		              ;
		
		System.out.println(new SearchA2DMatrix().searchMatrix(mat, 2));
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		
		if(matrix.length==0)
			return false;
		int i=0;
		int j = matrix[0].length;
		
		
		
		while(i<matrix.length && j>=0) {
			
			if(matrix[i][j]==target)
				return true;
			else if(matrix[i][j]>target) {
				j--;
			}
			else
				i++;
		}
		return false;

	}

}
