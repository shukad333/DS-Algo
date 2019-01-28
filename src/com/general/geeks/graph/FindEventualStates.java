package com.general.geeks.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * In a directed graph, we start at some node and every turn, walk along a
 * directed edge of the graph. If we reach a node that is terminal (that is, it
 * has no outgoing directed edges), we stop.
 * 
 * Now, say our starting node is eventually safe if and only if we must
 * eventually walk to a terminal node. More specifically, there exists a natural
 * number K so that for any choice of where to walk, we must have stopped at a
 * terminal node in less than K steps.
 * 
 * Which nodes are eventually safe? Return them as an array in sorted order.
 * 
 * The directed graph has N nodes with labels 0, 1, ..., N-1, where N is the
 * length of graph. The graph is given in the following form: graph[i] is a list
 * of labels j such that (i, j) is a directed edge of the graph.
 * 
 * Example: Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]] Output: [2,4,5,6]
 * Here is a diagram of the above graph.
 * 
 * 
 * @author skadavath
 *
 */
public class FindEventualStates {

	public List<Integer> eventualSafeNodes(int[][] graph) {
		
		/*
		 * Like the coloring problem 
		 * color - 0 - Not visited
		 * Color - 1 - Safe
		 * Color - 2 - Not safe
		 */
		
		int[] color = new int[graph.length];
		List<Integer> resp = new ArrayList<>();
		for(int i=0;i<graph.length;i++) {
			if(dfs(graph, color, i))
					resp.add(i);
		}
		
		return resp;

	}
	
	private boolean dfs(int[][] graph,int[] color , int i) {
		if(color[i]!=0)return color[i]==1;
		color[i] = 2;
		
		for(int j : graph[i]) {
			if(!dfs(graph, color, j)) return false;
		}
		color[i] = 1;
		
		return true;
	}

}
