package com.designpatterns.dp.sort;

import java.util.Arrays;

public class InsertionSort {
	
	public static void main(String[] args) {
		
		int[] arr = {3,2,6,4,9,1};
		InsertionSort sort = new InsertionSort();
		sort.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		
	}
	
	public void sort(int[] arr) {
		
		for(int i=1;i<arr.length;i++) {
			
			int j=i-1;
			int curr = arr[i];
			while(j>=0 && arr[j]>curr) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = curr;
		}
		
	}

}
