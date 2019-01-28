package com.general.geeks.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * In a given 2D binary array A, there are two islands.  (An island is a 4-directionally connected group of 1s not connected to any other 1s.)

Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.

Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at least 1.)

 

Example 1:

Input: [[0,1],[1,0]]
Output: 1
Example 2:

Input: [[0,1,0],[0,0,0],[0,0,1]]
Output: 2
Example 3:

Input: [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
Output: 1
 

Note:

1 <= A.length = A[0].length <= 100
A[i][j] == 0 or A[i][j] == 1

 * 
 * @author skadavath
 *
 */
public class ShortestBridge {
	
	public static void main(String[] args) {
		
		System.out.println(new ShortestBridge().shortestBridge(new int[][] {{0,1,0},{0,0,0},{0,0,1}}));
		
	}

	public int shortestBridge(int[][] A) {
		
		//first find out where the first island is
		
		boolean[][] visited = new boolean[A.length][A[0].length];
		Queue<int[]> queue = new LinkedList<>();
		boolean found = false;
		for(int i=0;i<A.length && !found;i++) {
			for(int j=0;j<A[0].length;j++) {
				if(A[i][j]==1) {
					found = true;
					dfs(A, queue, i, j, visited);
					break;
				}
			}
		}
		
		if(!found) {
			return -1;
		}
		
		//do a BFS to connect to the other island
		
		int distance = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				
				int[] polled = queue.poll();
				for(int[] dir : dirs) {
					int dx = polled[0] + dir[0];
					int dy = polled[1] + dir[1];
					if(dx>=0 && dx<A.length && dy>=0 && dy<A[0].length && !visited[dx][dy]) {
						if(A[dx][dy]==1) {
							return distance;
						}
						queue.add(new int[] {dx,dy});
						visited[dx][dy] = true;
					}
				}
				
			}
			distance++;
		}
		
		return 0;

	}
	
	int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
	private void dfs(int[][] A,Queue<int[]> queue,int i,int j,boolean[][] visited) {
		
		if(i<0 || i>=A.length || j<0 || j>=A[0].length || visited[i][j] || A[i][j]==0)
			return;
		
		visited[i][j] = true;
		queue.add(new int[] {i,j});
		for(int[] dir : dirs) {
			
			dfs(A, queue, i+dir[0], j+dir[1], visited);
			
		}
		
	}

}
