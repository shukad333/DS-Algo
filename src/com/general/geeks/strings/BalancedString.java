package com.general.geeks.strings;

/**
 * 
 * You are given a string containing only 4 kinds of characters 'Q', 'W', 'E' and 'R'.

A string is said to be balanced if each of its characters appears n/4 times where n is the length of the string.

Return the minimum length of the substring that can be replaced with any other string of the same length to make the original string s balanced.

Return 0 if the string is already balanced.

 

Example 1:

Input: s = "QWER"
Output: 0
Explanation: s is already balanced.
Example 2:

Input: s = "QQWE"
Output: 1
Explanation: We need to replace a 'Q' to 'R', so that "RQWE" (or "QRWE") is balanced.
Example 3:

Input: s = "QQQW"
Output: 2
Explanation: We can replace the first "QQ" to "ER". 
Example 4:

Input: s = "QQQQ"
Output: 3
Explanation: We can replace the last 3 'Q' to make s = "QWER".
 

Constraints:

1 <= s.length <= 10^5
s.length is a multiple of 4
s contains only 'Q', 'W', 'E' and 'R'.
Accepted
 * 
 * @author skadavath
 *
 */
public class BalancedString {
	
	public static void main(String[] args) {
		
		System.out.println(new BalancedString().balancedString("WWEQERQWQWWRWWERQWEQ"));
		
	}
	
	
	public int balancedString(String s) {
		
		int[] counts = new int[128];
		
		for(char c : s.toCharArray())
			counts[c]++;
		
		int j=0,n=s.length(),resp=n;
		for(int i=0;i<s.length();i++) {
			counts[s.charAt(i)]--;
			while(j<n && counts['Q']<=n/4 && counts['W']<=n/4 && counts['E']<=n/4 && counts['R']<=n/4) {
				resp = Math.min(resp, i-j+1);
				counts[s.charAt(j++)]++;
			}
			
		}
		
		return resp;
	}

}
