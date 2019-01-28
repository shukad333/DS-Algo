package com.general.geeks.misc;

/**
 * 
 * In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.

 

Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
Example 2:

Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
Example 3:

Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
 
 * 
 * @author skadavath
 *
 */
public class VerifyingAnAlienDictionary {
	
	public static void main(String[] args) {
		
		System.out.println(new VerifyingAnAlienDictionary().isAlienSorted(new String[] {"word","world","row"},"worldabcefghijkmnpqstuvxyz"));
		
	}

	public boolean isAlienSorted(String[] words, String order) {
		
		for(int i=0;i<words.length-1;i++) {
			if(!isLexicographical(order, words, i, i+1))
				return false;
		}
		return true;

	}
	
	
	private boolean isLexicographical(String order,String[] words,int i,int j) {
		
		int max = Math.max(words[i].length(), words[j].length());
		
		for(int k=0;k<max;k++) {
			
			if(k>=words[i].length())
				return true;
			
			if(k>=words[j].length())
				return false;
			
			if(order.indexOf(words[i].charAt(k))<order.indexOf(words[j].charAt(k))) 
				return true;
			
			if(order.indexOf(words[i].charAt(k))==order.indexOf(words[j].charAt(k))) 
				continue;
			
			else return false;
			
			
		}
		
		return true;
		
	}

}
