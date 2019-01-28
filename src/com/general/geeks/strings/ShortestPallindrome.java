package com.general.geeks.strings;

/**
 * 
 * Given a string s, you are allowed to convert it to a palindrome by adding
 * characters in front of it. Find and return the shortest palindrome you can
 * find by performing this transformation.
 * 
 * Example 1:
 * 
 * Input: "aacecaaa" Output: "aaacecaaa" Example 2:
 * 
 * Input: "abcd" Output: "dcbabcd"
 * 
 * @author skadavath
 *
 */
public class ShortestPallindrome {
	
	public static void main(String[] args) {
		
		System.out.println(new ShortestPallindrome().shortestPalindrome("shuh"));
		
	}

	public String shortestPalindrome(String s) {
		
		int j=0;
		for(int i=s.length()-1;i>=0;i--) {
			if(s.charAt(i)==s.charAt(j))j++;
		}
		if(j==s.length())
			return s;
		
		String suffix = s.substring(j);
		return new StringBuilder(suffix).reverse() + shortestPalindrome(s.substring(0,j)) + suffix;

	}

}
