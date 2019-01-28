package com.general.geeks.misc;

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero.

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Note:

Both dividend and divisor will be 32-bit signed integers.
The divisor will never be 0.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.

 * @author skadavath
 *
 */
public class DivideTwoIntegers {
	
	public static void main(String[] args) {
		
		System.out.println(new DivideTwoIntegers().divide(-2147483648, 2));
		
	}

	 public int divide(int dividend, int divisor) {
			
			if(divisor==0 || (dividend==Integer.MIN_VALUE && divisor==-1)) {
				return Integer.MAX_VALUE;
			}
	        
	        
			
			if(dividend==0)
				return 0;
	        
	        if(divisor==1)
	            return dividend;
			
			int ans = 1;
			
			int sign = dividend<1 ^ divisor<1 ? -1 : 1;
			long div = Math.abs((long)divisor);
	        long divid = Math.abs((long)dividend);
	        
	        long lans = ldivide(divid, div);
			
			
			return (int)(lans)*sign;

		}
	 
	 private long ldivide(long ldividend, long ldivisor) {
			// Recursion exit condition
			if (ldividend < ldivisor) return 0;
			
			//  Find the largest multiple so that (divisor * multiple <= dividend), 
			//  whereas we are moving with stride 1, 2, 4, 8, 16...2^n for performance reason.
			//  Think this as a binary search.
			long sum = ldivisor;
			long multiple = 1;
			while ((sum+sum) <= ldividend) {
				sum += sum;
				multiple += multiple;
			}
			//Look for additional value for the multiple from the reminder (dividend - sum) recursively.
			return multiple + ldivide(ldividend - sum, ldivisor);
		}
}
