package com.general.geeks.array;

import java.util.Arrays;

/**
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.

Example:
Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output:  [1,2,4,7,5,3,6,8,9]
Explanation:

Note:
The total number of elements of the given matrix will not exceed 10,000.
 * @author skadavath
 *
 */
public class DiagonalTraverse {
	
	public static void main(String[] args) {
		
		int[][] mat = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(new DiagonalTraverse().findDiagonalOrder(mat));
	}

	public int[] findDiagonalOrder(int[][] matrix) {
		
		int rows = matrix.length,cols=matrix[0].length;
		int[] resp = new int[rows*cols];
		
		int startX=0,startY=0;
		
		int iter = 0,d=0;
		
		int[][] dir = {{-1,1},{1,-1}}; 
		while(iter<rows*cols) {
			
			resp[iter] = matrix[startX][startY];
			
			startX += dir[d][0];
			startY += dir[d][1];
			
			if(startX>=rows) {
				startX=rows-1;
				startY+=2;
				d=1-d;
			}
			
			if(startY>=cols) {
				startY=cols-1;
				startX+=2;
				d=1-d;
			}
			
			if(startX<0) {
				startX=0;
				d=1-d;
			}
			if(startY<0) {
				startY=0;
				d=1-d;
			}
			
			iter++;
			
			
		}
		
		return resp;

	}

}
