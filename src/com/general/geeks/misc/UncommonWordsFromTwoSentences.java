package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * We are given two sentences A and B. (A sentence is a string of space
 * separated words. Each word consists only of lowercase letters.)
 * 
 * A word is uncommon if it appears exactly once in one of the sentences, and
 * does not appear in the other sentence.
 * 
 * Return a list of all uncommon words.
 * 
 * You may return the list in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: A = "this apple is sweet", B = "this apple is sour" Output:
 * ["sweet","sour"] Example 2:
 * 
 * Input: A = "apple apple", B = "banana" Output: ["banana"]
 * 
 * @author skadavath
 *
 */
public class UncommonWordsFromTwoSentences {
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new UncommonWordsFromTwoSentences().uncommonFromSentences("this apple is sweet", "this apple is sour")));
	}

	public String[] uncommonFromSentences(String A, String B) {
		
		Map<String, Integer> map = new HashMap<>();
		if(!A.isEmpty())
		for(String s : A.split(" ")) {
			map.put(s, map.getOrDefault(s, 0)+1);
		}
		if(!B.isEmpty())
		for(String s : B.split(" ")) {
			map.put(s, map.getOrDefault(s, 0)+1);
		}
		
		List<String> resp = new ArrayList<>();
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			if(entry.getValue()==1)
				resp.add(entry.getKey());
		}
		
		return resp.toArray(new String[resp.size()]);

	}

}
