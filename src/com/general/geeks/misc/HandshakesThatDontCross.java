package com.general.geeks.misc;

/**
 * 
 * You are given an even number of people num_people that stand around a circle
 * and each person shakes hands with someone else, so that there are num_people
 * / 2 handshakes total.
 * 
 * Return the number of ways these handshakes could occur such that none of the
 * handshakes cross.
 * 
 * Since this number could be very big, return the answer mod 10^9 + 7
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: num_people = 2 Output: 1
 * 
 * 
 * Input: num_people = 4 Output: 2 Explanation: There are two ways to do it, the
 * first way is [(1,2),(3,4)] and the second one is [(2,3),(4,1)].
 * 
 * @author skadavath
 *
 */
public class HandshakesThatDontCross {
	
	/**
	 * 
	 * Solution 1: DP
dp[n] is the number of shaking ways of n pairs people
In the the view of first people in these n pairs,
he/she can choose anyone, split i pairs on his left and n - 1 - i pairs on his right.

So here comes the equation of dynamic programme:
dp[n + 1] = dp[0] * dp[n] + dp[1] * dp[n - 1] + ..... + dp[n] * dp[0]


Complexity
Time O(N^2)
Space O(N)
	 * 
	 */
	
	 public int numberOfWays(int n) {
	        long mod = (long)1e9 + 7;
	        long[] dp = new long[n / 2 + 1];
	        dp[0] = 1;
	        for (int k = 1; k <= n / 2; ++k) {
	            for (int i = 0; i < k; ++i) {
	                dp[k] = (dp[k] + dp[i] * dp[k - 1 - i]) % mod;
	            }
	        }
	        return (int)dp[n / 2];
	    }
	 
	 
	 /**
	  * 
	  * Solution 2: Catalan Numbers
Inspired form @awice

Java

    public int numberOfWays(int n) {
        long[] inv = new long[n / 2 + 2];
        inv[1] = 1;
        long mod = (long)1e9 + 7, res = 1;
        for (int i = 2; i < n / 2 + 2; ++i) {
            inv[i] = mod - mod / i * inv[(int)mod % i] % mod;
        }
        for (int i = 1; i <= n / 2; ++i) {
            res = res * (i + n / 2) % mod;
            res = res * inv[i] % mod;
        }
        return (int)(res * inv[n / 2 + 1] % mod);
    }
	  * 
	  */

}
