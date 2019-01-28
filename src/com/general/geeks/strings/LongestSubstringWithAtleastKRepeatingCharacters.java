package com.general.geeks.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Find the length of the longest substring T of a given string (consists of
 * lowercase letters only) such that every character in T appears no less than k
 * times.
 * 
 * Example 1:
 * 
 * Input: s = "aaabb", k = 3
 * 
 * Output: 3
 * 
 * The longest substring is "aaa", as 'a' is repeated 3 times. Example 2:
 * 
 * Input: s = "ababbc", k = 2
 * 
 * Output: 5
 * 
 * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is
 * repeated 3 times.
 * 
 * 
 * @author skadavath
 *
 */
public class LongestSubstringWithAtleastKRepeatingCharacters {
	
	public static void main(String[] args) {
		
		System.out.println(new LongestSubstringWithAtleastKRepeatingCharacters().longestSubstring("aaabbcccdddd", 3));
		
	}

	public int longestSubstring(String s, int k) {
		
		int[] chars = new int[26];
		int resp = 0;
		for(char c : s.toCharArray())
			chars[c-'a']++;
		
		List<Integer> splits = new ArrayList<>();
		
		//when less then k , we split and add to list
		for(int i=0;i<s.length();i++) {
			if(chars[s.charAt(i)-'a']<k)splits.add(i);
		}
		
		if(splits.size()==0)
			return s.length();
		splits.add(0, -1);
		splits.add(s.length());
		for(int i=1;i<splits.size();i++) {
			
			int sIndex = splits.get(i-1)+1;
			int nextIndex = splits.get(i);
			String subStr = s.substring(sIndex, nextIndex);
			int len = longestSubstring(subStr, k);
			resp = Math.max(resp, len);
			
		}
		
		return resp;
		
		

	}

}
