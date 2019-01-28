package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a list of words (without duplicates), please write a program that
 * returns all concatenated words in the given list of words. A concatenated
 * word is defined as a string that is comprised entirely of at least two
 * shorter words in the given array.
 * 
 * Example: Input:
 * ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
 * 
 * Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
 * 
 * Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
 * "dogcatsdog" can be concatenated by "dog", "cats" and "dog"; "ratcatdogcat"
 * can be concatenated by "rat", "cat", "dog" and "cat". Note: The number of
 * elements of the given array will not exceed 10,000 The length sum of elements
 * in the given array will not exceed 600,000. All the input string will only
 * include lower case letters. The returned elements order does not matter.
 * 
 * @author skadavath
 *
 */
public class ConcatenatedWords {
	
	public static void main(String[] args) {
		
		System.out.println(new ConcatenatedWords().findAllConcatenatedWordsInADict(new String[] {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"}));
		
	}

	public List<String> findAllConcatenatedWordsInADict(String[] words) {
		
		List<String> resp = new ArrayList<>();
		
		Set<String> wordSet = new HashSet<>();
		
		Arrays.sort(words, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				
				return o1.length()-o2.length();
			}
		});
		
		for(String word : words) {
			if(isWordFormable(word, wordSet)) {
				resp.add(word);
			}
			wordSet.add(word);
		}
		return resp;

	}
	
	
	private boolean isWordFormable(String target , Set<String> words) {
		
		if(words.isEmpty())
			return false;
		boolean[] dp = new boolean[target.length()+1];
		
		dp[0] = true;
		
		for(int i=1;i<=target.length();i++) {
			
			for(int j=0;j<i;j++) {
				if(dp[j] && words.contains(target.substring(j, i))) {
					dp[i]=true;
					break;
				}
				
			}
		}
		
		return dp[target.length()];
		
	}

}
