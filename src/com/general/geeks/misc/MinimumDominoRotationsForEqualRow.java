package com.general.geeks.misc;

/**
 * 
 * In a row of dominoes, A[i] and B[i] represent the top and bottom halves of
 * the i-th domino. (A domino is a tile with two numbers from 1 to 6 - one on
 * each half of the tile.)
 * 
 * We may rotate the i-th domino, so that A[i] and B[i] swap values.
 * 
 * Return the minimum number of rotations so that all the values in A are the
 * same, or all the values in B are the same.
 * 
 * If it cannot be done, return -1
 * 
 * Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2] Output: 2 Explanation: The first
 * figure represents the dominoes as given by A and B: before we do any
 * rotations. If we rotate the second and fourth dominoes, we can make every
 * value in the top row equal to 2, as indicated by the second figure. Example
 * 2:
 * 
 * Input: A = [3,5,1,2,3], B = [3,6,3,3,4] Output: -1 Explanation: In this case,
 * it is not possible to rotate the dominoes to make one row of values equal.
 * 
 * 
 * Note:
 * 
 * 1 <= A[i], B[i] <= 6 2 <= A.length == B.length <= 20000
 * 
 * @author skadavath
 *
 */
public class MinimumDominoRotationsForEqualRow {
	
	
	public static void main(String[] args) {
		
		System.out.println(new MinimumDominoRotationsForEqualRow().minDominoRotations(new int[] {2, 1,2,4,2,2},new int[] {5,2,6,2,3,2}));
		
	}

	public int minDominoRotations(int[] A, int[] B) {

		int i = 0;
		int aCount = 0, bCount = 0;
		for (i = 0; i < A.length && (A[i] == A[0] || B[i] == A[0]); i++) {

			if (A[i] != A[0])
				aCount++;
			if (B[i] != A[0])
				bCount++;
			if (i == A.length - 1)
				return Math.min(aCount, bCount);

		}

		aCount=0;
        bCount=0;
		for (i = 0; i < A.length && (A[i] == B[0] || B[i] == B[0]); i++) {

			if (A[i] != B[0])
				aCount++;
			if (B[i] != B[0])
				bCount++;
			if (i == A.length - 1)
				return Math.min(aCount, bCount);

		}
		
		return -1;

	}

}
