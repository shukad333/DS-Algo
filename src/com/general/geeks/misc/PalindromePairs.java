package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

Example 1:

Input: ["abcd","dcba","lls","s","sssll"]
Output: [[0,1],[1,0],[3,2],[2,4]] 
Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
Example 2:

Input: ["bat","tab","cat"]
Output: [[0,1],[1,0]] 
Explanation: The palindromes are ["battab","tabbat"]

 * @author skadavath
 *
 */
public class PalindromePairs {
	
	public static void main(String[] args) {
		
		System.out.println(new PalindromePairs().palindromePairs(new String[] {"abcd","dcba","lls","s","sssll"}));
		
	}

	public List<List<Integer>> palindromePairs(String[] words) {
		
		
		Map<String, Integer> map = new HashMap<>();
		
		
		for(int i=0;i<words.length;i++)
			map.put(words[i], i);
		
		
		List<List<Integer>> resp = new ArrayList<>();
		
		//for blank string and other pal strings
		
		if(map.containsKey("")) {
			int blank = map.get("");
			for(int j=0;j<words.length;j++) {
				if(isPal(words[j])) {
					List<Integer> temp = new ArrayList<>();
					temp.add(blank);
					temp.add(map.get(words[j]));
					resp.add(temp);
				}
			}
		}
		
		
		//check for reverse
		for(int i=0;i<words.length;i++) {
			
			String word = words[i];
			
			if(word!="") {
				String s2 = new StringBuilder(word).reverse().toString();
				if(map.containsKey(s2) && map.get(s2)!=i) {
					
					List<Integer> temp = new ArrayList<>();
					temp.add(map.get(word));
					temp.add(map.get(s2));
					resp.add(temp);
					
				}
			}
			
		}
		
		//check for str[0,i] and check if its pal and there exists str[j+1,len] in the map
		
		for(int i=0;i<words.length;i++) {
			for(int j=1;j<words[i].length();j++) {
				String s1 = words[i].substring(0, j);
				
				if(isPal(s1)) {
					String s2 = new StringBuilder(words[i].substring(j)).reverse().toString();
					if(map.get(s2)!=null && map.get(s2)!=i) {
						
						List<Integer> temp = new ArrayList<>();
						
						temp.add(map.get(s2));
						temp.add(i);
						resp.add(temp);
						
					}
				}
				
				String s2 = words[i].substring(j);
				if(isPal(s2)) {
					String s2Rev = new StringBuilder(s1).reverse().toString();
					if(map.get(s2Rev)!=null && map.get(s2Rev)!=i) {
						List<Integer> temp = new ArrayList<>();
						temp.add(i);
						temp.add(map.get(s2Rev));
						resp.add(temp);
					}
				}
				
				
			}
		}
		
		
		
		
		
		return resp;

	}
	
	private boolean isPal(String s) {
		int start = 0;
		int end = s.length()-1;
		
		while(start<=end) {
			if(s.charAt(start++)!=s.charAt(end--))return false;
		}
		return true;
	}

}
