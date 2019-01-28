package com.general.geeks.array.dynamicprogramming;

/**
 * Given a value N, if we want to make change for N cents, and we have infinite
 * supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we
 * make the change? The order of coins doesn’t matter.
 * 
 * For example, for N = 4 and S = {1,2,3}, there are four solutions:
 * {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and S = {2,
 * 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5}
 * and {5,5}. So the output should be 5.
 * 
 * @author skadavath
 *
 */
public class CoinChangeGeeks {
	
	public static void main(String[] args) {
		
		System.out.println(new CoinChangeGeeks().countWays(new int[] {1,2,3},4));
		
	}
	
	private int countWays(int[] S,int finalVal) {
		
		int m = S.length;
		
		int[] dp = new int[finalVal+1];
		dp[0] = 1;
		
		for(int i=0;i<m;i++) {
			
			for(int j=S[i];j<=finalVal;j++) {
				
				dp[j] += dp[j-S[i]];
				
			}
			
		}
		
		return dp[finalVal];
	}

}
