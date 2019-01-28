package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
 * @author skadavath
 *
 */
public class GroupAnagrams {
	
	public static void main(String[] args) {
		System.out.println(new GroupAnagrams().groupAnagrams(new String[] {"eat","bat","tea","tan","ate","nat"}));
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		
		Map<String, List<String>> map = new HashMap<>();
		
		for(String s : strs) {
			
			int[] charArr = new int[26];
			for(int i=0;i<s.length();i++) {
				charArr[s.charAt(i)-'a']++;
			}
			
			String strEncode = Arrays.toString(charArr);
			map.putIfAbsent(strEncode, new ArrayList<>());
			map.get(strEncode).add(s);
			//System.out.println(strEncode);
			
		}
		
		
		List<List<String>> resp = new ArrayList<>();
		
		for(Map.Entry<String, List<String>> entry : map.entrySet()) {
			resp.add(new ArrayList<>(entry.getValue()));
		}
		
		return resp;

	}

}
