package com.general.geeks.misc;

/**
 * Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3
Example 2:

Input: [3,4,-1,1]
Output: 2
Example 3:

Input: [7,8,9,11,12]
Output: 1
Note:

Your algorithm should run in O(n) time and uses constant extra space.
 * @author skadavath
 *
 */
public class FirstMissingPositive {
	
	public static void main(String[] args) {
		
		System.out.println(new FirstMissingPositive().firstMissingPositive(new int[] {7,8,2,1,5}));
		
	}

	public int firstMissingPositive(int[] nums) {
		
		//iterate and swap and put numbers in the correct place
		
		int i=0;
		
		while(i<nums.length) {
			if(nums[i]==i+1 || nums[i]<0 || nums[i]>nums.length)i++;
			else if(nums[i]>0 && nums[nums[i]-1]!=nums[i]) {
				swap(nums, nums[i]-1, i);
			}
			else i++;
		}
		
		i=0;
		while(i<nums.length && nums[i]==i+1)
			i++;
		
		return i+1;

	}
	
	private void swap(int[] nums , int a , int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}

}
