package com.general.geeks.misc;

/**
 * 
 * Let's say a positive integer is a superpalindrome if it is a palindrome, and it is also the square of a palindrome.

Now, given two positive integers L and R (represented as strings), return the number of superpalindromes in the inclusive range [L, R].

 

Example 1:

Input: L = "4", R = "1000"
Output: 4
Explanation: 4, 9, 121, and 484 are superpalindromes.
Note that 676 is not a superpalindrome: 26 * 26 = 676, but 26 is not a palindrome.
 

Note:

1 <= len(L) <= 18
1 <= len(R) <= 18
L and R are strings representing integers in the range [1, 10^18).
int(L) <= int(R)
 * 
 * @author skadavath
 *
 */
public class SuperPallindrome {
	
	public static void main(String[] args) {
		
		System.out.println(new SuperPallindrome().superpalindromesInRange("4", "10000"));
		
	}
	
	public int superpalindromesInRange(String L, String R) {
        Long l = Long.valueOf(L), r = Long.valueOf(R);
        int result = 0;
        for (long i = (long)Math.sqrt(l); i * i <= r;) {
            long p = nextP(i);
            if (p * p <= r && isP(p * p)) {
                result++;
            }
            i = p + 1;
        }
        return result;
    }
	
	private long nextP(long l)
    {
        String s = Long.toString(l);
        int N = s.length();
        String half = s.substring(0, (N + 1)/2);
        String reverse = new StringBuilder(half.substring(0, N/2)).reverse().toString();
        long first = Long.valueOf(half + reverse);
        if(first >= l)return first;
        String nexthalf = Long.toString(Long.valueOf(half) +1);
        String reverseNextHalf = new StringBuilder(nexthalf.substring(0,N/2)).reverse().toString();
        long second = Long.valueOf(nexthalf + reverseNextHalf);
        return second;

    }
	
	private boolean isP(long l) {
        String s = "" + l;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

}
