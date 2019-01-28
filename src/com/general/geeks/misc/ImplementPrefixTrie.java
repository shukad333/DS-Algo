package com.general.geeks.misc;

/**
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * Example:
 * 
 * Trie trie = new Trie();
 * 
 * trie.insert("apple"); trie.search("apple"); // returns true
 * trie.search("app"); // returns false trie.startsWith("app"); // returns true
 * trie.insert("app"); trie.search("app"); // returns true Note:
 * 
 * You may assume that all inputs are consist of lowercase letters a-z. All
 * inputs are guaranteed to be non-empty strings.
 * 
 * @author skadavath
 *
 */
public class ImplementPrefixTrie {
	
	public static void main(String[] args) {
		ImplementPrefixTrie tr = new ImplementPrefixTrie();
		tr.insert("shuhail");
		tr.insert("naoor");
		tr.insert("shinu");
		System.out.println(tr.search("naoor"));
		System.out.println(tr.search("sh"));
		System.out.println(tr.startsWith("na"));
	}

	TrieNode trieNode = null;

	public ImplementPrefixTrie() {
		trieNode = new TrieNode(' ');
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		
		TrieNode temp = trieNode;
		for (char c : word.toCharArray()) {
			
			if(null==temp.children[c-'a']) {
				temp.children[c-'a'] = new TrieNode(c);
			}
			temp = temp.children[c-'a'];

		}
		temp.isWord=true;
		
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		
		TrieNode temp = trieNode;
		for(char c : word.toCharArray()) {
			if(null!=temp.children[c-'a']) {
				temp = temp.children[c-'a'];
			}
			else
				return false;
		}
		return temp.isWord;

	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		TrieNode temp = trieNode;
		for(char c : prefix.toCharArray()) {
			if(null!=temp.children[c-'a']) {
				temp = temp.children[c-'a'];
			}
			else
				return false;
		}
		return true;

	}

}
