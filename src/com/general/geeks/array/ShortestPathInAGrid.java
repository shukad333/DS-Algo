package com.general.geeks.array;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInAGrid {
	
	public static void main(String[] args) {
		
		//0 - cannot move,9 destinatoin,1-can move
		int[][] grid = new int[][] {{1,1,0,1},{1,1,0,9},{1,1,1,9}};
		System.out.println(new ShortestPathInAGrid().shortestPath(grid));
		
	}
	
	public int shortestPath(int[][] grid) {
		
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(grid[i][j]==0)
					visited[i][j] = true; 
			}
		}
		
		GridWithPath gridWithPath = new GridWithPath(0,0,0);
		Queue<GridWithPath> queue = new LinkedList<>();
		queue.add(gridWithPath);
		visited[0][0] = true;
		
		while(!queue.isEmpty()) {
			
			GridWithPath poll = queue.poll();
			
			
			if(grid[poll.i][poll.j]==9) {
				return poll.dist;
			}
			
			if(poll.i<grid.length-1 && !visited[poll.i+1][poll.j]) {
				queue.add(new GridWithPath(poll.i+1, poll.j, poll.dist+1));
				visited[poll.i+1][poll.j] = true;
			}
			
			if(poll.j<grid[0].length-1 && !visited[poll.i][poll.j+1]) {
				queue.add(new GridWithPath(poll.i, poll.j+1, poll.dist+1));
				visited[poll.i][poll.j+1] = true;
			}
			
		}
		
		return -1;
		
	}

}

class GridWithPath {
	int i,j,dist;
	public GridWithPath(int i, int j,int dist) {
		
		this.i = i;
		this.j = j;
		this.dist = dist;
	}
}
