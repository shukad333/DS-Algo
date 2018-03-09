package com.general.geeks.array;

public class RotateArrayByK {
	

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5,6,7};
		
		rotateArr(arr,8);
		for(int i : arr) {
			System.out.print(i+" ");
		}
	}
	
	public static void rotateArr(int[] arr , int k) {
		
		for(int i=0;i<k;i++) {
			int element = arr[arr.length-1];
			for(int j=arr.length-1;j>0;j--) {
				arr[j] = arr[j-1];
			}
			arr[0] = element;
		}
		
	}

}
