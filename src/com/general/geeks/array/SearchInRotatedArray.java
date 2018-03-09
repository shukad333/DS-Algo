package com.general.geeks.array;

public class SearchInRotatedArray {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		
	}

	public int search(int[] nums, int target) {
			
		return -1;
	}
	
	
	public int findPivot(int[] arr , int low,int high) {
		
		if(low>high) {
			return -1;
		}
		
		int mid = (low+high)/2;
		
		if(mid<high && arr[mid] > arr[mid+1]) {
			
			return mid;
		}
		
		if(mid>low && arr[mid] < arr[mid+1]) {
			return low;
		}
		
		if(arr[low] > arr[mid])
			return findPivot(arr, low, mid-1);
		return findPivot(arr,mid+1,high);
		
	}
}
