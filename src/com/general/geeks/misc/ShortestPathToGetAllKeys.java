package com.general.geeks.misc;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * We are given a 2-dimensional grid. "." is an empty cell, "#" is a wall, "@"
 * is the starting point, ("a", "b", ...) are keys, and ("A", "B", ...) are
 * locks.
 * 
 * We start at the starting point, and one move consists of walking one space in
 * one of the 4 cardinal directions. We cannot walk outside the grid, or walk
 * into a wall. If we walk over a key, we pick it up. We can't walk over a lock
 * unless we have the corresponding key.
 * 
 * For some 1 <= K <= 6, there is exactly one lowercase and one uppercase letter
 * of the first K letters of the English alphabet in the grid. This means that
 * there is exactly one key for each lock, and one lock for each key; and also
 * that the letters used to represent the keys and locks were chosen in the same
 * order as the English alphabet.
 * 
 * Return the lowest number of moves to acquire all keys. If it's impossible,
 * return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: ["@.a.#","###.#","b.A.B"] Output: 8 Example 2:
 * 
 * Input: ["@..aA","..B#.","....b"] Output: 6
 * 
 * 
 * Note:
 * 
 * 1 <= grid.length <= 30 1 <= grid[0].length <= 30 grid[i][j] contains only
 * '.', '#', '@', 'a'-'f' and 'A'-'F' The number of keys is in [1, 6]. Each key
 * has a different letter and opens exactly one lock.
 * 
 * @author skadavath
 *
 */
public class ShortestPathToGetAllKeys {
	
	public static void main(String[] args) {
		String[] grid = new String[] {"@...a",".###A","b.BCc"};
		System.out.println(new ShortestPathToGetAllKeys().shortestPathAllKeys(grid));
	}

	public int shortestPathAllKeys(String[] grid) {

		int min = 0;

		int x = -1, y = -1;

		int m = grid.length;
		int n = grid[0].length();
		int maxKeys = -1;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				char c = grid[i].charAt(j);
				if (c == '@') {
					x = i;
					y = j;
				}

				if (c >= 'a' && c <= 'f') {
					maxKeys = Math.max(c - 'a' + 1, maxKeys);
				}
			}
		}

		Set<String> visited = new HashSet<>();
		
		Queue<Path> queue = new LinkedList<>();
		queue.add(new Path(0,x,y));
		visited.add(0+"*"+x+"*"+y);
		
		int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Path currPath = queue.poll();
				if (currPath.keys == (1 << maxKeys) - 1) {
					return min;
				}
				
				
				for(int[] dir : dirs) {
					int newX = currPath.x+dir[0];
					int newY = currPath.y+dir[1];
					int keys = currPath.keys;
					
					if(newX>=0 && newX<m && newY>=0 && newY<n) {
						char c = grid[newX].charAt(newY);
						if(c=='#')
							continue;
						
						//if key bit store it
						if(c>='a' && c<='f') {
							keys |= 1<<(c-'a');
						}
						//below true means no key .. Don't continue with this path
						if(c>='A' && c<='F' && ((keys >> (c-'A')) & 1)==0) {
							continue;
						}
						
						if(!visited.contains(keys+"*"+newX+"*"+newY)) {
							visited.add(keys+"*"+newX+"*"+newY);
							queue.offer(new Path(keys,newX,newY));
						}
					}
				}
				
			}
			min++;

		}

		return -1;

	}

}

class Path {
	int keys;
	int x;
	int y;

	public Path(int keys, int x, int y) {
		this.keys = keys;
		this.x = x;
		this.y = y;
	}
}
