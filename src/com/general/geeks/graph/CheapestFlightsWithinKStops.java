package com.general.geeks.graph;

import java.util.Arrays;

/**
 * 
 * 
 * 
 * @author skadavath
 *
 */
public class CheapestFlightsWithinKStops {
	
	public static void main(String[] args) {
		
		int[][] flights = new int[][] {{0,1,100},{1,2,100},{0,2,500}};
		System.out.println(new CheapestFlightsWithinKStops().findCheapestPrice(3, flights, 0,2,1));
		
	}

	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

		int INF = 0x3F3F3F3F;
	
		int[] cost = new int[n];
		Arrays.fill(cost, INF);
		cost[src] = 0;
		int ans = cost[dst];
		for (int i = K; i >= 0; i--) {
			int[] cur = new int[n];
			Arrays.fill(cur, INF);
			for (int[] flight : flights) {
				cur[flight[1]] = Math.min(cur[flight[1]], cost[flight[0]] + flight[2]);
			}
			cost = cur;
			ans = Math.min(ans, cost[dst]);
		}
		return ans == INF ? -1 : ans;
	}

}
