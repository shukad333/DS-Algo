package com.general.geeks.array.dynamicprogramming;

import java.util.Arrays;

/**
 * 
 * In the computer world, use restricted resource you have to generate maximum
 * benefit is what we always want to pursue.
 * 
 * For now, suppose you are a dominator of m 0s and n 1s respectively. On the
 * other hand, there is an array with strings consisting of only 0s and 1s.
 * 
 * Now your task is to find the maximum number of strings that you can form with
 * given m 0s and n 1s. Each 0 and 1 can be used at most once.
 * 
 * Note: The given numbers of 0s and 1s will both not exceed 100 The size of
 * given string array won't exceed 600. Example 1: Input: Array = {"10", "0001",
 * "111001", "1", "0"}, m = 5, n = 3 Output: 4
 * 
 * Explanation: This are totally 4 strings can be formed by the using of 5 0s
 * and 3 1s, which are “10,”0001”,”1”,”0” Example 2: Input: Array = {"10", "0",
 * "1"}, m = 1, n = 1 Output: 2
 * 
 * Explanation: You could form "10", but then you'd have nothing left. Better
 * form "0" and "1".
 * 
 * @author skadavath
 *
 */
public class OnesAndZeros {

	public static void main(String[] args) {

		System.out.println(new OnesAndZeros().findMaxForm(new String[] { "10","0001","111001","1","0" }, 5, 3));

	}

	public int findMaxForm(String[] strs, int m, int n) {

		int[][][] dp = new int[strs.length + 1][m + 1][n + 1];

		for (int i = 1; i <= strs.length; i++) {
			String curr = strs[i - 1];
			int[] resp = getOnesAndZeros(curr);

			for (int j = 0; j <= m; j++) {
				for (int k = 0; k <= n; k++) {

					if (i == 0)
						continue;
					// normal 0-1 knapsack
					else if (j >= resp[0] && k >= resp[1]) {

						dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - resp[0]][k-resp[1]] + 1);

					}
					// else retain previous
					else {
						dp[i][j][k] = dp[i - 1][j][k];
					}
				}
			}
		}

		return dp[strs.length][m][n];

	}

	private int[] getOnesAndZeros(String str) {

		int[] resp = new int[2];
		Arrays.fill(resp, 0);
		for (char c : str.toCharArray()) {
			if (c == '0')
				resp[0]++;
			else
				resp[1]++;
		}

		return resp;

	}

}
