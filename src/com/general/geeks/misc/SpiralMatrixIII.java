package com.general.geeks.misc;

import java.util.Arrays;

/**
 * On a 2 dimensional grid with R rows and C columns, we start at (r0, c0)
 * facing east.
 * 
 * Here, the north-west corner of the grid is at the first row and column, and
 * the south-east corner of the grid is at the last row and column.
 * 
 * Now, we walk in a clockwise spiral shape to visit every position in this
 * grid.
 * 
 * Whenever we would move outside the boundary of the grid, we continue our walk
 * outside the grid (but may return to the grid boundary later.)
 * 
 * Eventually, we reach all R * C spaces of the grid.
 * 
 * Return a list of coordinates representing the positions of the grid in the
 * order they were visited.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: R = 1, C = 4, r0 = 0, c0 = 0 Output: [[0,0],[0,1],[0,2],[0,3]]
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: R = 5, C = 6, r0 = 1, c0 = 4 Output:
 * [[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]
 * 
 * 
 * 
 * Note:
 * 
 * 1 <= R <= 100 1 <= C <= 100 0 <= r0 < R 0 <= c0 < C
 * 
 * @author skadavath
 *
 */
public class SpiralMatrixIII {
	
	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(new SpiralMatrixIII().spiralMatrixIII(1, 4, 0, 0)));
	}

	public int[][] spiralMatrixIII(int R, int C, int r, int c) {

		int[][] resp = new int[R * C][2];

		// moves = right , down , left and up
		int[][] moves = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		
		resp[0] = new int[] {r,c};
		int iter = 0;
		int total = R * C;
		int movesIter = 0;
		
		
		 int x = 0, y = 1, n = 0, i = 0, tmp, j = 1;
		 /**
		  * Number of steps is like 1,1,2,2,3,3,4,4....
		  * Hence , first is 1 step to right
		  * 2nd is 1 step down
		  * 3rd is 2 step left
		  * 4th is 2 step up
		  * 5th is 3 step right
		  * 
		  * So An = (n+1)/2
		  */
		while (j < total) {
			
			r += x; c += y; iter++;
            if (0 <= r && r < R && 0 <= c && c < C)
                resp[j++] = new int[] {r, c};
            if (iter == n / 2 + 1) {
                iter = 0; n++; tmp = x; x = y; y = -tmp;
            }
			

		}
		return resp;

	}

}
