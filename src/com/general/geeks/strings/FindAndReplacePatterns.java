package com.general.geeks.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You have a list of words and a pattern, and you want to know which words in
 * words matches the pattern.
 * 
 * A word matches the pattern if there exists a permutation of letters p so that
 * after replacing every letter x in the pattern with p(x), we get the desired
 * word.
 * 
 * (Recall that a permutation of letters is a bijection from letters to letters:
 * every letter maps to another letter, and no two letters map to the same
 * letter.)
 * 
 * Return a list of the words in words that match the given pattern.
 * 
 * You may return the answer in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb" Output:
 * ["mee","aqq"] Explanation: "mee" matches the pattern because there is a
 * permutation {a -> m, b -> e, ...}. "ccc" does not match the pattern because
 * {a -> c, b -> c, ...} is not a permutation, since a and b map to the same
 * letter.
 * 
 * 
 * Note:
 * 
 * 1 <= words.length <= 50 1 <= pattern.length = words[i].length <= 20
 * 
 * @author skadavath
 *
 */
public class FindAndReplacePatterns {

	public static void main(String[] args) {

		FindAndReplacePatterns find = new FindAndReplacePatterns();
		System.out
				.println(find.findAndReplacePattern(new String[] { "abc", "deq", "mee", "aqq", "dkd", "ccc" }, "abb"));
	}

	public List<String> findAndReplacePattern(String[] words, String pattern) {

		List<String> resp = new ArrayList<String>();
		for (String word : words) {
			if (isMatching(word, pattern))
				resp.add(word);
		}

		return resp;

	}

	private boolean isMatching(String a, String b) {
		if (a.length() != b.length())
			return false;

		Map<Character, Character> map1 = new HashMap<>();
		Map<Character, Character> map2 = new HashMap<>();

		for (int i = 0; i < a.length(); i++) {

			char source = a.charAt(i);
			char target = b.charAt(i);

			if (!map1.containsKey(source)) {
				map1.put(source, target);
			}
			if (!map2.containsKey(target)) {
				map2.put(target, source);
			}
			if (map1.get(source) != target || map2.get(target) != source)
				return false;

		}

		return true;

	}

}
