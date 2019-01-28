package com.general.geeks.misc;

/**
 * 
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
Follow up:

Coud you solve it without converting the integer to a string?

Accepted
440,103
Submissions
1,105,629
 * 
 * @author skadavath
 *
 */
public class PallindromeInteger {
	
	public static void main(String[] args) {
		
		PallindromeInteger pi = new PallindromeInteger();
		//System.out.println(pi.isPallindrome(123));
		System.out.println(pi.isPallindrome(98722789));
	}
	
	public boolean isPallindrome(int x) {
		
		
		int divisor = 1;
		while(x/divisor >=10) {
			divisor*=10;
		}
		
		while(x!=0) {
			int leading = x/divisor;
			int trailing = x%10;
			if(leading!=trailing)
				return false;
			x = (x%divisor)/10;
			divisor/=100;
		}
		return true;
	}
}
