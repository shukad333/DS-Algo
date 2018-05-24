package com.general.geeks.strings;

import java.util.Arrays;
import java.util.Collections;

/**
 * Given two arrays of length m and n with digits 0-9 representing two numbers.
 * Create the maximum number of length k <= m + n from digits of the two. The
 * relative order of the digits from the same array must be preserved. Return an
 * array of the k digits. You should try to optimize your time and space
 * complexity.
 * 
 * Example 1: nums1 = [3, 4, 6, 5] nums2 = [9, 1, 2, 5, 8, 3] k = 5 return [9,
 * 8, 6, 5, 3]
 * 
 * Example 2: nums1 = [6, 7] nums2 = [6, 0, 4] k = 5 return [6, 7, 6, 0, 4]
 * 
 * Example 3: nums1 = [3, 9] nums2 = [8, 9] k = 3 return [9, 8, 9]
 * 
 * @author skadavath
 *
 */
public class CreateMaximumNumberFromTwoArrays {
	
	public static void main(String[] args) {
		int[] resp = new CreateMaximumNumberFromTwoArrays().maxNumber(new int[] {3, 4, 6, 5}, new int[] {9, 1, 2, 5, 8, 3} ,5);
		for(int i : resp) {
			System.out.println(i);
		}
	}

	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
		
		if(nums2.length>nums1.length) {
			return maxNumber(nums2, nums1, k);
		}
		
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		
		
		int c1=nums1.length-1,c2=nums2.length-1;
		int[] resp = new int[k];
		int start = 0;
		while(k>0 && c1>=0 && c2>=0) {
			if(nums1[c1]>nums2[c2]) {
				resp[start] = nums1[c1--];
			}
			else {
				resp[start] = nums2[c2--];
			}
			
			start++;
			k--;
		}
		
		if(k>0) {
			while(k>0) {
				resp[start++] = nums1[c1--];
				k--;
			}
		}
		return resp;
	}

}
