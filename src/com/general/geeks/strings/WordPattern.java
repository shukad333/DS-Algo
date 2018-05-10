package com.general.geeks.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author skadavath
 *
 */
public class WordPattern {
	
	public static void main(String[] args) {

		Map index = new HashMap();

		// explanation of how this works;
		System.out.println(index.put("a", 1) + "  " + index.put("shu", 1));
		System.out.println(index.put("b", 2) + "  " + index.put("naoor", 2));
		System.out.println(index.put("b", 3) + "  " + index.put("naoor", 3));
		System.out.println(index.put("a", 4) + "  " + index.put("shu", 4));
		System.out.println(new WordPattern().wordPattern("abba", "shu naoor naoor shu"));
	}

	public boolean wordPattern(String pattern, String str) {

		String[] words = str.split(" ");
		if (words.length != pattern.length())
			return false;
		Map<Object,Integer> index = new HashMap();
		for (Integer i = 0; i < words.length; ++i)
			if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
				return false;
		return true;

	}
}
