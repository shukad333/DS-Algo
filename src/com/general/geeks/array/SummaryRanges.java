package com.general.geeks.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given a sorted integer array without duplicates, return the summary of its
 * ranges.
 * 
 * Example 1:
 * 
 * Input: [0,1,2,4,5,7] Output: ["0->2","4->5","7"] Explanation: 0,1,2 form a
 * continuous range; 4,5 form a continuous range. Example 2:
 * 
 * Input: [0,2,3,4,6,8,9] Output: ["0","2->4","6","8->9"] Explanation: 2,3,4
 * form a continuous range; 8,9 form a continuous range.
 * 
 * 
 * @author skadavath
 *
 */
public class SummaryRanges {
	
	public static void main(String[] args) {
		
		System.out.println(new SummaryRanges().summaryRanges(new int[] {0,1,2,4,5,7}));
		
	}

	public List<String> summaryRanges(int[] nums) {

		List<String> resp = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			
			int x = nums[i];
			
			while(i<nums.length-1 && nums[i+1]-1==nums[i])
				i++;
			
			if(nums[i]!=x)
				resp.add(x+"->"+nums[i]);
			else
				resp.add(x+"");

		}

		return resp;

	}

}