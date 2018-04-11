package com.general.geeks.array;

/*
 * 
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement {
	
	public static void main(String[] args) {
		
		int[] nums = {1};
		System.out.println(new MajorityElement().majorityElement(nums));
	}

	public int majorityElement(int[] nums) {
		int count=1,majorityElement=nums[0];
		for(int i=1;i<nums.length;i++) {
			if(count==0) {
				majorityElement = nums[i];
			}
			if(nums[i]==majorityElement)
				count++;
			else
				count--;
			
		}
			count =0;
			for(int i=0;i<nums.length;i++) {
				if(majorityElement==nums[i]) {
					count++;
				}
			}
			if(count>nums.length/2) {
				return majorityElement;
			}
		
		return -1;

	}

}
