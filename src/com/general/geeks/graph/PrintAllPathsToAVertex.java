package com.general.geeks.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Print all paths from vertex u to vertex d
 * 
 * @author skadavath
 *
 */
public class PrintAllPathsToAVertex {

	private int V;
	private ArrayList<Integer>[] adj;

	public PrintAllPathsToAVertex(int v) {
		this.V = v;
		adj = new ArrayList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new ArrayList();
		}
	}

	private void addEdge(int u, int w) {
		adj[u].add(w);
	}

	private void printAllPaths(int u, int d) {
		boolean[] visited = new boolean[this.V];
		ArrayList<Integer> list = new ArrayList();
		list.add(u);
		printAllPathsUtil(u, d, visited, list);
	}

	private void printAllPathsUtil(Integer u, Integer d, boolean[] visited, List<Integer> pathsList) {

		visited[u] = true;

		if (u.equals(d)) {
			//printList(pathsList);
			System.out.println(pathsList);
		}

		// Iterator<Integer> iterator = adj[u].iterator();
		// while (iterator.hasNext()) {
		for (Integer i : adj[u]) {

			if (!visited[i]) {
				pathsList.add(i);
				printAllPathsUtil(i, d, visited, pathsList);
				if(pathsList.contains(i))
				pathsList.remove(i);
			}
		}

		visited[u] = false;

	}

	private void printList(List<Integer> list) {
		for (Integer i : list) {
			System.out.print(i + " -> ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		PrintAllPathsToAVertex paths = new PrintAllPathsToAVertex(4);
		paths.addEdge(0, 1);
		paths.addEdge(0, 2);
		paths.addEdge(0, 3);
		paths.addEdge(2, 0);
		paths.addEdge(2, 1);
		paths.addEdge(1, 3);

		paths.printAllPaths(2, 3);
	}

}
