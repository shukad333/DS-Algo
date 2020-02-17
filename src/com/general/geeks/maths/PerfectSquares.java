package com.general.geeks.maths;

/**
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * Example 1:
 * 
 * Input: n = 12 Output: 3 Explanation: 12 = 4 + 4 + 4. Example 2:
 * 
 * Input: n = 13 Output: 2 Explanation: 13 = 4 + 9.
 * 
 * @author skadavath
 *
 */
public class PerfectSquares {

	public static void main(String[] args) {
		
		System.out.println(new PerfectSquares().numSquares(4));
	}

	public int numSquares(int n) {

		int[] dp = new int[n + 1];
		if(n<4)
			return n;
		dp[0] = 0; // 0
		dp[1] = 1; // 1*1
		dp[2] = 2; // 1*1 + 1*1
		dp[3] = 3; // 1*1 + 1*1 + 1*1

		for (int i = 4; i <= n; i++) {
			dp[i] = i; // max is 1*1 + 1*1 + .....
			for (int x = 1; x <= i; x++) {

				int temp = x * x;
				if (temp > i)
					break;
				else
				dp[i] = Math.min(dp[i], 1 + dp[i - temp]);
			}

		}
		return dp[n];

	}

}
