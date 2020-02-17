package com.general.geeks.misc;

import java.util.Arrays;

/**
 * 
 * Given an array A of positive integers (not necessarily distinct), return the lexicographically largest permutation that is smaller than A, that can be made with one swap (A swap exchanges the positions of two numbers A[i] and A[j]).  If it cannot be done, then return the same array.

 

Example 1:

Input: [3,2,1]
Output: [3,1,2]
Explanation: Swapping 2 and 1.
Example 2:

Input: [1,1,5]
Output: [1,1,5]
Explanation: This is already the smallest permutation.
Example 3:

Input: [1,9,4,6,7]
Output: [1,7,4,6,9]
Explanation: Swapping 9 and 7.
Example 4:

Input: [3,1,1,3]
Output: [1,3,1,3]
Explanation: Swapping 1 and 3.
 

Note:

1 <= A.length <= 10000
1 <= A[i] <= 10000

 * @author skadavath
 *
 */
public class PreviousPermutationWithOneSwap {
	
	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(new PreviousPermutationWithOneSwap().prevPermOpt1(new int[] {3,1,1,3})));
		
	}

	public int[] prevPermOpt1(int[] A) {
		
		
		int n=A.length,left =n-2,right=n-1;
		
		while(left>=0 && A[left]<=A[left+1])
			left--;
		
		if(left==-1)
			return A;
		
		while(A[left]<=A[right])right--;
		while(A[right]==A[right-1])right--;
		
		int temp = A[left];
		A[left] = A[right];
		A[right] = temp;
		
		return A;

	}

}
