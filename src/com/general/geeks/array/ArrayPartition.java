package com.general.geeks.array;

/**
 * Given a array of integers find the index which partitions the array to two
 * with high numbers and low numbers. For example [5, -1, 3, 8,6] the index 3
 * will partition the array to [5,-1,3] and [8,6] all the numbers in the second
 * partition are greater than first. The solution has to work in O(n)
 * 
 * @author skadavath
 *
 */
public class ArrayPartition {
	
	public static void main(String[] args) {
		System.out.println(new ArrayPartition().partition(new int[] {10,100,13,80,60}));
	}
	
	private int partition(int[] arr) {
		
		int n = arr.length;
		int[] max = new int[n];
		int[] min = new int[n];
		
		max[0] = arr[0];
		for(int i=1;i<n;i++) {
			if(arr[i]>max[i-1]) {
				max[i] = arr[i];
			}
			else
				max[i] = max[i-1];
		}
		
		min[n-1] = arr[n-1];
		for(int j=n-2;j>=0;j--) {
			if(arr[j]<min[j+1]) {
				min[j] = arr[j];
			}
			else 
				min[j] = min[j+1];
		}
		
		for(int i=1;i<n;i++) {
			if(max[i-1]<min[i])
				return i-1;
		}
		return -1;
	}

}
