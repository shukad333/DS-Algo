package com.general.geeks.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a sorted array, two integers k and x, find the k closest elements to x
 * in the array. The result should also be sorted in ascending order. If there
 * is a tie, the smaller elements are always preferred.
 * 
 * Example 1: Input: [1,2,3,4,5], k=4, x=3 Output: [1,2,3,4] Example 2: Input:
 * [1,2,3,4,5], k=4, x=-1 Output: [1,2,3,4] Note: The value k is positive and
 * will always be smaller than the length of the sorted array. Length of the
 * given array is positive and will not exceed 104 Absolute value of elements in
 * the array and x will not exceed 104
 * 
 * @author skadavath
 *
 */
public class KClosestElement {
	
	public static void main(String[] args) {
		System.out.println(new KClosestElement().findClosestElements(new int[] {1, 2,3,4,5},4,3));
	}

	public List<Integer> findClosestElements(int[] arr, int k, int x) {

		List<Integer> resp = new ArrayList<>();
		
		int crossOver = getCrossOver(arr, x);
		if(crossOver<0)crossOver = -(crossOver+1);
		int i = crossOver-1,j=crossOver;
		while(k-->0) {
			
			if(i<0 || (j<arr.length && Math.abs(arr[j]-x)<Math.abs(arr[i]-x)))
				resp.add(arr[j++]);
			else
				resp.add(arr[i--]);
				
				
		}
		
		Collections.sort(resp);
		return resp;
	}

	private int getCrossOver(int[] arr, int x) {
		
		return Arrays.binarySearch(arr, x);
		
//		int low = 0, high = arr.length - 1;
//		if (arr[low] > x)
//			return low;
//		if (arr[high] < x)
//			return high;
//		while (low < high) {
//			int mid = low + (high - low) / 2;
//			if (arr[mid] == x || (mid-1>=0 && mid+1<arr.length && arr[mid]<=x && arr[mid+1]>x))
//				return mid;
//			else if (arr[mid] < x)
//				low = mid + 1;
//			else
//				high = mid;
//		}
//		return -(low+1);
	}

}
