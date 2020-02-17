package com.general.geeks.graph;

/**
 * 
 * There are n computers numbered from 0 to n-1 connected by ethernet cables
 * connections forming a network where connections[i] = [a, b] represents a
 * connection between computers a and b. Any computer can reach any other
 * computer directly or indirectly through the network.
 * 
 * Given an initial computer network connections. You can extract certain cables
 * between two directly connected computers, and place them between any pair of
 * disconnected computers to make them directly connected. Return the minimum
 * number of times you need to do this in order to make all the computers
 * connected. If it's not possible, return -1.
 * 
 * Input: n = 4, connections = [[0,1],[0,2],[1,2]]
Output: 1
Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.


Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
Output: 2
Example 3:

Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
Output: -1
Explanation: There are not enough cables.
Example 4:

Input: n = 5, connections = [[0,1],[0,2],[3,4],[2,3]]
Output: 0
 * 
 * @author skadavath
 *
 */
public class NumberOfOperationsToMakeNetworkConnected {

	public int makeConnected(int n, int[][] connections) {

		int[] parent = new int[n];
		for (int i = 0; i < n; i++)
			parent[i] = i;

		int m = connections.length;
		int components = 0, extraEdges = 0;
		for (int i = 0; i < m; i++) {
			int p1 = find(parent, connections[i][0]);
			int p2 = find(parent, connections[i][1]);
			if (p1 == p2)
				extraEdges++;
			else
				parent[p1] = p2;
		}

		for (int i = 0; i < n; i++) {
			if (parent[i] == i)
				components++;

		}

		return extraEdges >= components - 1 ? components - 1 : -1;

	}

	private int find(int[] arr, int p) {
		if (arr[p] == p)
			return p;
		return arr[p] = find(arr, arr[p]);
	}

}
