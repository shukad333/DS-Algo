package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a List of words, return the words that can be typed using letters of
 * alphabet on only one row's of American keyboard like the image below.
 * 
 * Example 1: Input: ["Hello", "Alaska", "Dad", "Peace"] Output: ["Alaska",
 * "Dad"] Note: You may use one character in the keyboard more than once. You
 * may assume the input string will only contain letters of alphabet.
 * 
 * @author skadavath
 *
 */
public class KeyboardRow {
	
	public static void main(String[] args) {
		
		String[] s = new KeyboardRow().findWords(new String[] {"Hello","Alaska","dad"});
		System.out.println(s[0]);
	}

	public String[] findWords(String[] words) {
		
		String[] keyboard = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
		
		Map<Character,Integer> map = new HashMap<>();
		for(int i=0;i<keyboard.length;i++) {
			String s = keyboard[i];
			for(char c : s.toCharArray()) {
				map.put(c, i);
			}
		}
		List<String> res = new ArrayList<>();
		
		for(String s : words) {
			if(s.isEmpty() || s=="")
				continue;
			int start = map.get(s.toUpperCase().charAt(0));
			for(int j=1;j<s.length();j++) {
				if(map.get(s.toUpperCase().charAt(j))!=start) {
					start = -1;
					break;
				}
			}
			if(start!=-1)
				res.add(s);
		}
		
		return res.toArray(new String[res.size()]);

	}

}
