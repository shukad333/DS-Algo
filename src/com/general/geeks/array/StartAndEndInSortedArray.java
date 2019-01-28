package com.general.geeks.array;


/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

 * @author skadavath
 *
 */
public class StartAndEndInSortedArray {
	
	//arr = {1,2,4,5,5,5,6,6,7}
	public static void main(String[] args) {
		
		StartAndEndInSortedArray s = new StartAndEndInSortedArray();
		
		int[] arr = new  int[] {1, 2,4,5,5,5,6,6,7,8,9};
		//int[] arr = new  int[] {1, 1,1,1,1};
		//System.out.println(s.getStartAndEnd(arr,5)[0]+" " +s.getStartAndEnd(arr,5)[1]);
	}
	
	 public int[] searchRange(int[] nums, int target) {
	        
	    
		
		if(nums==null || nums.length==0) 
			return new int[] {-1,-1};
		return getStartAndEndUsingBS(nums, target);
	}
	
	private int[] getStartAndEndUsingBS(int[] arr , int target) {
		
		int low = 0;
		int high = arr.length-1;
		
		while(low<high) {
			int mid = low + (high-low)/2;//>>1
			if(arr[mid]<target) {
				low = mid+1;
			}
			else
				high = mid;
		}
		
		
		if(arr[low]!=target)
			return new int[] {-1,-1};
		
		int[] resp = new int[2];
		resp[0] = low;
		high = arr.length-1;
		
		while(low<high) {
			int mid = 1+low + (high-low)/2;
			if(arr[mid]>target) {
				high = mid-1;
			}
			else
				low = mid;
		}
		
		resp[1] = low;
		return resp;
		
		
	}

}
