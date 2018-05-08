package com.general.geeks.graph;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Count all paths to a vertex
 * 
 * @author skadavath
 *
 */
public class CountPathsToAVertex {

	private int V;
	private ArrayList<Integer>[] adj;

	public CountPathsToAVertex(int v) {

		V = v;
		adj = new ArrayList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new ArrayList();
		}

	}

	public void addEdge(int u, int v) {
		adj[u].add(v);
	}

	public int countPaths(int u, int d) {
		boolean[] visited = new boolean[V];
		return countPathsUtil(u, d, visited, 0);
	}

	/**
	 * Counts total paths from u to d
	 * 
	 * @param u
	 * @param d
	 * @param visited
	 * @param pathsCount
	 * @return
	 */
	public int countPathsUtil(int u, int d, boolean[] visited, int pathsCount) {

		visited[u] = true;

		if (u == d) {
			pathsCount++;
		} else {
			Iterator<Integer> iterator = adj[u].iterator();
			while (iterator.hasNext()) {
				int n = iterator.next();
				if (!visited[n]) {
					pathsCount = countPathsUtil(n, d, visited, pathsCount);
				}
			}
		}

		visited[u] = false;
		return pathsCount;

	}

	public static void main(String[] args) {

		CountPathsToAVertex paths = new CountPathsToAVertex(5);
		paths.addEdge(1, 2);
		paths.addEdge(2, 4);
		paths.addEdge(2, 3);
		paths.addEdge(3, 4);
		paths.addEdge(1, 4);

		System.out.println(paths.countPaths(1, 4));
	}

}
