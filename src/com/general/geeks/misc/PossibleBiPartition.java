package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Given a set of N people (numbered 1, 2, ..., N), we would like to split
 * everyone into two groups of any size.
 * 
 * Each person may dislike some other people, and they should not go into the
 * same group.
 * 
 * Formally, if dislikes[i] = [a, b], it means it is not allowed to put the
 * people numbered a and b into the same group.
 * 
 * Return true if and only if it is possible to split everyone into two groups
 * in this way.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: N = 4, dislikes = [[1,2],[1,3],[2,4]] Output: true Explanation: group1
 * [1,4], group2 [2,3] Example 2:
 * 
 * Input: N = 3, dislikes = [[1,2],[1,3],[2,3]] Output: false Example 3:
 * 
 * Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]] Output: false
 * 
 * 
 * Note:
 * 
 * 1 <= N <= 2000 0 <= dislikes.length <= 10000 1 <= dislikes[i][j] <= N
 * dislikes[i][0] < dislikes[i][1] There does not exist i != j for which
 * dislikes[i] == dislikes[j].
 * 
 * @author skadavath
 *
 */
public class PossibleBiPartition {
	
	public static void main(String[] args) {
		System.out.println(new PossibleBiPartition().possibleBipartition(4, new int[][] {{1,2},{1,3},{4,2}}));
	}

	public boolean possibleBipartition(int N, int[][] dislikes) {

		// groups - 1,2 or 0(no group)
		int[] groups = new int[N + 1];
		List<List<Integer>> graph = new ArrayList<>(N+1);
		for (int i = 0; i <= N; i++)
			graph.add(new ArrayList<>());

		for (int[] d : dislikes) {
			graph.get(d[0]).add(d[1]);
			graph.get(d[1]).add(d[0]);
		}

		for (int i = 1; i <= N; i++) {
			if (groups[i] == 0) {
				groups[i] = 1;
				Queue<Integer> queue = new LinkedList<>();
				queue.add(i);
				while (!queue.isEmpty()) {
					
					int curr = queue.poll();
					for(int g : graph.get(curr)) {
						if(groups[g]==0) {
							groups[g] = groups[curr]==1?2:1;
							queue.add(g);
						}
						else {
							if(groups[g]==groups[curr])
								return false;
						}
					}

				}
			}
		}
		return true;

	}
}