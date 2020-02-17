package com.designpatterns.dp.sort;

import java.util.Arrays;

/**
 * 
 * 
 * 
 * @author skadavath
 *
 */
public class QuickSort {
	
	public static void main(String[] args) {
		

		int[] arr = new int[] {4,3,7,6,0,1};
		//System.out.println(((1+4)>>1));
		new MergeSort().sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public void sort(int[] arr) {
		
		sort(arr, 0, arr.length-1);
		
	}
	
	private void sort(int[] arr , int low,int high) {
		
		if(low<high) {
			int paritionIndex = partition(arr, low, high);
			
			sort(arr,low,paritionIndex-1);
			sort(arr, paritionIndex, high);
			
		}
	}
	
	private int partition(int[] arr,int low,int high) {
		int pivot = arr[high];
		int i = low-1;
		
		for(int j=low;j<high;j++) {
			
			if(arr[j]<pivot) {
				i++;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		int temp = arr[i+1];
		arr[i+1] = pivot;
		arr[high] = temp;
		
		return i+1;
	}

}
