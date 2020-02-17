package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given an array A of non-negative integers, the array is squareful if for every pair of adjacent elements, their sum is a perfect square.

Return the number of permutations of A that are squareful.  Two permutations A1 and A2 differ if and only if there is some index i such that A1[i] != A2[i].

 

Example 1:

Input: [1,17,8]
Output: 2
Explanation: 
[1,8,17] and [17,8,1] are the valid permutations.
Example 2:

Input: [2,2,2]
Output: 1
 * 
 * @author skadavath
 *
 */
public class NumberOfSquarefulArrays {
	
	public static void main(String[] args) {
		
		System.out.println(new NumberOfSquarefulArrays().numSquarefulPerms(new int[] {1,17,8}));
		
	}

	public int numSquarefulPerms(int[] A) {
		
		Arrays.sort(A);
		permute(new ArrayList<>(), A, -1, new boolean[A.length]);
		return count;

	}
	
	private int count = 0;

	private void permute(List<Integer> temp, int[] A, int lastNo, boolean[] visited) {

		if (temp.size() == A.length) {

			count++;

		} else {

			for (int i = 0; i < A.length; i++) {

				// in case of duplicates , make sure use together
				if (visited[i] || (i > 0 && A[i - 1] == A[i] && !visited[i - 1]))
					continue;

				if (lastNo != -1) {
					if (!isSquare(A[i], lastNo)) {
						continue;
					}
				}

					visited[i] = true;
					temp.add(A[i]);
					permute(temp, A, A[i], visited);
					temp.remove(temp.size() - 1);
					visited[i] = false;

				

			}
		}
	}

	private boolean isSquare(int a, int b) {
		double sqrt = Math.sqrt(a + b);

		return sqrt == Math.floor(sqrt);
	}

}
