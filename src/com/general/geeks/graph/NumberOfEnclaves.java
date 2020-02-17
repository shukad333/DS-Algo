package com.general.geeks.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * Given a 2D array A, each cell is 0 (representing sea) or 1 (representing land)

A move consists of walking from one land square 4-directionally to another land square, or off the boundary of the grid.

Return the number of land squares in the grid for which we cannot walk off the boundary of the grid in any number of moves.

 

Example 1:

Input: [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
Output: 3
Explanation: 
There are three 1s that are enclosed by 0s, and one 1 that isn't enclosed because its on the boundary.
Example 2:

Input: [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
Output: 0
Explanation: 
All 1s are either on the boundary or can reach the boundary.
 

Note:

1 <= A.length <= 500
1 <= A[i].length <= 500
0 <= A[i][j] <= 1
All rows have the same size.
 * 
 * @author skadavath
 *
 */
public class NumberOfEnclaves {
	
	


	public static void main(String[] args) throws Exception {
		
		System.out.println("Shu");
		java.util.List<String> list = new ArrayList<>();//Arrays.asList("shu","naoor");
		
		list.stream().findAny().orElseThrow(()->new Exception("done!"));
		
		
		
	}

	public int numEnclaves(int[][] A) {
		
		//first change the 1's connected from the boundary to 0 and
		//count the rest of the ones in the grid
		
		for(int i=0;i<A.length;i++) {
			for(int j=0;j<A[0].length;j++) {
				if(i==0 || i==A.length-1 || j==0 || j==A[0].length-1) {
					dfs(A, i, j);
				}
			}
		}
		
		int resp = 0;
		for(int i=0;i<A.length;i++) {
			for(int j=0;j<A[0].length;j++) {
				if(A[i][j]==1)
					resp++;
					
			}
		}
		
		return resp;

	}
	
	
	private void dfs(int[][] A , int i , int j) {
		
		if(i>=0 && i<A.length && j>=0 && j<A[0].length && A[i][j]==1) {
			A[i][j] = 0;
			dfs(A, i, j+1);
			dfs(A, i, j-1);
			dfs(A, i-1, j);
			dfs(A, i+1, j);
		}
	}

}
