package com.general.geeks.misc;

/**
 * Find the largest palindrome made from the product of two n-digit numbers.
 * 
 * Since the result could be very large, you should return the largest
 * palindrome mod 1337.
 * 
 * Example:
 * 
 * Input: 2
 * 
 * Output: 987
 * 
 * Explanation: 99 x 91 = 9009, 9009 % 1337 = 987
 * 
 * Note:
 * 
 * The range of n is [1,8].
 * 
 * 
 * @author skadavath
 *
 */
public class LargestPallindromeProduct {

	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(~7));
		System.out.println(Integer.highestOneBit(8));
		System.out.println(~5 & (Integer.highestOneBit(5)-1));
		System.out.println(new LargestPallindromeProduct().largestPalindrome(2));
	}

	public int largestPalindrome(int n) {

		int res = 0;

		int maxNum = (int) Math.pow(10, n) - 1;

		int upperBound = maxNum;
		int lowerBound = maxNum / 10;

		maxNum *= maxNum;

		boolean found = false;
		long pal = 0;
		int firstHalf = maxNum / (int) Math.pow(10, n);
		while (!found) {
			for (long i = upperBound; upperBound > lowerBound; i--) {

				pal = createPal(firstHalf);

				if (pal / i > maxNum || i * i < pal) {
					break;
				}

				if (pal % i == 0) {
					found = true;
					break;
				}

			}
			
			firstHalf--;

		}
		
		
		return (int)(pal%1337);

	}

	private Long createPal(long num) {
		String rev = num + new StringBuilder().append(num).reverse().toString();
		return Long.parseLong(rev);
	}


}
