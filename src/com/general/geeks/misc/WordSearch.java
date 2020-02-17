package com.general.geeks.misc;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * Example:
 * 
 * board = [ ['A','B','C','E'], ['S','F','C','S'], ['A','D','E','E'] ]
 * 
 * Given word = "ABCCED", return true. Given word = "SEE", return true. Given
 * word = "ABCB", return false.
 * 
 * @author skadavath
 *
 */
public class WordSearch {
	
	public static void main(String[] args) {
		
		char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
		
		int i=0,j=0;
		System.out.println(board[i][j]);
		board[i][j]^=256;
		System.out.println(board[i][j]);
		board[i][j]^=256;
		System.out.println(board[i][j]);
	}

	public boolean exist(char[][] board, String word) {
		
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				if(word.charAt(0)==board[i][j])
					if(exist(board, i, j, word, new boolean[board.length][board[0].length], 0))
						return true;
			}
		}
		return false;

	}
	
	private boolean exist(char[][] board,int i , int j,String word,boolean[][] visited ,int index) {
		
		if(index==word.length())
			return true;
		if(i<0 || i>=board.length || j<0 || j>=board[0].length || visited[i][j] || board[i][j]!=word.charAt(index))
			return false;
		
		
		visited[i][j] = true;
		
		if (exist(board, i, j+1, word, visited, index+1)||
				exist(board, i, j-1, word, visited, index+1) ||
				exist(board, i+1, j, word, visited, index+1) ||
				exist(board, i-1, j, word, visited, index+1))
            return true;
        
        visited[i][j] = false;
        return false;
		
		
	}

}
