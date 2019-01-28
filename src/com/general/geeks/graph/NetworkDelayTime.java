package com.general.geeks.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 
 * There are N network nodes, labelled 1 to N.
 * 
 * Given times, a list of travel times as directed edges times[i] = (u, v, w),
 * where u is the source node, v is the target node, and w is the time it takes
 * for a signal to travel from source to target.
 * 
 * Now, we send a signal from a certain node K. How long will it take for all
 * nodes to receive the signal? If it is impossible, return -1.
 * 
 * Note: N will be in the range [1, 100]. K will be in the range [1, N]. The
 * length of times will be in the range [1, 6000]. All edges times[i] = (u, v,
 * w) will have 1 <= u, v <= N and 1 <= w <= 100. Seen this question in a real
 * interview before?
 * 
 * 
 * @author skadavath
 *
 */
public class NetworkDelayTime {

	public int networkDelayTime(int[][] times, int N, int K) {

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0])); // {distance, node}
		Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
		for (int[] time : times) {
			map.putIfAbsent(time[0], new HashMap<>());
			map.get(time[0]).put(time[1], time[2]);
		}
		int[] dis = new int[N + 1]; // record the minimal distance of each node to K
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[K] = 0;
		boolean[] visited = new boolean[N + 1];
		pq.offer(new int[] { 0, K });
		int res = 0;
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int curNode = cur[1];
			if (visited[curNode])
				continue;
			visited[curNode] = true;
			int curDis = cur[0];
			res = curDis;
			N--;
			if (!map.containsKey(curNode))
				continue;
			for (int next : map.get(curNode).keySet()) {
				if (!visited[next] && curDis + map.get(curNode).get(next) < dis[next]) {
					dis[next] = curDis + map.get(curNode).get(next);
					pq.offer(new int[] { dis[next], next });
				}
			}
		}
		return N == 0 ? res : -1;

	}

}
