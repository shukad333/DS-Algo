package com.general.geeks.array;

import java.util.Arrays;

/**
 * 
 * Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.

Note that elements beyond the length of the original array are not written.

Do the above modifications to the input array in place, do not return anything from your function.

 

Example 1:

Input: [1,0,2,3,0,4,5,0]
Output: null
Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
Example 2:

Input: [1,2,3]
Output: null
Explanation: After calling your function, the input array is modified to: [1,2,3]
 
 * 
 * @author skadavath
 *
 */
public class DuplicateZeros {
	
	public static void main(String[] args) {
		
		int[] arr = {1,0,2,3,0,4,5,0};
		new DuplicateZeros().duplicateZeros(arr);
		
		System.out.println(Arrays.toString(arr));
		
	}

	public void duplicateZeros(int[] arr) {
		
		
		int count = (int)Arrays.stream(arr).filter(i->i==0).count();
		
		
		
		for(int i=arr.length-1;i>=0 && count>0 ;i--) {
			
			if(arr[i]==0)
				count--;
			else {
				int index = i+count;
				if(index<arr.length) {
					arr[index] = arr[i];
				}
				arr[i] = 0;
			}
		}

	}

}
