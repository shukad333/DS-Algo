package com.general.geeks.misc;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be
 * validated according to the following rules:
 * 
 * Each row must contain the digits 1-9 without repetition. Each column must
 * contain the digits 1-9 without repetition. Each of the 9 3x3 sub-boxes of the
 * grid must contain the digits 1-9 without repetition.
 * 
 * 
 * 
 * @author skadavath
 *
 */
public class ValidSudoko {

	public boolean isValidSudoku(char[][] board) {
		
		for(int i=0;i<9;i++) {
			
			Set<Character> rows = new HashSet<>();
			Set<Character> columns = new HashSet<>();
			Set<Character> box = new HashSet<>();
			
			for(int j=0;j<9;j++) {
				
				if(board[i][j]!='.' && !columns.add(board[i][j]))
					return false;
				
				if(board[j][i]!='.' && !rows.add(board[j][j]))
					return false;
				
				int squareRow = 3*(i/3);
				int squareCol = 3*(i%3);
				
				if(board[j/3+squareRow][j%3+squareCol]!='.' && !box.add(board[j/3+squareRow][j%3+squareCol]))
					return false;
				
				
			}
			
		}
		
		return true;

	}

}
