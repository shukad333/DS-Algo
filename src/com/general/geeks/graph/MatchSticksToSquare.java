package com.general.geeks.graph;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 
 * Remember the story of Little Match Girl? By now, you know exactly what matchsticks the little match girl has, please find out a way you can make one square by using up all those matchsticks. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.

Your input will be several matchsticks the girl has, represented with their stick length. Your output will either be true or false, to represent whether you could make one square using all the matchsticks the little match girl has.

Example 1:
Input: [1,1,2,2,2]
Output: true

Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
Example 2:
Input: [3,3,3,3,4]
Output: false

Explanation: You cannot find a way to form a square with all the matchsticks.
Note:
The length sum of the given matchsticks is in the range of 0 to 10^9.
The length of the given matchstick array will not exceed 15.
 * 
 * @author skadavath
 *
 */
public class MatchSticksToSquare {
	
	public static void main(String[] args) {
		
		System.out.println(new MatchSticksToSquare().makesquare(new int[] {1,1,2,2,2}));
		
	}

	public boolean makesquare(int[] nums) {
		
		int sum = 0;
		for(int i : nums)
			sum+=i;
		
		if(sum%4!=0)
			return false;
		
//		Comparator<Integer> comp = new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				return o1.compareTo(o2);
//			}
//			
//		};
//		
//		Arrays.sort(nums, comp);
		
		return dfs(nums, new int[4], 0, sum/4);

	}
	
	private boolean dfs(int[] nums,int[] sum,int index,int target) {
		
		if(index==nums.length) {
			return sum[0]==target && sum[1]==target && sum[2]==target;

				
		}
		
		for(int i=0;i<4;i++) {
			
			if(sum[i]+nums[index]>target) continue;
			sum[i] += nums[index];
			if(dfs(nums, sum, index+1, target))return true;
			sum[i] -= nums[index];
			
		}
		
		return false;
	}

}
