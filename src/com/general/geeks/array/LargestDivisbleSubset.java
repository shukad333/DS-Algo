package com.general.geeks.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given a set of distinct positive integers, find the largest subset such that
 * every pair (Si, Sj) of elements in this subset satisfies:
 * 
 * Si % Sj = 0 or Sj % Si = 0.
 * 
 * If there are multiple solutions, return any subset is fine.
 * 
 * Example 1:
 * 
 * Input: [1,2,3] Output: [1,2] (of course, [1,3] will also be ok) Example 2:
 * 
 * Input: [1,2,4,8] Output: [1,2,4,8]
 * 
 * @author skadavath
 *
 */
public class LargestDivisbleSubset {
	
	public static void main(String[] args) {
		
		System.out.println(new LargestDivisbleSubset().largestDivisibleSubset(new int[] {1,2,3,4,5,8,12,30,87,93,99,6}));
		
	}

	public List<Integer> largestDivisibleSubset(int[] nums) {

		int[] lis = new int[nums.length];
		int[] preIndex = new int[nums.length];
		int max = 0, endIndex = -1;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {

			lis[i] = 1;
			preIndex[i] = -1;
			for (int j = 0; j < i; j++) {

				if (nums[i] % nums[j] == 0) {

					if (lis[j] + 1 > lis[i]) {
						lis[i] = lis[j] + 1;
						preIndex[i] = j;
					}

				}

			}

			if (lis[i] > max) {
				max = lis[i];
				endIndex = i;

			}
		}
		
		List<Integer> resp = new ArrayList<>();
		while(endIndex!=-1) {
			
			resp.add(nums[endIndex]);
			endIndex = preIndex[endIndex];
			
		}

		return resp;

	}

}
