package com.general.geeks.strings;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order, we get the
 * following sequence for n = 3:
 * 
 * "123" "132" "213" "231" "312" "321" Given n and k, return the kth permutation
 * sequence.
 * 
 * Note:
 * 
 * Given n will be between 1 and 9 inclusive. Given k will be between 1 and n!
 * inclusive. Example 1:
 * 
 * Input: n = 3, k = 3 Output: "213" Example 2:
 * 
 * Input: n = 4, k = 9 Output: "2314"
 * 
 * @author skadavath
 *
 */
public class PermutationSequence {

	public static void main(String[] args) {

		System.out.println(new PermutationSequence().getPermutation(4, 9));

	}

	/**
	 * 
	 * Recursion will use more memory, while this problem can be solved by
	 * iteration. I solved this problem before, but I didn't realize that using k =
	 * k-1 would avoid dealing with case k%(n-1)!==0. Rewrote this code, should be
	 * pretty concise now.
	 * 
	 * Only thing is that I have to use a list to store the remaining numbers,
	 * neither linkedlist nor arraylist are very efficient, anyone has a better
	 * idea?
	 * 
	 * The logic is as follows: for n numbers the permutations can be divided to
	 * (n-1)! groups, for n-1 numbers can be divided to (n-2)! groups, and so on.
	 * Thus k/(n-1)! indicates the index of current number, and k%(n-1)! denotes
	 * remaining index for the remaining n-1 numbers. We keep doing this until n
	 * reaches 0, then we get n numbers permutations that is kth.
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	public String getPermutation(int n, int k) {

		List<Integer> num = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++)
			num.add(i);
		int[] fact = new int[n]; // factorial
		fact[0] = 1;
		for (int i = 1; i < n; i++)
			fact[i] = i * fact[i - 1];
		k = k - 1;
		StringBuilder sb = new StringBuilder();
		for (int i = n; i > 0; i--) {
			int ind = k / fact[i - 1];
			k = k % fact[i - 1];
			sb.append(num.get(ind));
			num.remove(ind);
		}
		return sb.toString();

	}

}
