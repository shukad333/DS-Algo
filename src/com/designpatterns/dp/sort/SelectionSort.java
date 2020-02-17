package com.designpatterns.dp.sort;

import java.util.Arrays;

public class SelectionSort {
	
	public static void main(String[] args) {
	
		int[] arr = {3,2,6,4,9,1};
		SelectionSort sort = new SelectionSort();
		sort.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		
	}
	
	public void sort(int[] arr) {
		
		for(int i=0;i<arr.length;i++) {
			
			int min = i;
			
			for(int j=i+1;j<arr.length;j++) {
				
				if(arr[j]<arr[i])
					min = j;
			}
			
			swap(arr,i,min);
		}
		
	}
	
	private void swap(int[] arr , int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
