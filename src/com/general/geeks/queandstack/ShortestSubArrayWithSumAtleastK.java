package com.general.geeks.queandstack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * Return the length of the shortest, non-empty, contiguous subarray of A with
 * sum at least K.
 * 
 * If there is no non-empty subarray with sum at least K, return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: A = [1], K = 1 Output: 1 Example 2:
 * 
 * Input: A = [1,2], K = 4 Output: -1 Example 3:
 * 
 * Input: A = [2,-1,2], K = 3 Output: 3
 * 
 * 
 * Note:
 * 
 * 1 <= A.length <= 50000 -10 ^ 5 <= A[i] <= 10 ^ 5 1 <= K <= 10 ^ 9
 * 
 * @author skadavath
 *
 */
public class ShortestSubArrayWithSumAtleastK {

	public static void main(String[] args) {

		System.out.println(new ShortestSubArrayWithSumAtleastK().shortestSubarray(new int[] {1,0,0, 2, -1, 2,3 }, 3));

	}

	public int shortestSubarray(int[] A, int K) {

		int min = Integer.MAX_VALUE;

		int n = A.length;
		int[] B = new int[n + 1];

		for (int i = 0; i < n; i++)
			B[i + 1] = A[i] + B[i];

		Deque<Integer> dequeu = new ArrayDeque<>();

		for (int i = 0; i <=n; i++) {

			while (dequeu.size() > 0 && B[i] - B[dequeu.getFirst()] >= K)
				min = Math.min(min, i - dequeu.pollFirst());

			while (dequeu.size() > 0 && B[i] <= B[dequeu.getLast()])
				dequeu.pollLast();
			dequeu.addLast(i);

		}

		return min;

	}

}
