package com.general.geeks.misc;

/**
 * Implement strStr().
 * 
 * Return the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * 
 * Example 1:
 * 
 * Input: haystack = "hello", needle = "ll" Output: 2 Example 2:
 * 
 * Input: haystack = "aaaaa", needle = "bba" Output: -1 Clarification:
 * 
 * What should we return when needle is an empty string? This is a great
 * question to ask during an interview.
 * 
 * For the purpose of this problem, we will return 0 when needle is an empty
 * string. This is consistent to C's strstr() and Java's indexOf().
 * 
 * @author skadavath
 *
 */
public class ImplementStrStr {

	public static void main(String[] args) {

		String haystack = "aaaaa";
		String needle = "bba";
		System.out.println(new ImplementStrStr().strStr(haystack, needle));

	}

	public int strStr(String haystack, String needle) {

		if (needle == null || needle.isEmpty()) {
			return 0;
		}

		char first = needle.charAt(0);
		int max = haystack.length() - needle.length();
		int index = -1;
		for (int i = 0; i <= max; i++) {

			// find the first matching in haystack
			if (haystack.charAt(i) != first) {
				while (++i <= max && first != haystack.charAt(i))
					;
			}
			
			//index = i;
			if(i<=max) {
				int j=i+1;
				int end = j+needle.length()-1;
				for(int k=1;j<end && haystack.charAt(j)==needle.charAt(k);k++,j++);
				if(j==end) {
					return i;
				}
				else
					index = -1;
			}

		}

		return index;

	}

}
