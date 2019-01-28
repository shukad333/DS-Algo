package com.general.geeks.array;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Given string S and a dictionary of words words, find the number of words[i]
 * that is a subsequence of S.
 * 
 * Example : Input: S = "abcde" words = ["a", "bb", "acd", "ace"] Output: 3
 * Explanation: There are three words in words that are a subsequence of S: "a",
 * "acd", "ace". Note:
 * 
 * All words in words and S will only consists of lowercase letters. The length
 * of S will be in the range of [1, 50000]. The length of words will be in the
 * range of [1, 5000]. The length of words[i] will be in the range of [1, 50].
 * 
 * @author skadavath
 *
 */
public class NumberOfMatchingSubsequences {
	
	public static void main(String[] args) {
		System.out.println(new NumberOfMatchingSubsequences().numMatchingSubseq("abcde", new String[] {"a","bb","acd","ace"}));
	}

	public int numMatchingSubseq(String S, String[] words) {
		
		 Map<Character, Deque<String>> map = new HashMap<>();
	        for (char c = 'a'; c <= 'z'; c++) {
	            map.putIfAbsent(c, new LinkedList<String>());
	        }
	        for (String word : words) {
	            map.get(word.charAt(0)).addLast(word);
	        }

	        int count = 0;
	        for (char c : S.toCharArray()) {
	            Deque<String> queue = map.get(c);
	            int size = queue.size();
	            for (int i = 0; i < size; i++) {
	                String word = queue.removeFirst();
	                if (word.length() == 1) {
	                    count++;
	                } else {
	                    map.get(word.charAt(1)).addLast(word.substring(1));
	                }
	            }
	        }
	        return count;
	    }

	}
