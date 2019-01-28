package com.general.geeks.misc;

/**
 * Given an arbitrary ransom note string and another string containing letters
 * from all the magazines, write a function that will return true if the ransom
 * note can be constructed from the magazines ; otherwise, it will return false.
 * 
 * Each letter in the magazine string can only be used once in your ransom note.
 * 
 * Note: You may assume that both strings contain only lowercase letters.
 * 
 * canConstruct("a", "b") -> false canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * 
 * @author skadavath
 *
 */
public class RansomNote {
	
	public static void main(String[] args) {
		System.out.println(new RansomNote().canConstruct("a", "b"));
		System.out.println(new RansomNote().canConstruct("aa", "aab"));
	}

	public boolean canConstruct(String ransomNote, String magazine) {
		
		int[] chars = new int[26];
		for(char c : magazine.toCharArray())
			chars[c-'a']++;
		for(char c : ransomNote.toCharArray()) {
			if(--chars[c-'a'] < 0)
				return false;
		}
		return true;

	}

}
