package com.general.geeks.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given many words, words[i] has weight i.

Design a class WordFilter that supports one function, WordFilter.f(String prefix, String suffix). It will return the word with given prefix and suffix with maximum weight. If no word exists, return -1.

Examples:
Input:
WordFilter(["apple"])
WordFilter.f("a", "e") // returns 0
WordFilter.f("b", "") // returns -1
Note:
words has length in range [1, 15000].
For each test case, up to words.length queries WordFilter.f may be made.
words[i] has length in range [1, 10].
prefix, suffix have lengths in range [0, 10].
words[i] and prefix, suffix queries consist of lowercase letters only.

 * @author skadavath
 *
 */
public class PrefixAndSuffixSearch {
	
	Map<String,Integer> map = new HashMap<>();
	
	public PrefixAndSuffixSearch(String[] words) {
		
		for(int i=0;i<words.length;i++) {
			for(int j=0;j<=words[i].length();j++) {
				
				for(int k=0;k<=words[i].length();k++) {
					
					map.put(words[i].substring(0, j)+"#"+words[i].substring(words[i].length()-k), i);
					
				}
				
			}
		}
	}
	
	 public int f(String prefix, String suffix) {
		 
		 if(map.containsKey(prefix+"#"+suffix))
			 return map.get(prefix+"#"+suffix);
		 
		 return -1;
		 
	 }
	
	
	
	//below is a probable TLE
//	String[] words;
//	 public PrefixAndSuffixSearch(String[] words) {
//	        this.words = words;
//	    }
//	    
//	    public int f(String prefix, String suffix) {
//	    	
//	    	for(int i=words.length-1;i>=0;i--) {
//	    		if(words[i].startsWith(prefix) && words[i].endsWith(suffix))
//	    			return i;
//	    	}
//	    	
//	    	return -1;
//	        
//	    }

}
