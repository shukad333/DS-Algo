package com.general.geeks.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.

The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.

Example:
Input: [[1,2], [3], [3], []] 
Output: [[0,1,3],[0,2,3]] 
Explanation: The graph looks like this:
0--->1
|    |
v    v
2--->3
There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
Note:

The number of nodes in the graph will be in the range [2, 15].
You can print different paths in any order, but you should keep the order of nodes inside one path.

 * @author skadavath
 *
 */
public class AllPathsFromSourceToGraph {
	
	public static void main(String[] args) {
		List<List<Integer>> resp = new AllPathsFromSourceToGraph().allPathsSourceTarget(new int[][] {{1,2},{3},{3},{}});
		System.out.println(resp);
	}

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		
		List<List<Integer>> resp = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		path.add(0);
		dfs(graph, resp, path, 0);
		return resp;

	}
	
	private void dfs(int[][] graph,List<List<Integer>> resp , List<Integer> path,int node) {
		
		
		if(node==graph.length-1) {
			resp.add(new ArrayList<>(path));
			return;
		}
		
		for(int i=0;i<graph[node].length;i++) {
			path.add(graph[node][i]);
			dfs(graph, resp, path, graph[node][i]);
			path.remove(path.size()-1);
		}
		
	}

}
