package com.general.geeks.queandstack;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a string S, check if the letters can be rearranged so that two
 * characters that are adjacent to each other are not the same.
 * 
 * If possible, output any possible result. If not possible, return the empty
 * string.
 * 
 * Example 1:
 * 
 * Input: S = "aab" Output: "aba" Example 2:
 * 
 * Input: S = "aaab" Output: ""
 * 
 * @author skadavath
 *
 */
public class ReArrangeString {

	public static void main(String[] args) {

		System.out.println(new ReArrangeString().reorganizeString("aaab"));

	}

	public String reorganizeString(String S) {

		if (S == "") {
			return S;
		}

		HashMap<Character, Integer> charMap = new HashMap<>();
		for (char c : S.toCharArray()) {
			int count = charMap.getOrDefault(c, 0) + 1;

			if (count > ((S.length() + 1)/ 2 )) {
				return "";
			}

			charMap.put(c, count);
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

		for (char c : charMap.keySet()) {
			pq.add(new int[] { c, charMap.get(c) });
		}

		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {

			int[] item1 = pq.poll();
			if (sb.length() == 0 || sb.charAt(sb.length() - 1) != item1[0]) {
				sb.append((char) item1[0]);
				if (--item1[1] > 0)
					pq.add(item1);
			} else {
				int[] item2 = pq.poll();
				sb.append((char)item2[0]);
				if (--item2[1] > 0)
					pq.add(item2);
				pq.add(item1);
			}
			
		}
		return sb.toString();
	}

}
