package com.general.geeks.misc;

import java.util.Arrays;

/**
 * 
 * Given two arrays of length m and n with digits 0-9 representing two numbers. Create the maximum number of length k <= m + n from digits of the two. The relative order of the digits from the same array must be preserved. Return an array of the k digits.

Note: You should try to optimize your time and space complexity.

Example 1:

Input:
nums1 = [3, 4, 6, 5]
nums2 = [9, 1, 2, 5, 8, 3]
k = 5
Output:
[9, 8, 6, 5, 3]
Example 2:

Input:
nums1 = [6, 7]
nums2 = [6, 0, 4]
k = 5
Output:
[6, 7, 6, 0, 4]
Example 3:

Input:
nums1 = [3, 9]
nums2 = [8, 9]
k = 3
Output:
[9, 8, 9]

 * 
 * @author skadavath
 *
 */
public class CreatingMaxNumber {
	
	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(new CreatingMaxNumber().maxNumber(new int[] {6,7},new int[] {6,0,4}, 5)));
		
	}

	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
		
		int m=nums1.length;
		int n=nums2.length;
		int[] ans = new int[k];
		for(int i=Math.max(0, k-n);i<=k && i<=m;i++) {
			int[] candidate = merge(greatestNumber(nums1,i), greatestNumber(nums2,k-i), k);
			if (greater(candidate, 0, ans, 0)) ans = candidate;
		}
		
		return ans;

	}
	
	private int[] merge(int[] nums1, int[] nums2, int k) {
	    int[] ans = new int[k];
	    for (int i = 0, j = 0, r = 0; r < k; ++r)
	        ans[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
	    return ans;
	}
	
	private boolean greater(int[] nums1,int i,int[] nums2,int j) {
		while(i<nums1.length && j<nums2.length && nums1[i]==nums2[j]) {
			i++;
			j++;
		}
		
		return (j==nums2.length || (i<nums1.length && nums1[i]>nums2[j]));
	}
	
	private int[] greatestNumber(int[] nums,int k) {
		
		int n=nums.length;
		int[] resp = new int[k];
		
		for(int i=0,j=0;i<n;i++) {
			while(n-i+j>k && j>0 && resp[j-1]<nums[i]) j--;
			if(j<k) resp[j++] = nums[i];
		}
		return resp;
		
	}

}
