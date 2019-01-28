package com.general.geeks.misc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A sequence X_1, X_2, ..., X_n is fibonacci-like if:
 * 
 * n >= 3 X_i + X_{i+1} = X_{i+2} for all i + 2 <= n Given a strictly increasing
 * array A of positive integers forming a sequence, find the length of the
 * longest fibonacci-like subsequence of A. If one does not exist, return 0.
 * 
 * (Recall that a subsequence is derived from another sequence A by deleting any
 * number of elements (including none) from A, without changing the order of the
 * remaining elements. For example, [3, 5, 8] is a subsequence of [3, 4, 5, 6,
 * 7, 8].)
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [1,2,3,4,5,6,7,8] Output: 5 Explanation: The longest subsequence that
 * is fibonacci-like: [1,2,3,5,8]. Example 2:
 * 
 * Input: [1,3,7,11,12,14,18] Output: 3 Explanation: The longest subsequence
 * that is fibonacci-like: [1,11,12], [3,11,14] or [7,11,18].
 * 
 * @author skadavath
 *
 */
public class LengthOfLongestFibonacciSeries {
	
	public static void main(String[] args) {
		System.out.println(new LengthOfLongestFibonacciSeries().lenLongestFibSubseq(new int[] {1,2,3,4,5,6,7,8}));
	}
	

	public int lenLongestFibSubseq(int[] A) {
		
		Set<Integer> set = new HashSet<>();
		for(int i : A)
			set.add(i);
		
		int maxLen = 0;
		for(int i=0;i<A.length;i++) {
			for(int j=i+1;j<A.length;j++) {
				int left = A[i],right = A[j];
				int count = 2;
				while(set.contains(left+right)) {
					int temp = right;
					right = left+right;
					left = temp;
					count++;
				}
				maxLen = Math.max(maxLen, count);
			}
			
		}
		return maxLen>2?maxLen:0;
	}

//	public int lenLongestFibSubseq(int[] A) {
//		
//		
//		
//		Map<Integer, Integer> map = new HashMap<>();
//		for(int i=0;i<A.length;i++)
//			map.put(A[i], i);
//		
//		int maxLen = 0;
//		
//		for(int i=0;i<A.length;i++) {
//			
//			for(int j=i+1;j<A.length;j++) {
//			int left = i;
//			int right = j;
//			int count = 0;
//			while(right < A.length && map.containsKey(A[left]+A[right])) {
//				count++;
//				int temp = right;
//				right = map.get(A[left] + A[right]);
//				left = temp;
//			}
//			
//			if(count>maxLen) {
//				maxLen = count+2;
//				
//			}
//		}
//			
//		}
//		
//		return maxLen;
//
//	}

}
