package com.general.geeks.misc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * The set S originally contains numbers from 1 to n. But unfortunately, due to
 * the data error, one of the numbers in the set got duplicated to another
 * number in the set, which results in repetition of one number and loss of
 * another number.
 * 
 * Given an array nums representing the data status of this set after the error.
 * Your task is to firstly find the number occurs twice and then find the number
 * that is missing. Return them in the form of an array.
 * 
 * Example 1: Input: nums = [1,2,2,4] Output: [2,3] Note: The given array size
 * will in the range [2, 10000]. The given array's numbers won't have any order.
 * 
 * @author skadavath
 *
 */
public class SetMismatch {
	
	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(new SetMismatch().findErrorNums(new int[] {2,2})));
	}

	public int[] findErrorNums(int[] nums) {
		
		int[] resp = new int[2];
		Set<Integer> set = new HashSet<>();
		long sum = nums.length * (nums.length+1)/2;
		for(int i=0;i<nums.length;i++) {
			if(set.contains(nums[i]))
				resp[0] = nums[i];
			
			set.add(nums[i]);
			sum-=nums[i];
			
		}
		resp[1] = (int)sum+resp[0];
		return resp;
	}

}
