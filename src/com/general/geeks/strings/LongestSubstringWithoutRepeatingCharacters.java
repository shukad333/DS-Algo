package com.general.geeks.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * Examples:
 * 
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * 
 * Given "bbbbb", the answer is "b", with the length of 1.
 * 
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the
 * answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 * 
 * @author skadavath
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
	
	public static void main(String[] args) {
		System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew"));
	}

	public int lengthOfLongestSubstring(String s) {
		
		int index = 0;
		int longest = 1;

		HashMap<Character, Integer> cache = new HashMap<>();
		for(int i=0;i<s.length();i++) {
			
			if(cache.containsKey(s.charAt(i))) {
				index = Math.max(index, cache.get(s.charAt(i))+1);
				
			}
			cache.put(s.charAt(i), i);
			longest = Math.max(longest, i-index+1);
			
		}
		return longest;

	}
}
