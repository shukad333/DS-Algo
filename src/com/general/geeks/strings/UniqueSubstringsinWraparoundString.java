package com.general.geeks.strings;

/**
 * 
 * Consider the string s to be the infinite wraparound string of
 * "abcdefghijklmnopqrstuvwxyz", so s will look like this:
 * "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".
 * 
 * Now we have another string p. Your job is to find out how many unique
 * non-empty substrings of p are present in s. In particular, your input is the
 * string p and you need to output the number of different non-empty substrings
 * of p in the string s.
 * 
 * Note: p consists of only lowercase English letters and the size of p might be
 * over 10000.
 * 
 * Example 1: Input: "a" Output: 1
 * 
 * Explanation: Only the substring "a" of string "a" is in the string s.
 * Example 2: Input: "cac" Output: 2 Explanation: There are two substrings "a",
 * "c" of string "cac" in the string s. Example 3: Input: "zab" Output: 6
 * Explanation: There are six substrings "z", "a", "b", "za", "ab", "zab" of
 * string "zab" in the string s.
 * 
 * @author skadavath
 *
 */
public class UniqueSubstringsinWraparoundString {

	public int findSubstringInWraproundString(String p) {

		/**
		 * Intuition - A string ending with a particular char for eg : abcd has four
		 * substrings : d,cd,bcd,abcd
		 * 
		 * So see the string ending with a particular char and find out the summary
		 */

		// count[i] is the maximum unique substring end with ith letter.
		// 0 - 'a', 1 - 'b', ..., 25 - 'z'.
		int[] counts = new int[26];

		int maxLength = 0;
		for (int i = 0; i < p.length(); i++) {

			if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || p.charAt(i - 1) - p.charAt(i) == 25)) {
				maxLength++;
			} else {
				maxLength = 1;
			}

			int c = p.charAt(i) - 'a';
			counts[c] = Math.max(counts[c], maxLength);
		}

		int summary = 0;
		for (int i = 0; i < 26; i++) {
			summary += counts[i];
		}

		return summary;

	}

}
