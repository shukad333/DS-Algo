package com.general.geeks.misc;

import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.

Note:
A naive algorithm of O(n2) is trivial. You MUST do better than that.

Example:

Input: nums = [-2,5,-1], lower = -2, upper = 2,
Output: 3 
Explanation: The three ranges are : [0,0], [2,2], [0,2] and their respective sums are: -2, -1, 2.
Accepted
30,165
Submissions
93,496
 * 
 * @author skadavath
 *
 */
public class CountOfRangeSum {
	
	public static void main(String[] args) {
		
		System.out.println(new CountOfRangeSum().countRangeSum(new int[] {-2, 5, -1},-2,2));
		
	}

	public int countRangeSum(int[] nums, int lower, int upper) {
		
		long resp = 0;
		
		TreeMap<Long, Long> treeMap = new TreeMap<>();
		treeMap.put(0L,1L);
		
		long sum = 0;
		for(int i=0;i<nums.length;i++) {
			sum+=nums[i];
			long from = sum - upper;
			long to = sum - lower;
			
			Map<Long, Long> subMap = treeMap.subMap(from, true, to, true);
			
			for(Long val : subMap.values())
				resp+=val;
			
			if(treeMap.containsKey(sum)) {
				treeMap.put(sum, treeMap.get(sum)+1);
			}
			else {
				treeMap.put(sum, (long)1);
			}
			
		}
		return (int)resp;

	}

}
