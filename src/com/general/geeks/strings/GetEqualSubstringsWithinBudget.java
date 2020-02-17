package com.general.geeks.strings;

/**
 * 
 * You are given two strings s and t of the same length. You want to change s to t. Changing the i-th character of s to i-th character of t costs |s[i] - t[i]| that is, the absolute difference between the ASCII values of the characters.

You are also given an integer maxCost.

Return the maximum length of a substring of s that can be changed to be the same as the corresponding substring of twith a cost less than or equal to maxCost.

If there is no substring from s that can be changed to its corresponding substring from t, return 0.

 

Example 1:

Input: s = "abcd", t = "bcdf", maxCost = 3
Output: 3
Explanation: "abc" of s can change to "bcd". That costs 3, so the maximum length is 3.
Example 2:

Input: s = "abcd", t = "cdef", maxCost = 3
Output: 1
Explanation: Each character in s costs 2 to change to charactor in t, so the maximum length is 1.
Example 3:

Input: s = "abcd", t = "acde", maxCost = 0
Output: 1
Explanation: You can't make any change, so the maximum length is 1.
 

Constraints:

1 <= s.length, t.length <= 10^5
0 <= maxCost <= 10^6
s and t only contain lower case English letters.
 * 
 * @author skadavath
 *
 */
public class GetEqualSubstringsWithinBudget {
	
	public static void main(String[] args) {
		
		System.out.println(new GetEqualSubstringsWithinBudget().equalSubstring("abcdklmno","bcdfklmno",3));
		
	}

	public int equalSubstring(String s, String t, int maxCost) {
		
		int n = s.length(),i=0,j=0;
		for(j=0;j<s.length();j++) {
			
			maxCost -= Math.abs(s.charAt(j)-t.charAt(j));
			if(maxCost<0) {
				maxCost += Math.abs(s.charAt(i)-t.charAt(i++));
			}
		}
		return j-i;

	}

}
