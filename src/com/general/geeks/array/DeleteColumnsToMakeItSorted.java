package com.general.geeks.array;


/**
 * 
 * We are given an array A of N lowercase letter strings, all of the same
 * length.
 * 
 * Now, we may choose any set of deletion indices, and for each string, we
 * delete all the characters in those indices.
 * 
 * For example, if we have a string "abcdef" and deletion indices {0, 2, 3},
 * then the final string after deletion is "bef".
 * 
 * Suppose we chose a set of deletion indices D such that after deletions, each
 * remaining column in A is in non-decreasing sorted order.
 * 
 * Formally, the c-th column is [A[0][c], A[1][c], ..., A[A.length-1][c]]
 * 
 * Return the minimum possible value of D.length.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: ["cba","daf","ghi"] Output: 1 Example 2:
 * 
 * Input: ["a","b"] Output: 0 Example 3:
 * 
 * Input: ["zyx","wvu","tsr"] Output: 3
 * 
 * 
 * Note:
 * 
 * 1 <= A.length <= 100 1 <= A[i].length <= 1000
 * 
 * @author skadavath
 *
 */
public class DeleteColumnsToMakeItSorted {

	public static void main(String[] args) {

		System.out.println(new DeleteColumnsToMakeItSorted().minDeletionSize(new String[] { "zyx", "wvu", "tsr" }));

	}

	public int minDeletionSize(String[] A) {

		int resp = 0;
		for (int i = 0; i < A[0].length(); i++) {

			for (int j = 0; j < A.length-1; j++) {

				if (A[j].charAt(i) > A[j + 1].charAt(i)) {
					resp++;
					break;
				}
			}
		}
		return resp;

	}

}
