package com.general.geeks.array;

public class MergerTwoSortedArrays {
	
	public static void main(String[] args) {
		
		int[] arr1 = {1,4,5,6,7,8,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		int[] arr2 = {2,3,4,5,6,7};
		
		new MergerTwoSortedArrays().merge(arr1,6, arr2, arr2.length);
		for(int i :arr1) {
			System.out.print(i+" ");
		}
		
		/**
		 * Merge the two sorted arrays
		 * 
		 * Iterate backwards and keep putting at the end the greatest
		 */
		
	}
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		
		while(m > 0 && n > 0){
            if(nums1[m-1] > nums2[n-1]){
            	nums1[m+n-1] = nums1[m-1];
                m--;
            }else{
            	nums1[m+n-1] = nums2[n-1];
                n--;
            }
        }
 
        while(n > 0){
        	nums1[m+n-1] = nums2[n-1];
            n--;
        }
	}
	
}
