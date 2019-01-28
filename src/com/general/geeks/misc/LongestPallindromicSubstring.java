package com.general.geeks.misc;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume
 * that the maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * Input: "babad" Output: "bab" Note: "aba" is also a valid answer. Example 2:
 * 
 * Input: "cbbd" Output: "bb"
 * 
 * @author skadavath
 *
 */
public class LongestPallindromicSubstring {
	
	public static void main(String[] args) {
		
		System.out.println(new LongestPallindromicSubstring().longestPalindrome("cbbd"));
	}

	public String longestPalindrome(String s) {
		
		if(s.length()<2) {
			return s;
		}
		int[] res = new int[2];
		
		for(int i=0;i<s.length();i++) {
			extend(s, i, i, res);
			extend(s, i, i+1, res);
		}
		
		return s.substring(res[1], res[1]+res[0]);
	}
	
	private void extend(String s , int start,int end,int[] result) {
		
		while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)) {
			start--;
			end++;
		}
		if(result[0]< (end - start - 1)) {
			result[0] = end - start - 1;
			result[1] = start+1;
		}
		
	}

}
