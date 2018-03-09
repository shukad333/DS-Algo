package com.general.geeks.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class BFS {

	private int V;
	private LinkedList<Integer>[] adj;

	public BFS(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList();
		}

	}
	
	public void addEdge(int v , int w) {
		adj[v].add(w);
	}
	
	public void printBFS(int v) {
		boolean[] visited = new boolean[V];
		visited[v] = true;
		
		LinkedList<Integer> queue = new LinkedList();
		queue.add(v);
		while(!queue.isEmpty()) {
			v = queue.poll();
			System.out.println(v+" ");
			Iterator<Integer> iter = adj[v].listIterator();
			while(iter.hasNext()) {
				int n = iter.next();
				if(!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		BFS bfs = new BFS(40);
		bfs.addEdge(1, 10);
		bfs.addEdge(1, 20);
		bfs.addEdge(10, 30);
		bfs.addEdge(10,1);
		
		bfs.printBFS(1);
	}

}
