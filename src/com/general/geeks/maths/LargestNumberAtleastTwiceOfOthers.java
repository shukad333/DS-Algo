package com.general.geeks.maths;

/**
 * In a given integer array nums, there is always exactly one largest element.
 * 
 * Find whether the largest element in the array is at least twice as much as
 * every other number in the array.
 * 
 * If it is, return the index of the largest element, otherwise return -1.
 * 
 * Example 1:
 * 
 * Input: nums = [3, 6, 1, 0] Output: 1 Explanation: 6 is the largest integer,
 * and for every other number in the array x, 6 is more than twice as big as x.
 * The index of value 6 is 1, so we return 1.
 * 
 * 
 * Example 2:
 * 
 * Input: nums = [1, 2, 3, 4] Output: -1 Explanation: 4 isn't at least as big as
 * twice the value of 3, so we return -1.
 * 
 * 
 * 
 * @author skadavath
 *
 */
public class LargestNumberAtleastTwiceOfOthers {
	
	public static void main(String[] args) {
		
		System.out.println(new LargestNumberAtleastTwiceOfOthers().dominantIndex(new int[] {3,6,1,0}));
	}

	public int dominantIndex(int[] nums) {
		
		int largest = Integer.MIN_VALUE+1;
		int secondLargest = Integer.MIN_VALUE;
		int currentDoubleLargest = Integer.MIN_VALUE;
		int index = 0;
		for(int i=0;i<nums.length;i++) {
			
			
			if(nums[i]>largest) {
				secondLargest = largest;
				largest = nums[i];
				index = i;
		}
			else if(nums[i]!=largest && nums[i]>secondLargest) {
				secondLargest = nums[i];
			}
			
			
	}
		return largest>=secondLargest*2?index : -1;
	}

}
