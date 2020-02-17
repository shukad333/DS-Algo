package com.general.geeks.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given a list of words, each word consists of English lowercase letters.

Let's say word1 is a predecessor of word2 if and only if we can add exactly one letter anywhere in word1 to make it equal to word2.  For example, "abc" is a predecessor of "abac".

A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >= 1, where word_1 is a predecessor of word_2, word_2 is a predecessor of word_3, and so on.

Return the longest possible length of a word chain with words chosen from the given list of words.

 

Example 1:

Input: ["a","b","ba","bca","bda","bdca"]
Output: 4
Explanation: one of the longest word chain is "a","ba","bda","bdca".
 

Note:

1 <= words.length <= 1000
1 <= words[i].length <= 16
words[i] only consists of English lowercase letters.
 
 * 
 * @author skadavath
 *
 */
public class LongestStringChain {
	
	public static void main(String[] args) {
		
		System.out.println(new LongestStringChain().longestStrChain(new String[] {"a","b","ba","bca","bda","bdca"}));
		
	}

	public int longestStrChain(String[] words) {
		
		Arrays.sort(words,(a,b)->a.length()-b.length());
		
		int resp = 0;
		
		Map<String, Integer> map = new HashMap<>();
		for(String word : words) {
			
			if(map.containsKey(word))
				continue;
			
			map.put(word, 1);
			for(int i=0;i<word.length();i++) {
				StringBuilder sb = new StringBuilder(word);
				sb.deleteCharAt(i);
				String next = sb.toString();
				
				if(map.containsKey(next) && map.get(next)+1>map.get(word))
					map.put(word, map.get(next)+1);
				
				
			}
			
			resp = Math.max(resp, map.get(word));
		}
		return resp;

	}

}
