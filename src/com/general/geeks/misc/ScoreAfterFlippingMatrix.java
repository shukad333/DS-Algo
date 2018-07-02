package com.general.geeks.misc;

/**
 * We have a two dimensional matrix A where each value is 0 or 1.
 * 
 * A move consists of choosing any row or column, and toggling each value in
 * that row or column: changing all 0s to 1s, and all 1s to 0s.
 * 
 * After making any number of moves, every row of this matrix is interpreted as
 * a binary number, and the score of the matrix is the sum of these numbers.
 * 
 * Return the highest possible score.
 * 
 * 
 * @author skadavath
 *
 */
public class ScoreAfterFlippingMatrix {
	
	public static void main(String[] args) {
		int[][] A = new int[][]{{0,1},{0,1},{0,1},{0,0}};
		System.out.println(new ScoreAfterFlippingMatrix().matrixScore(A));
		
	}

	public int matrixScore(int[][] A) {

		int r = A.length;
		int c = A[0].length;

		for (int i = 0; i < r; i++) {
			if (A[i][0] == 0)
				flipRow(A, i);
		}

		for (int i = 1; i < c; i++) {
			int totZeros = 0;
			for (int j = 0; j < r; j++) {
				totZeros += A[j][i];
			}
			if (totZeros * 2 < r)
				flipColum(A, i);
		}

		// sum
		int sum = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				sum += A[i][j] * (1<<c-j-1);
			}
		}
		return sum;
	}

	private void flipRow(int[][] A, int r) {
		for (int i = 0; i < A[0].length; i++) {
			A[r][i] = A[r][i] ^ 1;
		}
	}

	private void flipColum(int[][] A, int c) {
		for (int i = 0; i < A.length; i++) {
			A[i][c] = A[i][c] ^ 1;
		}
	}

}
