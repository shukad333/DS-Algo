package com.general.geeks.array.dynamicprogramming;

/**
 * You are given coins of different denominations and a total amount of money
 * amount. Write a function to compute the fewest number of coins that you need
 * to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 * 
 * Example 1:
 * 
 * Input: coins = [1, 2, 5], amount = 11 Output: 3 Explanation: 11 = 5 + 5 + 1
 * Example 2:
 * 
 * Input: coins = [2], amount = 3 Output: -1 Note: You may assume that you have
 * an infinite number of each kind of coin.
 * 
 * 
 * @author skadavath
 *
 */
public class CoinsChange {
	
	public static void main(String[] args) {
		
		System.out.println(new CoinsChange().coinChange(new int[] {1,2,4,6}, 31));
		
	}

	public int coinChange(int[] coins, int amount) {
		
		int m = coins.length;
		int[] dp = new int[amount+1];
		
		dp[0] = 0;
		
		for(int i=1;i<dp.length;i++)
			dp[i] = Integer.MAX_VALUE;
		
		for(int i=1;i<=amount;i++) {
			
			for(int j=0;j<coins.length;j++) {
				
				if(coins[j]<=i) {
					
					dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
				}
				
			}
			
		}
		
		return dp[amount]>amount?-1:dp[amount];

	}

}
