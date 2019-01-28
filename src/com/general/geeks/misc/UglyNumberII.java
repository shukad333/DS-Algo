package com.general.geeks.misc;

/**
 * Write a program to find the n-th ugly number.
 * 
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * 
 * Example:
 * 
 * Input: n = 10 Output: 12 Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the
 * sequence of the first 10 ugly numbers. Note:
 * 
 * 1 is typically treated as an ugly number. n does not exceed 1690.
 * 
 * @author skadavath
 *
 */
public class UglyNumberII {
	
	public static void main(String[] args) {
		System.out.println(new UglyNumberII().nthUglyNumber(10));
	}

	//Using dp ... Very good solution
	public int nthUglyNumber(int n) {
		
		int[] resp = new int[n];
		
		int a=2,b=3,c=5;
		resp[0] = 1;
		
		int i1=0,i2=0,i3=0;
		for(int i=1;i<n;i++) {
			
			int min = Math.min(a, Math.min(b, c));
			resp[i] = min;
			if(a==min) {
				a = 2*resp[++i1];
				
			}
			if(b==min) {
				b=3*resp[++i2];
				
			}
			if(c==min) {
				c=5*resp[++i3];
			}
		}
		
		return resp[n-1];

	}

}
