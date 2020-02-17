package com.general.geeks.array.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of unique integers, each integer is strictly greater than 1.
 * 
 * We make a binary tree using these integers and each number may be used for
 * any number of times.
 * 
 * Each non-leaf node's value should be equal to the product of the values of
 * it's children.
 * 
 * How many binary trees can we make? Return the answer modulo 10 ** 9 + 7.
 * 
 * Example 1:
 * 
 * Input: A = [2, 4] Output: 3 Explanation: We can make these trees: [2], [4],
 * [4, 2, 2] Example 2:
 * 
 * Input: A = [2, 4, 5, 10] Output: 7 Explanation: We can make these trees: [2],
 * [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
 * 
 * @author skadavath
 *
 */
public class BinaryTreeWithFactors {
	
	public static void main(String[] args) {
		
		System.out.println(new BinaryTreeWithFactors().numFactoredBinarydps(new int[] {2,4,10,20}));
		Map<Integer, Integer> map = new HashMap<>();
		
	}

	public int numFactoredBinarydps(int[] A) {
        long res = 0L, mod = (long) Math.pow(10, 9) + 7;
        Arrays.sort(A);
        HashMap<Integer, Long> dp = new HashMap<>();
        for (int i = 0; i < A.length; ++i) {
            dp.put(A[i], 1L);
            for (int j = 0; j < i; ++j)
                if (A[i] % A[j] == 0 && dp.containsKey(A[i] / A[j]))
                    dp.put(A[i], (dp.get(A[i]) + dp.get(A[j]) * dp.get(A[i] / A[j])) % mod);
        }
        for (long v : dp.values()) res = (res + v) % mod;
        return (int) res;
    }
}
