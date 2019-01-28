package com.general.geeks.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Note: The length of the given binary array will not exceed 50,000.


 * @author skadavath
 *
 */
public class ContigousArray {
	
	public static void main(String[] args) {
		int[] arr = new int[] {0,0,0,1,1,1,0,1,1,1,1};
		
		System.out.println(new ContigousArray().findMaxLength(arr));
	}

	public int findMaxLength(int[] nums) {
		
		
		int max = 0;
		
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		
		
		int zeros = 0,ones=0;
		
		for(int i=0;i<nums.length;i++) {
			
			if(nums[i]==0)
				zeros++;
			else
				ones++;
			
			if(map.containsKey(zeros-ones)) {
				max = Math.max(max, i - map.get(zeros-ones));
			}
			else
				map.put(zeros-ones, i);
			
		}
		return max;

	}

}
