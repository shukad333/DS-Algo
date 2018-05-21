package com.general.geeks.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Given a string which consists of lowercase or uppercase letters, find the
 * length of the longest palindromes that can be built with those letters.
 * 
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * 
 * Note: Assume the length of given string will not exceed 1,010.
 * 
 * Example:
 * 
 * Input: "abccccdd"
 * 
 * Output: 7
 * 
 * Explanation: One longest palindrome that can be built is "dccaccd", whose
 * length is 7.
 * 
 * @author skadavath
 *
 */
public class LongestPallindrome {
	
	public static void main(String[] args) {
		System.out.println(new LongestPallindrome().longestPalindrome("bb"));
	}

	public int longestPalindrome(String s) {
		int count = 0;
		Set<Character> set = new HashSet();
		for(int i=0;i<s.length();i++) {
			if(set.contains(s.charAt(i))) {
				count++;
				set.remove(s.charAt(i));
			}
			else {
				set.add(s.charAt(i));
			}
		}
		
		if(!set.isEmpty())
		return count*2+1;
		
		return count*2;

	}

}
