package com.general.geeks.practicegeeks;

/**
 * 
 * Given an array of 0’s and 1’s, we need to write a program to find the minimum number of swaps required to group all 1’s present in the array together.

Examples:

Input : arr[] = {1, 0, 1, 0, 1}
Output : 1
Explanation: Only 1 swap is required to 
group all 1's together. Swapping index 1
and 4 will give arr[] = {1, 1, 1, 0, 0}

Input : arr[] = {1, 0, 1, 0, 1, 1}
Output : 1
 * 
 * @author skadavath
 *
 */
public class NumberOfSwapsRequiredToGroupsAllOnes {
	
	// Function to find minimum swaps 
	// to group all 1's together 
	 static int minSwaps(int arr[], int n) { 
	  
	int noOfOnes = 0; 
	  
	// find total number of all in the array 
	for (int i = 0; i < n; i++) { 
	    if (arr[i] == 1) 
	    noOfOnes++; 
	} 
	  
	// length of subarray to check for 
	int x = noOfOnes; 
	  
	int maxOnes = Integer.MIN_VALUE; 
	  
	// array to store number of 1's upto 
	// ith index 
	int preCompute[] = new int[n]; 
	  
	// calculate number of 1's upto ith 
	// index and store in the array preCompute[] 
	if (arr[0] == 1) 
	    preCompute[0] = 1; 
	for (int i = 1; i < n; i++) { 
	    if (arr[i] == 1) { 
	    preCompute[i] = preCompute[i - 1] + 1; 
	    } else
	    preCompute[i] = preCompute[i - 1]; 
	} 
	  
	// using sliding window technique to find 
	// max number of ones in subarray of length x 
	for (int i = x - 1; i < n; i++) { 
	    if (i == (x - 1))  
	    noOfOnes = preCompute[i]; 
	    else
	    noOfOnes = preCompute[i] - preCompute[i - x]; 
	      
	    if (maxOnes < noOfOnes) 
	    maxOnes = noOfOnes; 
	} 
	  
	// calculate number of zeros in subarray 
	// of length x with maximum number of 1's 
	int noOfZeroes = x - maxOnes; 
	  
	return noOfZeroes; 
	} 
	  
	// Driver Code 
	public static void main (String[] args) { 
	int a[] = {1, 0, 0, 0, 1,1,1}; 
	int n = a.length; 
	System.out.println( minSwaps(a, n)); 
	      
	    } 

}
