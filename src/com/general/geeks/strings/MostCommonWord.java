package com.general.geeks.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.

Example:
Input: 
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output: "ball"
Explanation: 
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"), 
and that "hit" isn't the answer even though it occurs more because it is banned.

 * @author skadavath
 *
 */
public class MostCommonWord {
	
	public static void main(String[] args) {
		
		System.out.println(new MostCommonWord().mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[] {"hit"}));
	}

	public String mostCommonWord(String paragraph, String[] banned) {
		
		Map<String,Integer> map = new HashMap<>();
		
		for(String s : banned) {
			map.put(s, -1);
		}
		String[] splitted = paragraph.toLowerCase().split("[ !?',;.]+");
		for(String s : splitted) {
			
			if(!map.containsKey(s)) {
				map.put(s, 1);
			}
			else {
				if(map.get(s)!=-1)
				map.put(s, map.get(s)+1);
			}
		}
		
		int largest = 0;
		String common = "";
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			
			if(entry.getValue()>largest) {
				largest = entry.getValue();
				common = entry.getKey();
			}
		}
		
		return common;

	}

}
