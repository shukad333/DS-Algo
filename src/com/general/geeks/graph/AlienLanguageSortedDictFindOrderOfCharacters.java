package com.general.geeks.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * Given a sorted dictionary (array of words) of an alien language, find order
 * of characters in the language. Examples:
 * 
 * Input: words[] = {"baa", "abcd", "abca", "cab", "cad"} Output: Order of
 * characters is 'b', 'd', 'a', 'c' Note that words are sorted and in the given
 * language "baa" comes before "abcd", therefore 'b' is before 'a' in output.
 * Similarly we can find other orders.
 * 
 * Input: words[] = {"caa", "aaa", "aab"} Output: Order of characters is 'c',
 * 'a', 'b'
 * 
 * 
 * @author skadavath
 *
 */
public class AlienLanguageSortedDictFindOrderOfCharacters {
	
	public static void main(String[] args) {
		
		
		AlienLanguageSortedDictFindOrderOfCharacters alien = new AlienLanguageSortedDictFindOrderOfCharacters();
		alien.printOrderOfAlien(new String[] {"baa", "abcd", "abca", "cab", "cad"}, 4);
	}
	
	public void printOrderOfAlien(String[] words,int noOfChars) {
		
		TopologicalSortGraph graph = new TopologicalSortGraph(noOfChars);
		
		for(int i=0;i<words.length-1;i++) {
			
			String word1 = words[i];
			String word2 = words[i+1];
			
			for(int j=0;j<Math.min(word1.length(), word2.length());j++) {
				
				if(word1.charAt(j)!=word2.charAt(j)) {
					
					//a mismatch is found , add to the graoh edge
					
					graph.addEdge(word1.charAt(j)-'a', word2.charAt(j)-'a');
					break;
					
				}
				
			}
			
		}
		
		graph.topo();
		
	}

//	public static void main(String[] args) {
//
//		TopologicalSortGraph g = new TopologicalSortGraph(6);
//
//		g.addEdge(5, 2);
//		g.addEdge(5, 0);
//		g.addEdge(4, 0);
//		g.addEdge(4, 1);
//		g.addEdge(2, 3);
//		g.addEdge(3, 1);
//
//		System.out.println("Following is a Topological " + "sort of the given graph");
//		g.topo();
//
//	}

}

class TopologicalSortGraph {

	List<Integer> adjacencyMatrix[];
	private int V;

	public TopologicalSortGraph(int v) {
		
		adjacencyMatrix = new LinkedList[v];
		
		for(int i=0;i<v;i++)
		adjacencyMatrix[i] = new LinkedList<>();
		
		V = v;

	}

	public void addEdge(int u, int v) {

		adjacencyMatrix[u].add(v);

	}

	public void topoUtil(boolean[] visited, Stack<Integer> stack, int i) {

		if (visited[i])
			return;

		visited[i] = true;

		List<Integer> adj = adjacencyMatrix[i];
		if (adj != null) {
			for (Integer j : adj) {
				topoUtil(visited, stack, j);
			}
		}

		stack.add(i);

	}

	public void topo() {

		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[V];

		for (int i = 0; i < V; i++) {
			topoUtil(visited, stack, i);
		}

		while (!stack.isEmpty()) {
			System.out.print((char)('a'+stack.pop()) + " ");
		}
	}

}
