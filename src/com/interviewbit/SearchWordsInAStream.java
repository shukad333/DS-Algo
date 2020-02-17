package com.interviewbit;

import java.util.Arrays;
import java.util.List;

public class SearchWordsInAStream {

	SearchTrie root = new SearchTrie();

	public static void main(String[] args) {

		SearchWordsInAStream search = new SearchWordsInAStream();
		search.insertIntoTrie("shuhail");
		search.insertIntoTrie("nooru");

		System.out.println(search.isPresent("nooru",false));
		System.out.println(search.isPresent("noor",true));
		
		System.out.println(search.isPresent("noorus",true));
	
			
	

	}
	
	
	private void insertIntoTrie(String word) {

		SearchTrie current = root;

		for (char c : word.toCharArray()) {

			if (current.next[c - 'a'] == null) {

				current.next[c - 'a'] = new SearchTrie();
			}
			current = current.next[c - 'a'];

		}

		current.isWord = true;

	}

	private boolean isPresent(String word,boolean isPrefixOnly) {

		SearchTrie current = root;

		for (char c : word.toCharArray()) {

			if (current.next[c - 'a'] == null)
				return false;
			current = current.next[c - 'a'];

		}

		return current.isWord || isPrefixOnly;
	}

}

class SearchTrie {

	
	SearchTrie[] next = new SearchTrie[26];
	boolean isWord;

	}
