package com.general.geeks.trie;

/**
 * 
 * Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true

 * 
 * @author skadavath
 *
 */
public class AddAndSearchWord {
	
	class TrieLocal {
		TrieLocal[] next = new TrieLocal[26];
		boolean isWord;
	}
	
	public static void main(String[] args) {
		
		AddAndSearchWord aasw = new AddAndSearchWord();
		aasw.addWord("mad");
		aasw.addWord("dad");
		aasw.addWord("pad");
		System.out.println(aasw.search("mad"));
		System.out.println(aasw.search(".ad"));
		System.out.println(aasw.search("m.."));
		System.out.println(aasw.search("m.c"));
		System.out.println(aasw.search("m.d"));
		System.out.println(aasw.search("p.d"));
		
	}
	
	 /** Initialize your data structure here. */
	
	TrieLocal local = new TrieLocal();
    public AddAndSearchWord() {
        
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
    	
    	TrieLocal trie = local;
    	for(char c : word.toCharArray()) {
    		if(null==trie.next[c-'a']) {
    			trie.next[c-'a'] = new TrieLocal();
    		}
    		trie = trie.next[c-'a'];
    	}
    	trie.isWord = true;
        
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
    	
    	
    	TrieLocal trie = local;
    	return match(word.toCharArray(),0,trie);
        
    }
    
    private boolean match(char[] c , int k ,TrieLocal trie) {
    	
    	if(c.length == k) {
    		return trie.isWord;
    	}
    	
    	if(c[k]!='.') {
    		return null!=trie.next[c[k]-'a'] && match(c, k+1, trie.next[c[k]-'a']);
    	}
    	else {
    		for(int i=0;i<26;i++) {
    			if(null==trie.next[i])
    				continue;
    			if(match(c,k+1,trie.next[i]))
    			return true;
    		}
    	}
    	return false;
    	
    }

}


