package com.general.geeks.array.dynamicprogramming;

/**
 * 
 * Given two strings s1, s2, find the lowest ASCII sum of deleted characters to make two strings equal.

Example 1:
Input: s1 = "sea", s2 = "eat"
Output: 231
Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
Deleting "t" from "eat" adds 116 to the sum.
At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.
Example 2:
Input: s1 = "delete", s2 = "leet"
Output: 403
Explanation: Deleting "dee" from "delete" to turn the string into "let",
adds 100[d]+101[e]+101[e] to the sum.  Deleting "e" from "leet" adds 101[e] to the sum.
At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.
Note:

0 < s1.length, s2.length <= 1000.
All elements of each string will have an ASCII value in [97, 122].
 * 
 * @author skadavath
 *
 */
public class MinimumASCIIDeleteSumForTwoStrings {
	
	public static void main(String[] args) {
		
		System.out.println(new MinimumASCIIDeleteSumForTwoStrings().minimumDeleteSum("delete", "leet"));
		
	}

	public int minimumDeleteSum(String s1, String s2) {
		
		int m = s1.length();
		int n = s2.length();
		int[][] dp = new int[m+1][n+1];
		
		
		/**
		 * dp[i][j] = a[i] == b[j] ? dp[i + 1][j + 1] : min(a[i] + dp[i + 1][j], //
		 * delete a[i] + minimumDeleteSum(a.substr(i+1), b.substr(j)) b[j] + dp[i][j +
		 * 1]) // delete b[j] + minimumDeleteSum(a.substr(i), b.substr(j+1))
		 */
		
		char[] a = s1.toCharArray(),b=s2.toCharArray();
		
		for(int i=m;i>=0;i--) {
			
			for(int j=n;j>=0;j--) {
				 if (i < m || j < n)
				dp[i][j] = i < m && j < n && a[i] == b[j] ? (dp[i + 1][j + 1])
						: Math.min((i < m ? a[i] + dp[i + 1][j] : Integer.MAX_VALUE), (j < n ? b[j] + dp[i][j + 1] : Integer.MAX_VALUE));

			}
			
		}
		
		return dp[0][0];

	}

}
