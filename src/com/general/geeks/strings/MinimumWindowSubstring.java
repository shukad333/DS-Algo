package com.general.geeks.strings;

/**
 * 
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * Example:
 * 
 * Input: S = "ADOBECODEBANC", T = "ABC" Output: "BANC" Note:
 * 
 * If there is no such window in S that covers all characters in T, return the
 * empty string "". If there is such window, you are guaranteed that there will
 * always be only one unique minimum window in S.
 * 
 * @author skadavath
 *
 */
public class MinimumWindowSubstring {
	
	public static void main(String[] args) {
		
		System.out.println(new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC"));
	}

	public String minWindow(String s, String t) {
		
		if(null==s || null == t) {
			return "";
		}
		
		if(s.length()<t.length()) {
			return "";
		}
		int[] sChar = new int[256];
		int[] tChar = new int[256];
		
		for(int i=0;i<t.length();i++) {
			tChar[t.charAt(i)]++;
		}
		
		
		int startIndex = -1,count=0,start = 0,minLen = Integer.MAX_VALUE;
		
		for(int j=0;j<s.length();j++) {
			
			sChar[s.charAt(j)]++;
			
			//if found the character in t and s, increment the count
			if(sChar[s.charAt(j)] <= tChar[s.charAt(j)] && tChar[s.charAt(j)]!=0) {
				
				count++;
			}
			
			//if we have found all the characters ,
			//start removing the unwanted characters from it .
			if(count==t.length()) {
				
				while(sChar[s.charAt(start)]>tChar[s.charAt(start)]) {
					
					if(sChar[s.charAt(start)] > tChar[s.charAt(start)]) {
						sChar[s.charAt(start)]--;
						start++;
					}
				}
				
				int window = j - start + 1;
				if(minLen > window) {
					minLen = window;
					startIndex = start;
				}
				
			}
			
		}
		
		if(startIndex!=-1) {
			return s.substring(startIndex,startIndex+minLen);
		}
		
		return null;
		

	}

}
