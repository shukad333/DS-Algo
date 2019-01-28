package com.general.geeks.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;

/**
 * 
 * Given an array A, partition it into two (contiguous) subarrays left and right
 * so that:
 * 
 * Every element in left is less than or equal to every element in right. left
 * and right are non-empty. left has the smallest possible size. Return the
 * length of left after such a partitioning. It is guaranteed that such a
 * partitioning exists.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [5,0,3,8,6] Output: 3 Explanation: left = [5,0,3], right = [8,6]
 * Example 2:
 * 
 * Input: [1,1,1,0,6,12] Output: 4 Explanation: left = [1,1,1,0], right = [6,12]
 * 
 * 
 * Note:
 * 
 * 2 <= A.length <= 30000 0 <= A[i] <= 10^6 It is guaranteed there is at least
 * one way to partition A as described.
 * 
 * @author skadavath
 *
 */
public class PartitionArrayIntoDisjoingIntervals {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>(1);
		
		System.out.println(list.size());
		list.add("Shu");
		list.add("Shus");
		System.out.println(list.size());
		
		Set<String> set = new HashSet<>(); ;
		
		System.out.println(CollectionUtils.isEmpty(set));

		System.out
				.println(new PartitionArrayIntoDisjoingIntervals().partitionDisjoint(new int[] { 1, 1, 1, 0, 6, 12 }));

	}

	public int partitionDisjoint(int[] A) {

		int[] minArray = new int[A.length];
		minArray[minArray.length - 1] = A[A.length - 1];
		int n = A.length;
		for (int i = n - 2; i > 0; i--) {
			minArray[i] = Math.min(A[i], minArray[i + 1]);
		}

		int localMax = Integer.MIN_VALUE;

		for (int i = 1; i < n; i++) {
			localMax = Math.max(localMax, A[i - 1]);
			if (localMax <= minArray[i])
				return i;
		}

		return minArray.length;

	}

}
