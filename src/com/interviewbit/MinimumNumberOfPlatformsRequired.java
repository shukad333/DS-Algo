package com.interviewbit;

import java.util.Arrays;

/**
 * 
 * iven arrival and departure times of all trains that reach a railway station, find the minimum number of platforms required for the railway station so that no train waits.
We are given two arrays which represent arrival and departure times of trains that stop

Examples:

Input:  arr[]  = {9:00,  9:40, 9:50,  11:00, 15:00, 18:00}
        dep[]  = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
Output: 3
There are at-most three trains at a time (time between 11:00 to 11:20)

 * 
 * @author skadavath
 *
 */
public class MinimumNumberOfPlatformsRequired {
	
	public static void main(String[] args) {
		
		 int arr[] = {900, 940, 950, 1100, 1500, 1800}; 
		    int dep[] = {910, 1200, 1120, 1130, 1900, 2000}; 
		    
		    System.out.println(new MinimumNumberOfPlatformsRequired().findPlatform(arr, dep, 1));
		
	}
	
	private int findPlatform(int arr[], int dep[], int n)  {
		
		Arrays.sort(arr);
		Arrays.sort(dep);
		
		int resp = 1;
		
		int i=1,j=0,max = Integer.MIN_VALUE;
		
		while(i<arr.length && j<dep.length) {
			
			if(arr[i]<dep[j]) {
				resp++;
				max = Math.max(max, resp);
				i++;
				
			}
			else {
				j++;
				resp--;
			}
			
		}
		
		return max;
		
	}

}
