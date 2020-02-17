package com.general.geeks.misc;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given a string text, we are allowed to swap two of the characters in the
 * string. Find the length of the longest substring with repeated characters.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: text = "ababa" Output: 3 Explanation: We can swap the first 'b' with
 * the last 'a', or the last 'b' with the first 'a'. Then, the longest repeated
 * character substring is "aaa", which its length is 3. Example 2:
 * 
 * Input: text = "aaabaaa" Output: 6 Explanation: Swap 'b' with the last 'a' (or
 * the first 'a'), and we get longest repeated character substring "aaaaaa",
 * which its length is 6. Example 3:
 * 
 * Input: text = "aaabbaaa" Output: 4 Example 4:
 * 
 * Input: text = "aaaaa" Output: 5 Explanation: No need to swap, longest
 * repeated character substring is "aaaaa", length is 5. Example 5:
 * 
 * Input: text = "abcdef" Output: 1
 * 
 * 
 * Constraints:
 * 
 * 1 <= text.length <= 20000 text consist of lowercase English characters only.
 * 
 * @author skadavath
 *
 */
public class SwapForLongestRepeatedCharacterSubstring {

	public int maxRepOpt1(String s) {
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(Map.Entry<Integer, Integer> ent : map.entrySet()) {
			
		}
		int[] freq = new int[26];
		char[] ch = s.toCharArray();
		for (int i = 0; i < ch.length; i++)
			freq[ch[i] - 'a']++;
		int max = 0;
		for (int i = 0; i < ch.length; i++) {
			char curr = ch[i];
			int j = i, count = 0, diff = 0;
			while (j < ch.length && (curr == ch[j] || diff == 0) && count < freq[curr - 'a']) {
				if (curr != ch[j])
					++diff;
				++count;
				++j;
			}
			max = Math.max(max, count);
		}
		for (int i = ch.length - 1; i >= 0; i--) {
			char curr = ch[i];
			int j = i, count = 0, diff = 0;
			while (j >= 0 && (curr == ch[j] || diff == 0) && count < freq[curr - 'a']) {
				if (curr != ch[j])
					++diff;
				++count;
				--j;
			}
			max = Math.max(max, count);
		}
		return max;

	}

}
