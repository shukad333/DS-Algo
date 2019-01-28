package com.general.geeks.misc;

/**
 * Given a non-negative integer n, count all numbers with unique digits, x,
 * where 0 ≤ x < 10n.
 * 
 * Example:
 * 
 * Input: 2 Output: 91 Explanation: The answer should be the total numbers in
 * the range of 0 ≤ x < 100, excluding 11,22,33,44,55,66,77,88,99
 * 
 * @author skadavath
 *
 */
public class CountNumbersWithUniqueDigits {
	
	public static void main(String[] args) {
		
		System.out.println(new CountNumbersWithUniqueDigits().countNumbersWithUniqueDigits(2));
		
	}

	public int countNumbersWithUniqueDigits(int n) {
		
		/*
		 * 
		 * For n=1 , we have 0-9 digits and f(1)=10
		 * For n=2 , we have to choose 0-9 and each time exclude 0-9 for all 0-9 , Hence it will be 9 * 9
		 * For n=3, we have i,j,k , we have 8 options for each i,j excluding i and j , hence f(3)=f(2)*8
		 * For n=4, f(4)=7*f(3) etc
		 * for n=10 , f(10) = 1
		 * for n>10 , f(x) = 0
		 */
		
		int digits = 9;
		int start = 9;
		int resp = 10;
		int available = 9;
		for(int i=n;i>1 && available>0;i--) {
			
			digits*=available--;
			resp = resp + digits;
		}
		
		return resp;

	}

}
