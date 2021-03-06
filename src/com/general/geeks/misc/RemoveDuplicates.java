package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each
 * element appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * 
 * Example 1:
 * 
 * Given nums = [1,1,2],
 * 
 * Your function should return length = 2, with the first two elements of nums
 * being 1 and 2 respectively.
 * 
 * It doesn't matter what you leave beyond the returned length. Example 2:
 * 
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 * 
 * Your function should return length = 5, with the first five elements of nums
 * being modified to 0, 1, 2, 3, and 4 respectively.
 * 
 * It doesn't matter what values are set beyond the returned length.
 * 
 * @author skadavath
 *
 */
public class RemoveDuplicates {

	public static void main(String[] args) {
			
		int[] nums = {5000,5000,5000};
		System.out.println(new RemoveDuplicates().removeDuplicates(Arrays.asList(5000,5000,5000)));
		for(int i : nums) {
			//System.out.print(i+" ");
		}
		
		
	}
	
	 public int removeDuplicates(List<Integer> a) {
	        
	       
	        int start = 0,index=0;
	        
	        
	        for(int i=1;i<a.size();i++) {
	            
	            if((int)a.get(i)!=(int)a.get(index)) {
	                start++;
	                index = i;
	                a.set(start,a.get(index));
	            }
	           
	        }
	        
	      
	        return start+1;
	    }

	public int removeDuplicates(int[] nums) {

		int start = 0, index = 0;
		for (int i = 1; i < nums.length; i++) {

			if (nums[i] != nums[index]) {

				start++;
				index = i;
				nums[start] = nums[index];

			}

		}
		return start+1;

	}

}
