package com.general.geeks.maths;

/**
 * Find the smallest prime palindrome greater than or equal to N.
 * 
 * Recall that a number is prime if it's only divisors are 1 and itself, and it
 * is greater than 1.
 * 
 * For example, 2,3,5,7,11 and 13 are primes.
 * 
 * Recall that a number is a palindrome if it reads the same from left to right
 * as it does from right to left.
 * 
 * For example, 12321 is a palindrome.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: 6 Output: 7 Example 2:
 * 
 * Input: 8 Output: 11 Example 3:
 * 
 * Input: 13 Output: 101
 * 
 * @author skadavath
 *
 */
public class PrimePallindrome {
	
	public static void main(String[] args) {
		PrimePallindrome pp = new PrimePallindrome();
		System.out.println(pp.primePalindrome(13));
	}

	 public int primePalindrome(int N) {
			
			if(N==1 || N==2)
				return 2;
			if(N%2==0)
				N++;
			for(int i=N;;i+=2) {
	             if (10_000_000 < i && i < 100_000_000)
	                i = 100_000_001;
				if(isPallindrome(i))
					if(isPrime(i))
						return i;
			}

		}
		
	public boolean isPallindrome(int x) {
			
		String o = String.valueOf(x);
		String r = new StringBuilder(o).reverse().toString();
		return o.equals(r);

		}
		
		private boolean isPrime(int n) {
			for(int i=3;i<=Math.sqrt(n);i+=2) {
				if(n%i==0)
					return false;
			}
			return true;
		}
	}