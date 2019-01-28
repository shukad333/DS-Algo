package com.general.geeks.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 * 
 * @author skadavath
 *
 */
public class WordLadder {

	public static void main(String[] args) {

		String[] arr = { "hot", "dot", "dog", "lot", "log", "cog" };
		List<String> wordList = new ArrayList();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		System.out.println(new WordLadder().ladderLength("hit", "cog", wordList));
	}

	
	
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {

		Queue<SItem> queue = new LinkedList();
		queue.add(new SItem(beginWord, 1));

		while (!queue.isEmpty()) {

			SItem item = queue.poll();

			for (Iterator<String> iterator = wordList.iterator(); iterator.hasNext();) {

				String str = iterator.next();
				if (isAdjacent(str, item.word)) {
					SItem it = new SItem(str, item.len + 1);

					queue.add(it);
					iterator.remove();

					if (str.equals(endWord)) {
						return it.len;
					}
				}

			}

		}
		return 0;

	}

	private boolean isAdjacent(String s1, String s2) {

		int count = 0;
		for (int i = 0; i < s1.length(); i++) {

			if (s1.charAt(i) != s2.charAt(i)) {
				count++;
			}

			if (count > 1) {
				return false;
			}
		}
		return true;
	}
}

class SItem {
	String word;
	int len;

	public SItem(String word, int len) {
		this.word = word;
		this.len = len;
	}
}
