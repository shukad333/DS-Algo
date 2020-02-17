package com.designpatterns.dp.sort;

import java.util.Arrays;

public class MergeSort {
	
	public static void main(String[] args) {
		
		int[] arr = new int[] {4,3,7,6,0,1};
		//System.out.println(((1+4)>>1));
		new MergeSort().sort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
	
	public void sort(int[] arr) {
		
		sort(arr, 0, arr.length-1);
	}
	
	private void merge(int low,int mid,int high,int[] arr) {
		
		int l = mid-low+1;
		int r = high-mid;
		
		int[] left = new int[l];
		int[] right = new int[r];
		
		int lc=0,rc=0,oc=low;
		
		for(int i=0;i<l;i++)
			left[i] = arr[low+i];
		
		for(int j=0;j<r;j++)
			right[j] = arr[mid+1+j];
		
		while(lc<l && rc<r) {
			
			if(left[lc]<=right[rc]) {
				arr[oc] = left[lc];
				lc++;
			}
			else {
				arr[oc] = right[rc];
				rc++;
			}
			
			oc++;
			
		}
		
		while(lc<l)
			arr[oc++] = left[lc++];
		
		while(rc<r)
			arr[oc++] = right[rc++];
	}
	
	private void sort(int[] arr,int left,int right) {
		
		if(left<right) {
			
			int mid = (left+right)>>1;
			sort(arr,left,mid);
			sort(arr,mid+1,right);
			merge(left, mid, right, arr);
		}
		
	}

}
