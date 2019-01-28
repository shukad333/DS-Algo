package com.general.geeks.misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * In English, we have a concept called root, which can be followed by some
 * other words to form another longer word - let's call this word successor. For
 * example, the root an, followed by other, which can form another word another.
 * 
 * Now, given a dictionary consisting of many roots and a sentence. You need to
 * replace all the successor in the sentence with the root forming it. If a
 * successor has many roots can form it, replace it with the root with the
 * shortest length.
 * 
 * You need to output the sentence after the replacement.
 * 
 * Example 1: Input: dict = ["cat", "bat", "rat"] sentence = "the cattle was
 * rattled by the battery" Output: "the cat was rat by the bat" Note: The input
 * will only have lower-case letters. 1 <= dict words number <= 1000 1 <=
 * sentence words number <= 1000 1 <= root length <= 100 1 <= sentence words
 * length <= 1000
 * 
 * @author skadavath
 *
 */
public class ReplaceWords {
	
	public static void main(String[] args) {
		System.out.println(new ReplaceWords().replaceWords(Arrays.asList("cat", "bat", "rat"), "the cattle was rattled by the battery"));
	}

	public String replaceWords(List<String> dict, String sentence) {

		String[] tokens = sentence.split(" ");
		TrieNode trie = constructTrie(dict);
		return replaceWords(tokens, trie);

	}
	
	private String replaceWords(String[] tokens , TrieNode trie) {
		
		StringBuilder sb = new StringBuilder();
		for(String s : tokens) {
			sb.append(getReplacement(s, trie));
			sb.append(" ");
		}
		return sb.toString();
		
	}
	
	private String getReplacement(String str , TrieNode trie) {
		
		TrieNode root = trie;
		StringBuilder sb = new StringBuilder();
		for(char c : str.toCharArray()) {
			sb.append(c);
			if(root.children[c-'a']!=null) {
				if(root.children[c-'a'].isWord) {
					return sb.toString();
				}
				root = root.children[c-'a'];
			}
			else
				return str;
		}
		return str;
	}

	private TrieNode constructTrie(List<String> dict) {

		TrieNode trie = new TrieNode(' ');
		for (String s : dict) {
			TrieNode child = trie;
			for (char c : s.toCharArray()) {

				if (null == child.children[c-'a']) {
					child.children[c-'a'] = new TrieNode(c);

				}
				child = child.children[c-'a'];

			}
			child.isWord = true;
		}
		return trie;
	}

}

class TrieNode {
	char c;
	TrieNode[] children;
	boolean isWord;

	public TrieNode(char c) {
		this.c = c;
		children = new TrieNode[26];
		this.isWord = false;
	}
}
