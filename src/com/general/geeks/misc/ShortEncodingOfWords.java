package com.general.geeks.misc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Given a list of words, we may encode it by writing a reference string S and a
 * list of indexes A.
 * 
 * For example, if the list of words is ["time", "me", "bell"], we can write it
 * as S = "time#bell#" and indexes = [0, 2, 5].
 * 
 * Then for each index, we will recover the word by reading from the reference
 * string from that index until we reach a "#" character.
 * 
 * What is the length of the shortest reference string S possible that encodes
 * the given words?
 * 
 * Example:
 * 
 * Input: words = ["time", "me", "bell"] Output: 10 Explanation: S =
 * "time#bell#" and indexes = [0, 2, 5]. Note:
 * 
 * 1 <= words.length <= 2000. 1 <= words[i].length <= 7. Each word has only
 * lowercase letters.
 * 
 * @author skadavath
 *
 */
public class ShortEncodingOfWords {

	public static void main(String[] args) {
		String s = "Shuhail";
		System.out.println(s.substring(1));
		System.out.println(new ShortEncodingOfWords().minimumLengthEncoding(new String[] {"time","me","bell"}));
		
	}

	public int minimumLengthEncoding(String[] words) {
		
		Set<String> set = new TreeSet<>(Arrays.asList(words));
		for(String s : words) {
			for(int i=1;i<s.length();i++) {
				set.remove(s.substring(i));
			}
		}
		int count = 0;
		for(String s : words)
			count+=s.length();
		return count;

	}

}
