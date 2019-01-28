package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * Example:
 * 
 * Input: "aab" Output: [ ["aa","b"], ["a","a","b"] ]
 * 
 * @author skadavath
 *
 */
public class PallindromePartitioning {
	
	public static void main(String[] args) {
		System.out.println(new PallindromePartitioning().partition("aab"));
	}

	public List<List<String>> partition(String s) {
		
		List<List<String>> resp = new ArrayList<>();
		
		boolean[][] dp = new boolean[s.length()][s.length()];
		
		for(int i=0;i<s.length();i++) {
			for(int j=0;j<=i;j++) {
				if(s.charAt(i)==s.charAt(j) && (j+1>i-1 || dp[j+1][i-1])) {
					dp[j][i] = true;
				}
			}
		}
		
		dfs(resp, s, 0, dp, new ArrayList<>());
		return resp;

	}
	
	private void dfs(List<List<String>> resp , String s, int pos,boolean[][] dp,List<String> path) {
		
		if(s.length()==pos) {
			resp.add(new ArrayList<>(path));
			return;
		}
		
		for(int i=pos;i<s.length();i++) {
			if(dp[pos][i]) {
				path.add(s.substring(pos, i+1));
				dfs(resp, s, i+1, dp, path);
				path.remove(path.size()-1);
				
			}
		}
	}

}
