package com.general.geeks.array.dynamicprogramming;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

Example 1:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Example 2:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false

 * @author skadavath
 *
 */
public class InterleavingString {
	
	public static void main(String[] args) {
		
		System.out.println(new InterleavingString().isInterleave("aabcc", "dbbca", "aadbbcqbcac"));
	}

	public boolean isInterleave(String s1, String s2, String s3) {
		
		
		int x = s1.length();
		int y = s2.length();
		
		if(x+y!=s3.length())
			return false;
		
		boolean[][] dp = new boolean[x+1][y+1];
		
		
		for(int i=0;i<=x;i++) {
			for(int j=0;j<=y;j++) {
				if(i==0 && j==0)
					dp[i][j] = true;
				else {
					dp[i][j] = (i>0 && dp[i-1][j] && s1.charAt(i-1)==s3.charAt(i+j-1)) || (j>0 && dp[i][j-1] && s2.charAt(j-1)==s3.charAt(i+j-1));
				}
			}
		}
		
		return dp[x][y];

	}

}
