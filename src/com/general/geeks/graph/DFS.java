package com.general.geeks.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DFS {

	private int V;
	private ArrayList<Integer> adj[];

	public DFS(int v) {
		V = v;
		adj = new ArrayList[v];
		for (int i = 0; i < v; ++i) {
			adj[i] = new ArrayList();
		}
	}

	public void addEdge(int u, int w) {
		adj[u].add(w);
	}

	public void DFS(boolean[] visited, int s) {

		visited[s] = true;
		System.out.println(s);
		Iterator<Integer> it = adj[s].listIterator();
		while (it.hasNext()) {
			int temp = it.next();
			if (!visited[temp]) {
				// visited[temp] = true;
				DFS(visited, temp);
			}
		}

	}

	public void DFS(int s) {
		boolean[] visited = new boolean[V];
		DFS(visited, s);
	}

	public static void main(String[] args) {

		DFS g = new DFS(15);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		g.addEdge(1, 10);
		g.DFS(2);
	}

}
