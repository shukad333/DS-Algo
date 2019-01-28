package com.general.geeks.strings;

/**
 * 
 * A character is unique in string S if it occurs exactly once in it.
 * 
 * For example, in string S = "LETTER", the only unique characters are "L" and
 * "R".
 * 
 * Let's define UNIQ(S) as the number of unique characters in string S.
 * 
 * For example, UNIQ("LETTER") = 2.
 * 
 * Given a string S with only uppercases, calculate the sum of UNIQ(substring)
 * over all non-empty substrings of S.
 * 
 * If there are two or more equal substrings at different positions in S, we
 * consider them different.
 * 
 * Since the answer can be very large, return the answer modulo 10 ^ 9 + 7.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: "ABC" Output: 10 Explanation: All possible substrings are:
 * "A","B","C","AB","BC" and "ABC". Evey substring is composed with only unique
 * letters. Sum of lengths of all substring is 1 + 1 + 1 + 2 + 2 + 3 = 10
 * Example 2:
 * 
 * Input: "ABA" Output: 8 Explanation: The same as example 1, except uni("ABA")
 * = 1.
 * 
 * 
 * @author skadavath
 *
 */
public class UniqueLetterString {

	public static void main(String[] args) {

		System.out.println(new UniqueLetterString().uniqueLetterString("ABC"));

	}

	public int uniqueLetterString(String S) {
		
		int resp = 0;
		
		int[] positions = new int[26];
		int[] uniqueness = new int[26];
		int curr = 0;
		for(int i=0;i<S.length();i++) {
			
			int currChar = S.charAt(i)-'A';
			curr-=uniqueness[currChar];
			uniqueness[currChar] = i-(positions[currChar]-1);
			curr+=uniqueness[currChar];
			positions[currChar] = i+1;
			resp+=curr;
		}
		return resp;

	}

}
