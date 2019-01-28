package com.general.geeks.misc;

/**
 * 
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * 
 * A sudoku solution must satisfy all of the following rules:
 * 
 * Each of the digits 1-9 must occur exactly once in each row. Each of the
 * digits 1-9 must occur exactly once in each column. Each of the the digits 1-9
 * must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * 
 * @author skadavath
 *
 */
public class SudokoSolver {

	public void solveSudoku(char[][] board) {

		if (null == board || board.length == 0)
			return;

		solve(board);

	}

	private boolean solve(char[][] board) {

		for (int i = 0; i < 9; i++) {

			for (int j = 0; j < 9; j++) {

				if (board[i][j] == '.') {
					for (char val = '1'; val <= 9; val++) {

						if (isValid(board, val, i, j))
							board[i][j] = val;

						if (solve(board))
							return true;

						else
							board[i][j] = '.';
					}
				}
				return false;
			}
		}
		return true;
	}

	private boolean isValid(char[][] board, char c, int row, int col) {

		for (int i = 0; i < 9; i++) {
			if (board[row][i] == c)
				return false;
			if (board[i][col] == c)
				return false;

			int sqRow = 3 * (row / 3);
			int sqCol = 3 * (row % 3);

			if (board[i / 3 + sqRow][i % 3 + sqCol] != '.' && board[i / 3 + sqRow][i % 3 + sqCol] != c)
				return false;
		}

		return true;
	}

}
