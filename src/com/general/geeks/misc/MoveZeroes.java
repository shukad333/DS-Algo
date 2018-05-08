package com.general.geeks.misc;

/**
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums
 * should be [1, 3, 12, 0, 0].
 * 
 * Note: You must do this in-place without making a copy of the array. Minimize
 * the total number of operations.
 * 
 * @author skadavath
 *
 */
public class MoveZeroes {
	
	public static void main(String[] args) {
		
		int[] nums = {0, 1, 0, 3, 12};
		new MoveZeroes().moveZeroes(nums);
		for(int i : nums) {
			System.out.print(i+" ");
		}
		
	}

	public void moveZeroes(int[] nums) {
		
		int start = 0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]!=0) {
				nums[start] = nums[i];
				start++;
			}
		}
		
		for(int i=start;i<nums.length;i++) {
			
			nums[i] = 0;
		}
	}
}
