package com.general.geeks.misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * You have N gardens, labelled 1 to N.  In each garden, you want to plant one of 4 types of flowers.

paths[i] = [x, y] describes the existence of a bidirectional path from garden x to garden y.

Also, there is no garden that has more than 3 paths coming into or leaving it.

Your task is to choose a flower type for each garden such that, for any two gardens connected by a path, they have different types of flowers.

Return any such a choice as an array answer, where answer[i] is the type of flower planted in the (i+1)-th garden.  The flower types are denoted 1, 2, 3, or 4.  It is guaranteed an answer exists.

 

Example 1:

Input: N = 3, paths = [[1,2],[2,3],[3,1]]
Output: [1,2,3]
Example 2:

Input: N = 4, paths = [[1,2],[3,4]]
Output: [1,2,1,2]
Example 3:

Input: N = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
Output: [1,2,3,4]
 * 
 * @author skadavath
 *
 */
public class FlowerPaintingWithNoAdjacent {
	
	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(new FlowerPaintingWithNoAdjacent().gardenNoAdj(4, new int[][] {{1,2},{2,3},{3,4},{4,1},{1,3},{2,4}})));
		
	}

	public int[] gardenNoAdj(int N, int[][] paths) {
		
		Map<Integer, Set<Integer>> map = new HashMap<>();
		
		for(int i=0;i<N;i++) 
			map.put(i, new HashSet<>());
		
		for(int[] path : paths) {
			map.get(path[0]-1).add(path[1]-1);
			map.get(path[1]-1).add(path[0]-1);
		}
		
		int[] resp = new int[N];
		
		for(int i=0;i<N;i++) {
			int[] colors = new int[5];
			for(int j : map.get(i)) {
				colors[resp[j]] = 1;
			}
			
			for(int c=4;c>0;c--) {
				if(colors[c]==0)
					resp[i] = c;
			}
			
		}
		
		return resp;

	}

}
