package com.general.geeks.array.dynamicprogramming;

/**
 * Initially on a notepad only one character 'A' is present. You can perform two
 * operations on this notepad for each step:
 * 
 * Copy All: You can copy all the characters present on the notepad (partial
 * copy is not allowed). Paste: You can paste the characters which are copied
 * last time. Given a number n. You have to get exactly n 'A' on the notepad by
 * performing the minimum number of steps permitted. Output the minimum number
 * of steps to get n 'A'.
 * 
 * Example 1: Input: 3 Output: 3 Explanation: Intitally, we have one character
 * 'A'. In step 1, we use Copy All operation. In step 2, we use Paste operation
 * to get 'AA'. In step 3, we use Paste operation to get 'AAA'. Note: The n will
 * be in the range [1, 1000].
 * 
 * @author skadavath
 *
 */
public class TwoKeysKeyboard {
	
	public static void main(String[] args) {
		System.out.println(new TwoKeysKeyboard().minSteps(15));
	}

	public int minSteps(int n) {
		
		//For AA - 2 ops
		//For AAA - 3 ops(Copy,Paste,Paste)
		//For AAAA - 4 ops (Copy,Paste,Copy,Paste) or (Copy,Paste,Paste,Paste)
		//For AAAAAAAA - Either 8 ops or 6 - 2 additional steps from AAAA (Copy and Paste)
		
		int[] dp = new int[n+1];
		
		for(int i=2;i<=n;i++) {
			dp[i] = i; //initially setting the original
			for(int j=i-1;j>1;j--) {
				if(i%j==0) {
					dp[i] = dp[j] + i/j; 
					//break;
				}
			}
		}
		
		return dp[n];

	}

}
