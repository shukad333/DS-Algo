package com.general.geeks.misc;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.

Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.

Example 1:
Input: [1,3,2,2,5,2,3,7]
Output: 5
Explanation: The longest harmonious subsequence is [3,2,2,2,3].
Note: The length of the input array will not exceed 20,000.


 * @author skadavath
 *
 */
public class LongestHarmoniousSubsequence {
	
	public static void main(String[] args) {
		
		System.out.println(new LongestHarmoniousSubsequence().findLHS(new int[] {1,3,2,2,5,2,3,7}));
		
	}

	public int findLHS(int[] nums) {
		
		Arrays.sort(nums);
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for(int i : nums) {
			map.put(i, map.getOrDefault(i, 0)+1);
		}
		
		int max = 0;
		
		for(int i : map.keySet()) {
			
			if(map.get(i+1)!=null) {
				max = Math.max(max, map.get(i)+map.get(i+1));
			}
			
		}
		return max;

	}

}
