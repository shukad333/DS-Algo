package com.general.geeks.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given the following details of a matrix with n columns and 2 rows :

The matrix is a binary matrix, which means each element in the matrix can be 0 or 1.
The sum of elements of the 0-th(upper) row is given as upper.
The sum of elements of the 1-st(lower) row is given as lower.
The sum of elements in the i-th column(0-indexed) is colsum[i], where colsum is given as an integer array with length n.
Your task is to reconstruct the matrix with upper, lower and colsum.

Return it as a 2-D integer array.

If there are more than one valid solution, any of them will be accepted.

If no valid solution exists, return an empty 2-D array.

 

Example 1:

Input: upper = 2, lower = 1, colsum = [1,1,1]
Output: [[1,1,0],[0,0,1]]
Explanation: [[1,0,1],[0,1,0]], and [[0,1,1],[1,0,0]] are also correct answers.
Example 2:

Input: upper = 2, lower = 3, colsum = [2,2,1,1]
Output: []
Example 3:

Input: upper = 5, lower = 5, colsum = [2,1,2,0,1,0,1,2,0,1]
Output: [[1,1,1,0,1,0,0,1,0,0],[1,0,1,0,0,0,1,1,0,1]]
 

Constraints:

1 <= colsum.length <= 10^5
0 <= upper, lower <= colsum.length
0 <= colsum[i] <= 2
Accepted
 * 
 * @author skadavath
 *
 */
public class Reconstruct2RowBinaryMatrix {
	
	public static void main(String[] args) {
		
		
		System.out.println(new Reconstruct2RowBinaryMatrix().reconstructMatrix(2, 1, new int[] {1,1,1}));
		
	}
	
	public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
		
		int[][] matrix = new int[2][colsum.length];
		
		for(int i=0;i<colsum.length;i++)
			if(colsum[i]==2) {
				matrix[0][i] = 1;
				matrix[1][i] = 1;
			}
		
		int curruppersum = Arrays.stream(matrix[0]).sum();
		int diff = upper - curruppersum;
		
		if(diff<0)
			return new ArrayList<List<Integer>>();
		
		for(int i=0;i<colsum.length;i++) {
			if(colsum[i]==1)
				if(diff-->0) 
					matrix[0][i] = 1;
				else
					matrix[1][i] = 1;
		}
		
		int currlowersum = Arrays.stream(matrix[1]).sum();
		if(currlowersum!=lower)
			return new ArrayList<>();
		
		List<List<Integer>> resp = new ArrayList<>();
		for(int i=0;i<2;i++) {
			List<Integer> curr = new ArrayList<>();
			for(int j=0;j<colsum.length;j++) {
				curr.add(matrix[i][j]);
				
			}
			resp.add(curr);
		}
		
		return resp;

	}

}
