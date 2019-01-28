package com.general.geeks.misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
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

 * @author skadavath
 *
 */
public class MatchSticksToSquare {

	public boolean makesquare(int[] nums) {
		
		int total = 0;
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i=0;i<nums.length;i++) {
			
			total+=nums[i];
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
			
		}
		
		int sides=0;
		
		Arrays.sort(nums);
		int index = nums.length-1;
		while(sides<4) {
			
			int curr = nums[index];
			
		}
		
		return true;

	}

}
