package com.general.geeks.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some
 * elements appear twice and others appear once.
 * 
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * 
 * Could you do it without extra space and in O(n) runtime? You may assume the
 * returned list does not count as extra space.
 * 
 * Example:
 * 
 * Input: [4,3,2,7,8,2,3,1]
 * 
 * Output: [5,6]
 * 
 * @author skadavath
 *
 */
public class NumbersThatDisppearedInAnArray {
	
	public static void main(String[] args) {
		List<Integer> resp = new NumbersThatDisppearedInAnArray().findDisappearedNumbers(new int[] {4,3,2,7,8,2,3,1});
		resp.forEach(i->System.out.println(i));
	}

	public List<Integer> findDisappearedNumbers(int[] nums) {
		
		List<Integer> resp = new ArrayList<>();
		for(int i=0;i<nums.length;i++) {
			int val = Math.abs(nums[i])-1;
			nums[val]=nums[val]>0?-nums[val]:nums[val];
		}
		for(int i=0;i<nums.length;i++) {
			if(nums[i]>0) 
				resp.add(i+1);
		}
		
		return resp;

	}

}
