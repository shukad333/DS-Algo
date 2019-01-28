package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given a 2D board and a list of words from the dictionary, find all words in
 * the board.
 * 
 * Each word must be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once in a word.
 * 
 * Example:
 * 
 * Input: words = ["oath","pea","eat","rain"] and board = [ ['o','a','a','n'],
 * ['e','t','a','e'], ['i','h','k','r'], ['i','f','l','v'] ]
 * 
 * Output: ["eat","oath"] Note: You may assume that all inputs are consist of
 * lowercase letters a-z.
 * 
 * 
 * @author skadavath
 *
 */
public class WordSearch2 {
	
	public static void main(String[] args) {
		
		char[][] board = {{'o','a','a','n'},{'e','t','a','e'}, {'i','h','k','r'}, {'i','f','l','v'}};
		
		System.out.println(new WordSearch2().findWords(board, new String[] {"oath","pea","eat","rain"}));
		
	}

	public List<String> findWords(char[][] board, String[] words) {

		List<String> resp = new ArrayList<>();
		
		Trie trie = buildTrie(words);
		
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				dfs(board, trie, i, j, resp);
			}
		}
		return resp;

	}

	private void dfs(char[][] board, Trie trie, int i, int j,List<String> resp) {

		char boardChar = board[i][j];
		if (boardChar == '#' || null == trie.next[boardChar - 'a'])
			return;

		// reached here means it has a valid char

		trie = trie.next[boardChar - 'a'];
		
		if(trie.word!=null) {
			resp.add(trie.word);
			trie.word = null;
			
		}
		board[i][j]='#';
		
		if(i>0) dfs(board, trie, i-1, j, resp);
		if(i<board.length-1) dfs(board,trie,i+1,j,resp);
		
		if(j>0) dfs(board, trie, i, j-1, resp);
		if(j<board[0].length-1) dfs(board,trie,i,j+1,resp);
		
		board[i][j] = boardChar;

	}

	private Trie buildTrie(String[] words) {

		Trie trie = new Trie();
		for (String word : words) {

			Trie t = trie;

			for (char c : word.toCharArray()) {

				int ch = c - 'a';

				if (t.next[ch] == null)// char does not exist
					t.next[ch] = new Trie();
				t = t.next[ch];

			}

			t.word = word;

		}
		
		return trie;

	}

}

class Trie {

	Trie[] next = new Trie[26];
	String word;
}