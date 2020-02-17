package com.general.geeks.strings;

import java.util.HashMap;

/**
 * Given a string which contains only lowercase letters, remove duplicate
 * letters so that every letter appear once and only once. You must make sure
 * your result is the smallest in lexicographical order among all possible
 * results.
 * 
 * Example 1:
 * 
 * Input: "bcabc" Output: "abc" Example 2:
 * 
 * Input: "cbacdcbc" Output: "acdb"
 * 
 * @author skadavath
 *
 */
public class RemovingDuplicateLetters {
	
	public static void main(String[] args) {
		System.out.println(new RemovingDuplicateLetters().removeDuplicateLettersGreedy("cbacdcbc"));
	}
	
	public String removeDuplicateLettersGreedy(String s) {
		
		int pos = 0;
		
		int[] chars = new int[26];
		for(int i=0;i<s.length();i++)
			chars[s.charAt(i)-'a']++;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)<s.charAt(pos))
				pos=i;
			if(--chars[s.charAt(i)-'a']==0)
				break;
		}
		
		return s.length()==0?"":s.charAt(pos)+removeDuplicateLettersGreedy(s.substring(pos+1).replaceAll(""+s.charAt(pos), ""));
		
		
	}

	public String removeDuplicateLetters(String s) {
		
		HashMap<Character, Integer> map = new HashMap<>();
		//get the last index of all chars
		for(int i=0;i<s.length();i++)
			map.put(s.charAt(i), i);
		
		
		int start = 0,end=getMinFromMap(map);
		char[] result = new char[map.size()];
		for(int i=start;i<=result.length;i++) {
			
			char min = 'z'+1;
			
			for(int j=start;j<=end;j++) {
				
				if(map.containsKey(s.charAt(j)) && s.charAt(j)<min) {
					min = s.charAt(j);
					start = j+1;
				}
				
			}
			
			result[i] = min;
			
			if(i==result.length-1)break;
			map.remove(result[i]);
			if(s.charAt(end)==min)
				end = getMinFromMap(map);
			
			
		}
		return new String(result);
	}
	
	private int getMinFromMap(HashMap<Character, Integer> map) {
		
		int min = Integer.MAX_VALUE;
		for(int i : map.values()) {
			min = Math.min(i, min);
		}
		return min;
		
	}

}
