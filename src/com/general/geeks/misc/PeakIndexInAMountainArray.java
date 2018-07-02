package com.general.geeks.misc;

/**
 * Let's call an array A a mountain if the following properties hold:
 * 
 * A.length >= 3 There exists some 0 < i < A.length - 1 such that A[0] < A[1] <
 * ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] Given an array that is
 * definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i]
 * > A[i+1] > ... > A[A.length - 1].
 * 
 * Example 1:
 * 
 * Input: [0,1,0] Output: 1 Example 2:
 * 
 * Input: [0,2,1,0] Output: 1
 * 
 * @author skadavath
 *
 */
public class PeakIndexInAMountainArray {

	public static void main(String[] args) {
		
		System.out.println(new PeakIndexInAMountainArray().peakIndexInMountainArray(new int[] {1,2,3,4,5,6,3,1}));
	}
	public int peakIndexInMountainArray(int[] A) {
		
		int h = A.length-1;
		int l = 0;
		while(h>l) {
			
			int mid = (l+h)/2;
			if(A[mid]>A[mid-1] && A[mid]>A[mid+1])
				return mid;
			else if(A[mid]>A[mid-1]) {
				l=mid;
			}
			else
				h=mid;
		}
		
		return -1;
	}

}
