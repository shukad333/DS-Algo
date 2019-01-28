package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * Given a string S, we can transform every letter individually to be lowercase
 * or uppercase to create another string. Return a list of all possible strings
 * we could create.
 * 
 * Examples: Input: S = "a1b2" Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * 
 * Input: S = "3z4" Output: ["3z4", "3Z4"]
 * 
 * Input: S = "12345" Output: ["12345"] Note:
 * 
 * S will be a string with length at most 12. S will consist only of letters or
 * digits.
 * 
 * @author skadavath
 *
 */
public class LetterCasePermutation {

	public static void main(String[] args) {

		List<String> op = new LetterCasePermutation().letterCasePermutation("ab");
		System.out.println(op);
	}

	public List<String> letterCasePermutation(String S) {

		Queue<String> queue = new LinkedList<>();
		queue.offer(S);
		for (int j = 0; j < S.length(); j++) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String curr = queue.poll();
				char[] c = curr.toCharArray();
				if (Character.isDigit(c[j]))
					continue;

				c[j] = Character.toUpperCase(c[j]);
				queue.offer(String.valueOf(c));
				
				c[j] = Character.toLowerCase(c[j]);
				queue.offer(String.valueOf(c));

			}
		}

		return new LinkedList<>(queue);

	}

}
