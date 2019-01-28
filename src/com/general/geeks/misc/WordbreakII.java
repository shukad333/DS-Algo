package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, add spaces in s to construct a sentence where each word is a
 * valid dictionary word. Return all such possible sentences.
 * 
 * Note:
 * 
 * The same word in the dictionary may be reused multiple times in the
 * segmentation. You may assume the dictionary does not contain duplicate words.
 * Example 1:
 * 
 * Input: s = "catsanddog" wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output: [ "cats and dog", "cat sand dog" ] Example 2:
 * 
 * Input: s = "pineapplepenapple" wordDict = ["apple", "pen", "applepen",
 * "pine", "pineapple"] Output: [ "pine apple pen apple", "pineapple pen apple",
 * "pine applepen apple" ] Explanation: Note that you are allowed to reuse a
 * dictionary word. Example 3:
 * 
 * Input: s = "catsandog" wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: []
 * 
 * @author skadavath
 *
 */
public class WordbreakII {
	
	public static void main(String[] args) {
		
		System.out.println(new WordbreakII().wordBreak("catsanddog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
	}

	public List<String> wordBreak(String s, List<String> wordDict) {
		
		return dfs(s, wordDict, new HashMap<>());
	}

	private List<String> dfs(String s, List<String> wordDict,Map<String, List<String>> map) {
		
		if(map.containsKey(s)) {
            return map.get(s);
        }
		
		List<String> resp = new ArrayList<>();
		if (s.length()==0) {

			resp.add("");
			return resp;
		}
		
		for(String word : wordDict) {
			if(s.startsWith(word)) {
				List<String> r = dfs(s.substring(word.length()), wordDict, map);
				for(String w : r) {
					resp.add(word+(w==""?"":" ")+w);
				}
			}
		}
		map.put(s, resp);
		return resp;

	}
}
