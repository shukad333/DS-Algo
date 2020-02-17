package com.general.geeks.misc;

/**
 * 
 * ou are given a map of a server center, represented as a m * n integer matrix grid, where 1 means that on that cell there is a server and 0 means that it is no server. Two servers are said to communicate if they are on the same row or on the same column.

Return the number of servers that communicate with any other server.


Input: grid = [[1,0],[0,1]]
Output: 0
Explanation: No servers can communicate with others.Input: grid = [[1,0],[1,1]]
Output: 3
Explanation: All three servers can communicate with at least one other server.


Input: grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
Output: 4
Explanation: The two servers in the first row can communicate with each other. The two servers in the third column can communicate with each other. The server at right bottom corner can't communicate with any other server.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m <= 250
1 <= n <= 250
grid[i][j] == 0 or 1
Accepted
 * 
 * @author skadavath
 *
 */
public class CountTheServersThatCommunicate {
	
	public static void main(String[] args) {
		
		int[][] grid = new int[][] {{1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}};
		
		System.out.println(new CountTheServersThatCommunicate().countServers(grid));
		
	}

	public int countServers(int[][] grid) {
		
		
		int[] rowCounts = new int[grid.length],colCounts = new int[grid[0].length];
		int servers = 0;
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(grid[i][j]==1) {
					rowCounts[i]++;
					colCounts[j]++;
					servers++;
				}
				
			}
		}
		
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(grid[i][j]==1 && rowCounts[i]==1 && colCounts[j]==1)
					servers--;
			}
		}
		return servers;
		

	}

}
