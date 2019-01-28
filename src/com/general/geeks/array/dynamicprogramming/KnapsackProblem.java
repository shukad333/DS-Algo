package com.general.geeks.array.dynamicprogramming;

/**
 * 
 * Given weights and values of n items, put these items in a knapsack of
 * capacity W to get the maximum total value in the knapsack. In other words,
 * given two integer arrays val[0..n-1] and wt[0..n-1] which represent values
 * and weights associated with n items respectively. Also given an integer W
 * which represents knapsack capacity, find out the maximum value subset of
 * val[] such that sum of the weights of this subset is smaller than or equal to
 * W. You cannot break an item, either pick the complete item, or don’t pick it
 * (0-1 property).
 * 
 * @author skadavath
 *
 */
public class KnapsackProblem {

	public static void main(String[] args) {
		
		System.out.println(new KnapsackProblem().knapsack(new int[] {10,20,30}, new int[] {60,100,120}, 50));

	}

	private int knapsack(int[] weights, int[] profit, int W) {

		int[][] dp = new int[weights.length + 1][W+1];

		for (int i = 0; i <= weights.length; i++) {
			for (int w = 0; w <= W; w++) {
				
				if(i==0 || w==0)
					dp[i][w] = 0;
				
				else if(weights[i-1]<=w) {
					dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-weights[i-1]]+profit[i-1]);
				}
				else
					dp[i][w] = dp[i-1][w];

			}
		}
		return dp[weights.length][W];

	}

}
