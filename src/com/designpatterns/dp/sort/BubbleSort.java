package com.designpatterns.dp.sort;

import java.util.Arrays;

public class BubbleSort {
	
	public static void main(String[] args) {
		
		int[] arr = {3,2,6,4,9,1};
		BubbleSort sort = new BubbleSort();
		sort.bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
	
	private void bubbleSort(int[] arr) {
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j]>arr[j+1])
					swap(arr,j,j+1);
			}
		}
	}
	
	private void swap(int[] arr , int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
