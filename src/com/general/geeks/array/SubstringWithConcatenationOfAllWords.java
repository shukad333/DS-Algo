package com.general.geeks.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * You are given a string, s, and a list of words, words, that are all of the
 * same length. Find all starting indices of substring(s) in s that is a
 * concatenation of each word in words exactly once and without any intervening
 * characters.
 * 
 * Example 1:
 * 
 * Input: s = "barfoothefoobarman", words = ["foo","bar"] Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar"
 * respectively. The output order does not matter, returning [9,0] is fine too.
 * Example 2:
 * 
 * Input: s = "wordgoodstudentgoodword", words = ["word","student"] Output: []
 * 
 * 
 * 
 * @author skadavath
 *
 */
public class SubstringWithConcatenationOfAllWords {

	public static void main(String[] args) {

		System.out.println(new SubstringWithConcatenationOfAllWords().findSubstring("barfoothefoobarman",
				new String[] { "foo", "bar" }));

	}

	public List<Integer> findSubstring(String s, String[] words) {

		List<Integer> resp = new ArrayList<>();
		if (s.length() == 0 || words.length == 0)
			return resp;

		Map<String, Integer> map = new HashMap<>();
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}

		int len = words[0].length();
		int total = words.length;
		for (int i = 0; i < s.length() - len * total + 1; i++) {

			Map<String, Integer> visited = new HashMap<>();
			int j = 0;

			while (j < total) {

				String subStr = s.substring(i + j * len, i + (j + 1) * len);
				if (map.containsKey(subStr)) {
					visited.put(subStr, visited.getOrDefault(subStr, 0) + 1);
					if (visited.get(subStr) > map.get(subStr)) {
						break;
					}
				} else
					break;
				j++;

			}
			if (j == words.length)
				resp.add(i);

		}

		return resp;

	}

}
