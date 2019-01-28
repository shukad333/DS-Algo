package com.general.geeks.bits;

import java.util.Arrays;

/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤
 * i ≤ num calculate the number of 1's in their binary representation and return
 * them as an array.
 * 
 * Example: For num = 5 you should return [0,1,1,2,1,2].
 * 
 * Follow up:
 * 
 * It is very easy to come up with a solution with run time
 * O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a
 * single pass? Space complexity should be O(n). Can you do it like a boss? Do
 * it without using any builtin function like __builtin_popcount in c++ or in
 * any other language.
 * 
 * @author skadavath
 *
 */
public class CountingBits {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new CountingBits().countBits(25)));
	}

	public int[] countBits(int num) {

		int[] res = new int[num + 1];

		// f(i) = f(i/2) + i%2;

		for (int j = 1; j <= num; j++) {
			res[j] = res[j>>1] +  (j&1);
		}

		return res;
	}

}
