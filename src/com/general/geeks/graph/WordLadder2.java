package com.general.geeks.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return an empty list if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: []

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 * 
 * @author skadavath
 *
 */
public class WordLadder2 {
	
	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("Shu");
		//System.out.println("domain="+StringUtils.);
		System.out.println(new WordLadder2().findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
		
		
		
	}
	
	public List<List<String>> findLadders(String start, String end, List<String> wordList) {
		
		List<List<String>> resp = new ArrayList<>();
		Map<String, Integer> distance = new HashMap<>();
		Map<String,List<String>> nodeNeighborMap = new HashMap<>();
		//first do a BFS to get the neighbours and their distance from the start
		
		Set<String> dict = new HashSet<>(wordList);
		dict.add(start);
		
		bfs(start, end, dict, distance, nodeNeighborMap);
		
		dfs(start, end, distance, nodeNeighborMap, resp, new ArrayList<>());
		
		return resp;
		
	}
	
	private void dfs(String start,String end, Map<String, Integer> distance,Map<String,List<String>> nodeNeighbors,List<List<String>> resp,List<String> currSolution) {
		
		currSolution.add(start);
		
		if(start.equals(end)) {
			resp.add(new ArrayList<>(currSolution));
		}
		else {
		for(String node : nodeNeighbors.get(start)) {
			if(distance.get(node) == distance.get(start)+1) {
				dfs(node, end, distance, nodeNeighbors, resp, currSolution);
			}
		}
		}
		
		currSolution.remove(currSolution.size()-1);
		
	}
	
	private void bfs(String start,String end,Set<String> dict , Map<String, Integer> distance,Map<String,List<String>> nodeNeighbors) {
		
		for(String s : dict) {
			nodeNeighbors.put(s, new ArrayList<>());
		}
		distance.put(start, 0);
		Queue<String> queue = new LinkedList<>();
		queue.offer(start);
		boolean found = false;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i=0;i<size;i++) {
				String currNode = queue.poll();
				List<String> neighbors = getNeighboursForANode(currNode, dict);
				int currDist = distance.get(currNode);
				for(String neighborNode : neighbors) {
					
					nodeNeighbors.get(currNode).add(neighborNode);
					
					if(!distance.containsKey(neighborNode)) {
					distance.put(neighborNode, currDist+1);
					
					if(end.equals(neighborNode)) {
						found = true;
					}
					else
					queue.add(neighborNode);
					
					}
				}
			}
			
			if(found)
				break;
		}
		
	}
	
	private List<String> getNeighboursForANode(String node , Set<String> dict) {
		
		List<String> resp = new ArrayList<>();
		char[] chars = node.toCharArray();
		for(char ch='a';ch<='z';ch++) {
			
			for(int i=0;i<node.length();i++) {
				
				if(ch==chars[i])
					continue;
				
				char old = chars[i];
				chars[i] = ch;
				
				if(dict.contains(String.valueOf(chars)))
					resp.add(String.valueOf(chars));
				
				chars[i] = old;
				
			}
		}
		return resp;
	}
	
}
