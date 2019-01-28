package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space
 * respectively.
 * 
 * @author skadavath
 *
 */
public class NQueenProblem {

	 public List<List<String>> solveNQueens(int n) {
		
		char[][] board = new char[n][n];
		
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board.length;j++) {
				board[i][j]='.';
			}
		}
		
		
		
		List<List<String>> resp = new ArrayList<>();
		solveUtil(board, 0,resp);
		return resp;

	}

	private void solveUtil(char[][] board, int col,List<List<String>> resp) {

		if (col >= board.length) {
			addToList(resp, board);
			return;
		}

		for (int i = 0; i < board.length; i++) {
			
			if(isSafe(board, i, col)) {
				board[i][col] = 'Q';
				solveUtil(board, col+1,resp);
				board[i][col] = '.';
			}

		}

	}
	
	private void addToList(List<List<String>> resp , char[][] board) {
		
		List<String> temp = new ArrayList<>();
		for(int i=0;i<board.length;i++) {
			temp.add(new String(board[i]));
			
		}
		resp.add(temp);
	}

	private boolean isSafe(char[][] board, int row, int col) {

		for (int i = 0; i < col; i++) {
			if (board[row][i] == 'Q')
				return false;

		}
		
		//upper left diagonal
		for (int i = row,j=col; i>=0&&j>=0; i--,j--) {
			
			if(board[i][j]=='Q')
				return false;

		}
		
		
		//lower left diagonal
		for(int i=row,j=col;i<board.length && j>=0;i++,j--) {
			if(board[i][j]=='Q')
				return false;
		}
		
		return true;
	}

}
