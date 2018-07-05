package com.general.geeks.misc;

/**
 * Given a string S and a character C, return an array of integers representing
 * the shortest distance from the character C in the string.
 * 
 * Example 1:
 * 
 * Input: S = "loveleetcode", C = 'e' Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1,
 * 0]
 * 
 * 
 * Note:
 * 
 * S string length is in [1, 10000]. C is a single character, and guaranteed to
 * be in string S. All letters in S and C are lowercase.
 * 
 * @author skadavath
 *
 */
public class ShortestDistanceToACharacter {

	public static void main(String[] args) {

		int[] resp = new ShortestDistanceToACharacter().shortestToChar("loveleetcode", 'e');
		for (int i : resp) {
			System.out.print(i + " ");
		}
	}

	public int[] shortestToChar(String S, char C) {

		int[] resp = new int[S.length()];

		int noncChar = 0;
		int cChar = -1;

		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if (c == C) {

				while (noncChar <= i) {
					resp[noncChar] = Math.min(resp[noncChar], i - noncChar++);
				}
				cChar = i;
			} else {
				resp[i] = cChar == -1 ? Integer.MAX_VALUE : i - cChar;
			}

		}

		return resp;
	}

}
