package com.general.geeks.tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given an array of unique integers, each integer is strictly greater than 1.

We make a binary tree using these integers and each number may be used for any number of times.

Each non-leaf node's value should be equal to the product of the values of it's children.

How many binary trees can we make?  Return the answer modulo 10 ** 9 + 7.

Example 1:

Input: A = [2, 4]
Output: 3
Explanation: We can make these trees: [2], [4], [4, 2, 2]
Example 2:

Input: A = [2, 4, 5, 10]
Output: 7
Explanation: We can make these trees: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
 

Note:

1 <= A.length <= 1000.
2 <= A[i] <= 10 ^ 9.
 * 
 * @author skadavath
 *
 */
public class BinaryTreesWithFactors {
	
	
	public static void main(String[] args) {
		
		System.out.println(new BinaryTreesWithFactors().numFactoredBinaryTrees(new int[] {2,4,5,10}));
		
	}

	public int numFactoredBinaryTrees(int[] A) {
		
		 Arrays.sort(A);
	        Map<Integer, Long> map = new HashMap<>();
	        long count = 1;
	        map.put(A[0], count);
	        for (int i = 1; i < A.length; i++) {
	            count = 1;
	            for (Integer n : map.keySet()) {
	                if (A[i] % n == 0 && map.containsKey(A[i] / n)) {
	                    count += map.get(n) * map.get(A[i] / n);
	                }
	            }
	            map.put(A[i], count);
	        }
	        long sum = 0;
	        for (Integer n : map.keySet()) {
	            sum = (sum + map.get(n)) % ((int) Math.pow(10, 9) + 7) ;
	        }
	        return (int) sum;
	    }        
}
