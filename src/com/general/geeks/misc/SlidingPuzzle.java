package com.general.geeks.misc;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * On a 2x3 board, there are 5 tiles represented by the integers 1 through 5,
 * and an empty square represented by 0.
 * 
 * A move consists of choosing 0 and a 4-directionally adjacent number and
 * swapping it.
 * 
 * The state of the board is solved if and only if the board is
 * [[1,2,3],[4,5,0]].
 * 
 * Given a puzzle board, return the least number of moves required so that the
 * state of the board is solved. If it is impossible for the state of the board
 * to be solved, return -1.
 * 
 * Examples:
 * 
 * Input: board = [[1,2,3],[4,0,5]] Output: 1 Explanation: Swap the 0 and the 5
 * in one move. Input: board = [[1,2,3],[5,4,0]] Output: -1 Explanation: No
 * number of moves will make the board solved. Input: board = [[4,1,2],[5,0,3]]
 * Output: 5 Explanation: 5 is the smallest number of moves that solves the
 * board. An example path: After move 0: [[4,1,2],[5,0,3]] After move 1:
 * [[4,1,2],[0,5,3]] After move 2: [[0,1,2],[4,5,3]] After move 3:
 * [[1,0,2],[4,5,3]] After move 4: [[1,2,0],[4,5,3]] After move 5:
 * [[1,2,3],[4,5,0]] Input: board = [[3,2,4],[1,5,0]] Output: 14
 * 
 * @author skadavath
 *
 */
public class SlidingPuzzle {

	public static void main(String[] args) {

		int[][] board = new int[][] { { 1, 2, 3 }, { 5, 4, 0 } };
		System.out.println(new SlidingPuzzle().slidingPuzzle(board));
	}

	public int slidingPuzzle(int[][] board) {

		StringBuilder boardBuilder = new StringBuilder();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				boardBuilder.append(board[i][j]);
			}
		}
		String boardStr = boardBuilder.toString();

		int[] moves = { -1, 1, -3, 3 };

		Queue<String> queue = new LinkedList<>();
		Set<String> visited = new HashSet<>();
		queue.offer(boardStr);
		visited.add(boardStr);
		int count = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int j = 0; j < size; j++) {
				String current = queue.poll();
				if (current.equals("123450"))
					return count;

				
				int zeroIndex = current.indexOf('0');
				for (int i = 0; i < moves.length; i++) {
					int move = moves[i] + zeroIndex;
					if (move < 0 || move > 5 || zeroIndex == 2 && move == 3 || zeroIndex == 3 && move == 2) {
						continue;
					}
					char[] boardChar = current.toCharArray();
					swap(boardChar, zeroIndex,  move);

					String swapped = String.valueOf(boardChar);
					if (!visited.contains(swapped)) {
						visited.add(swapped);
						queue.offer(swapped);
					}
				}

			}
			count++;
		}

		return -1;

	}

	private void swap(char[] c, int a, int b) {

		char temp = c[a];
		c[a] = c[b];
		c[b] = temp;

	}

}
