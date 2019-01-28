package com.general.geeks.bits;

/**
 * Given a positive integer n, find the number of non-negative integers less
 * than or equal to n, whose binary representations do NOT contain consecutive
 * ones.
 * 
 * Example 1: Input: 5 Output: 5 Explanation: Here are the non-negative integers
 * <= 5 with their corresponding binary representations: 0 : 0 1 : 1 2 : 10 3 :
 * 11 4 : 100 5 : 101 Among them, only integer 3 disobeys the rule (two
 * consecutive ones) and the other 5 satisfy the rule. Note: 1 <= n <= 109
 * 
 * 
 * @author skadavath
 *
 */
public class NonNegativeIntegerWithoutConsecutiveOnes {

	public static void main(String[] args) {

		System.out.println(new NonNegativeIntegerWithoutConsecutiveOnes().findIntegers(20));

	}

	public int findIntegers(int num) {

		/**
		 * This problem can be solved using Dynamic Programming. Let a[i] be the number
		 * of binary strings of length i which do not contain any two consecutive 1’s
		 * and which end in 0. Similarly, let b[i] be the number of such strings which
		 * end in 1. We can append either 0 or 1 to a string ending in 0, but we can
		 * only append 0 to a string ending in 1. This yields the recurrence relation:
		 */

		StringBuilder sb = new StringBuilder(Integer.toBinaryString(num)).reverse();
		int n = sb.length();
		int[] a = new int[n];
		int[] b = new int[n];

		a[0] = b[0] = 1;
		for (int i = 1; i < n; i++) {
			a[i] = a[i - 1] + b[i - 1];
			b[i] = a[i - 1];
		}
		int resp = a[n - 1] + b[n - 1];

		for (int i = n - 2; i >= 0; i--) {
			if (sb.charAt(i) == '1' && sb.charAt(i + 1) == '1')
				break;
			if (sb.charAt(i) == '0' && sb.charAt(i + 1) == '0')
				resp -= b[i];
		}

		return resp;

	}

}
