package com.general.geeks.array;

import java.util.Arrays;

/**
 * 
 * Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.

After doing so, return the array.

 

Example 1:

Input: arr = [17,18,5,4,6,1]
Output: [18,6,6,6,1,-1]
 

Constraints:

1 <= arr.length <= 10^4
1 <= arr[i] <= 10^5
 * 
 * @author skadavath
 *
 */
public class ReplaceElementsWithGreatestElementOnRightSide {
	
	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(new ReplaceElementsWithGreatestElementOnRightSide().replaceElements(new int[] {17,18,5,4,6,1})));
		
	}

	public int[] replaceElements(int[] arr) {
		
		for(int i=arr.length-1,max=-1;i>=0;i--) {
			max = Math.max(arr[i], arr[i]=max);
		}
		
		return arr;

	}

}
