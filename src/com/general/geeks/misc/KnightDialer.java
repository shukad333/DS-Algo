package com.general.geeks.misc;

/**
 * 
 * This time, we place our chess knight on any numbered key of a phone pad (indicated above), and the knight makes N-1 hops.  Each hop must be from one key to another numbered key.

Each time it lands on a key (including the initial placement of the knight), it presses the number of that key, pressing N digits total.

How many distinct numbers can you dial in this manner?

Since the answer may be large, output the answer modulo 10^9 + 7.

 

Example 1:

Input: 1
Output: 10
Example 2:

Input: 2
Output: 20
Example 3:

Input: 3
Output: 46
 * 
 * @author skadavath
 *
 */
public class KnightDialer {
	
	public static void main(String[] args) {
		
		System.out.println(new KnightDialer().knightDialer(3));
		
	}

	public static final int MOD = 1000000007;
	public int knightDialer(int N) {
		
		int[][] neighbours = new int[][]{{4,6},{6,8},{7,9},{4,8},{3,9,0},{},{1,7,0},{2,6},{1,3},{2,4}};
		Integer[][] cache = new Integer[N+1][10];
		int count=0;
		for(int i=0;i<10;i++) {
			count+=helper(N-1, cache, neighbours, i);
		}
		return count;

	}
	
	private int helper(int N , Integer[][] cache,int[][] neighbours,int curr) {
		
		if(N==0)
			return 1;
		if(null!=cache[N][curr]) {
			return cache[N][curr];
		}
		
		int count=0;
		for(int neightbour : neighbours[curr]) {
			count+=helper(N-1, cache, neighbours, neightbour)%MOD;
		}
		cache[N][curr] = count;
		return count;
	}

}
