package com.general.geeks.array.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given an array A of integers, return the length of the longest arithmetic subsequence in A.

Recall that a subsequence of A is a list A[i_1], A[i_2], ..., A[i_k] with 0 <= i_1 < i_2 < ... < i_k <= A.length - 1, and that a sequence B is arithmetic if B[i+1] - B[i] are all the same value (for 0 <= i < B.length - 1).

 

Example 1:

Input: [3,6,9,12]
Output: 4
Explanation: 
The whole array is an arithmetic sequence with steps of length = 3.
Example 2:

Input: [9,4,7,2,10]
Output: 3
Explanation: 
The longest arithmetic subsequence is [4,7,10].
Example 3:

Input: [20,1,15,3,10,5,8]
Output: 4
Explanation: 
The longest arithmetic subsequence is [20,15,10,5].
 

Note:

2 <= A.length <= 2000
0 <= A[i] <= 10000
 * 
 * @author skadavath
 *
 */
public class LongestArithmeticSequence {
	
	public static void main(String[] args) {
		
		System.out.println(new LongestArithmeticSequence().longestArithSeqLength(new int[] {4,7,2,10,4,12,6,7,8,10}));
		
	}

public int longestArithSeqLength(int[] A) {
		
		if(A.length<3)
			return 2;
		Map<Integer, Map<Integer,Integer>> preMap = new HashMap<>();
		Map<Integer, Integer> second = new HashMap<>();
		second.put(A[0], 1);
		preMap.put(0, second);
		
		int resp=1;
		for(int i=1;i<A.length;i++) {
			Map<Integer, Integer> curr = new HashMap<>();
			for(int j=0;j<i;j++) {
				
				int a = A[i] ,b=A[j];
				curr.put(a-b, 2);
				Map<Integer,Integer> p = preMap.get(j);
				if(p.containsKey(a-b)) {
					curr.put(a-b, p.get(a-b)+1);
				}
				
				resp=Math.max(resp, curr.get(a-b));
				
			}
			preMap.put(i, curr);
		}
		return resp;

	}

}
