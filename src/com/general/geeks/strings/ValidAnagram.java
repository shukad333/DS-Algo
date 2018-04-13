package com.general.geeks.strings;

/**
 * Given two strings s and t, write a function to determine if t is an anagram
 * of s.
 * 
 * For example, s = "anagram", t = "nagaram", return true. s = "rat", t = "car",
 * return false.
 * 
 * @author skadavath
 *
 */
public class ValidAnagram {

	public static void main(String[] args) {

		System.out.println(new ValidAnagram().isAnagram("anagram", "nagaram"));
	}

	public boolean isAnagram(String s, String t) {

		if (s.length() != t.length()) {
			return false;
		}

		int[] sChar = new int[256];
		int[] tChar = new int[256];

		for (int i = 0; i < s.length(); i++) {
			sChar[s.charAt(i)]++;
			tChar[t.charAt(i)]++;

		}

		for (int i = 0; i < 256; i++) {
			if (sChar[i] != tChar[i]) {
				return false;
			}
		}
		return true;
	}
}
