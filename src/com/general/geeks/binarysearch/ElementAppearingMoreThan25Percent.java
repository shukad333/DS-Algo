package com.general.geeks.binarysearch;

/**
 * 
 * Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more than 25% of the time.

Return that integer.

 

Example 1:

Input: arr = [1,2,2,6,6,6,6,7,10]
Output: 6
 

Constraints:

1 <= arr.length <= 10^4
0 <= arr[i] <= 10^5
 * 
 * @author skadavath
 *
 */
public class ElementAppearingMoreThan25Percent {
	
	public static void main(String[] args) {
		
		System.out.println(new ElementAppearingMoreThan25Percent().findSpecialInteger(new int[] {1,2,2,6,6,6,6,7,10}));
		
	}

	public int findSpecialInteger(int[] arr) {
		
		for(int a : arr) {
			int fo = firstOcuurence(arr, a);
			int lo = lastOcuurence(arr, a);
			if((lo-fo+1)>arr.length/4)
				return a;
				
		}
		return -1;

	}
	
	private int firstOcuurence(int[] arr , int element) {
		
		int start=0,end=arr.length-1;
		
		while(start<end) {
			int middle = (start+end)>>1;
			if(arr[middle]==element && (middle==start || arr[middle-1]!=element)) {
				return middle;
			}
			
			if(arr[middle]<element)
				start=middle+1;
			else
				end=middle;
		}
		return start;
	}
	
private int lastOcuurence(int[] arr , int element) {
		
		int start=0,end=arr.length-1;
		
		while(start<end) {
			int middle = (start+end)>>1;
			if(arr[middle]==element && (middle==end || arr[middle+1]!=element)) {
				return middle;
			}
			
			if(arr[middle]>element)
				end=middle;
			else
				start=middle+1;
				
		}
		return start;
	}

}
