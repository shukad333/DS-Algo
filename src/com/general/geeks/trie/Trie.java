package com.general.geeks.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {

	TrieNode root = new TrieNode();;

	public void insert(String word) {
		TrieNode current = root;

		for (int i = 0; i < word.length(); i++) {
			current = current.getChildren().computeIfAbsent(word.charAt(i), c -> new TrieNode());

		}
		current.setWord(true);
	}

	public boolean isPresent(String word) {

		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			TrieNode node = current.getChildren().get(word.charAt(i));
			if (node == null) {
				return false;
			}
			current = node;
		}
		return current.isWord();

	}
	
	public void autoSuggest(String word) {
		
		TrieNode current = root;
		boolean somethingIsPresent = false;
		for(int i=0;i<word.length();i++) {
			TrieNode node = current.getChildren().get(word.charAt(i));
			if(node!=null) {
				somethingIsPresent=true;
				current = node;
			}
			if(somethingIsPresent) {
				
			}
		}
	}
	
	public static void main(String[] args) {
		
		Trie trie = new Trie();
		trie.insert("123");
		trie.insert("Shuhail");
		trie.insert("Naoor");
		trie.insert("Navami");
		
		System.out.println(trie.isPresent("12"));
		System.out.println(trie.isPresent("Navami"));
		
	}

}

class TrieNode {
	private Map<Character, TrieNode> children = new HashMap<>();;
	private String content;
	private boolean isWord;

	public Map<Character, TrieNode> getChildren() {
		return children;
	}

	public void setChildren(Map<Character, TrieNode> children) {
		this.children = children;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isWord() {
		return isWord;
	}

	public void setWord(boolean isWord) {
		this.isWord = isWord;
	}

}
