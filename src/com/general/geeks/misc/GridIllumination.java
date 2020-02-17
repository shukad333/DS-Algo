package com.general.geeks.misc;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * On a N x N grid of cells, each cell (x, y) with 0 <= x < N and 0 <= y < N has a lamp.

Initially, some number of lamps are on.  lamps[i] tells us the location of the i-th lamp that is on.  Each lamp that is on illuminates every square on its x-axis, y-axis, and both diagonals (similar to a Queen in chess).

For the i-th query queries[i] = (x, y), the answer to the query is 1 if the cell (x, y) is illuminated, else 0.

After each query (x, y) [in the order given by queries], we turn off any lamps that are at cell (x, y) or are adjacent 8-directionally (ie., share a corner or edge with cell (x, y).)

Return an array of answers.  Each value answer[i] should be equal to the answer of the i-th query queries[i].

 

Example 1:

Input: N = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,0]]
Output: [1,0]
Explanation: 
Before performing the first query we have both lamps [0,0] and [4,4] on.
The grid representing which cells are lit looks like this, where [0,0] is the top left corner, and [4,4] is the bottom right corner:
1 1 1 1 1
1 1 0 0 1
1 0 1 0 1
1 0 0 1 1
1 1 1 1 1
Then the query at [1, 1] returns 1 because the cell is lit.  After this query, the lamp at [0, 0] turns off, and the grid now looks like this:
1 0 0 0 1
0 1 0 0 1
0 0 1 0 1
0 0 0 1 1
1 1 1 1 1
Before performing the second query we have only the lamp [4,4] on.  Now the query at [1,0] returns 0, because the cell is no longer lit.
 
 * 
 * @author skadavath
 *
 */
public class GridIllumination {

public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
		
		
		Map<Integer, Integer> row = new HashMap<>();
		Map<Integer, Integer> col = new HashMap<>();
		Map<Integer, Integer> posSlope = new HashMap<>();
		Map<Integer, Integer> negSlope = new HashMap<>();
		Map<Integer, Boolean> lit = new HashMap<>();
		
		for(int i=0;i<lamps.length;i++) {
			
			int x = lamps[i][0];
			int y = lamps[i][1];
			
			row.put(x, row.getOrDefault(x, 0)+1);
			col.put(y, col.getOrDefault(y, 0)+1);
			posSlope.put(x-y, posSlope.getOrDefault(x-y, 0)+1);
			negSlope.put(x+y, negSlope.getOrDefault(x+y, 0)+1);
			lit.put(x*N+y, true);
			
		}
		
		int[] resp = new int[queries.length];
		int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}, {1,1}, {1,-1}, {-1,1}, {-1,-1}, {0,0}};
		for(int i=0;i<queries.length;i++) {
			
			int x = queries[i][0];
			int y = queries[i][1];
			
			int isLit = (row.getOrDefault(x,0)>0 || col.getOrDefault(y,0)>0 || posSlope.getOrDefault(x-y,0)>0 || negSlope.getOrDefault(x+y,0)>0)  ? 1: 0;
			
			resp[i] = isLit;
			
			for(int[] dir : dirs) {
				int nX = x+dir[0];
				int nY = y+dir[1];
				
				if(lit.containsKey(nX*N+nY) && lit.get(nX*N+nY)) {
					row.put(nX, row.getOrDefault(nX, 1)-1);
					col.put(nY, col.getOrDefault(nY, 1)-1);
					posSlope.put(nX-nY, posSlope.getOrDefault(nX-nY, 1)-1);
					negSlope.put(nX+nY, negSlope.getOrDefault(nX+nY, 1)-1);
					lit.put(nX*N+nY, false);
				}
			}
			
		}
		
		return resp;

	}

}
