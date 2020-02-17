package com.general.geeks.misc;

/**
 * 
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.

Example:

Input: 
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]
Output: 
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]
Follow up:

Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
Accepted
106,662
Submissions
240,263
 * 
 * @author skadavath
 *
 */
public class GameOfLife {
	
	//two bit solution
	// represent as [bit2,bit1] -> [currState,nextState]
	
	public void gameOfLife(int[][] board) {
		
		int m=board.length,n=board[0].length;
		
		for(int i=0;i<m;i++) {
			
			for(int j=0;j<n;j++) {
				
				int lives = getLiveNeighbouts(board, i, j);
				if(board[i][j]==1 && lives>=2 && lives<=3) {
					board[i][j] = 3; //make the bits as 11
				}
				
				if(board[i][j]==0 && lives==3) {
					board[i][j] = 2 ;// make the 2nd bit 1 -> 10
				}
				
			}
			
		}
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				board[i][j]>>=1;
			}
		}

	}

	private int getLiveNeighbouts(int[][] board, int i, int j) {

		int resp = 0;
		for (int x = Math.max(i - 1, 0); x < Math.min(i + 1, board.length - 1); x++) {
			for (int y = Math.max(j - 1, 0); y < Math.min(j + 1, board[0].length); y++) {

				resp += board[x][y] & 1;

			}
		}

		resp -= board[i][j] & 1;
		return resp;
	}

}
