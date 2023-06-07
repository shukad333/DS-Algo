package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 
 * Given a positive integer N, return the number of positive integers less than or equal to N that have at least 1 repeated digit.

 

Example 1:

Input: 20
Output: 1
Explanation: The only positive number (<= 20) with at least 1 repeated digit is 11.
Example 2:

Input: 100
Output: 10
Explanation: The positive numbers (<= 100) with atleast 1 repeated digit are 11, 22, 33, 44, 55, 66, 77, 88, 99, and 100.
Example 3:

Input: 1000
Output: 262
 

Note:

1 <= N <= 10^9

 * 
 * @author skadavath
 *
 */
public class NumbersWithRepeatedDigits {
	
	
	public static void main(String[] args) {
		
		System.out.println(new NumbersWithRepeatedDigits().numDupDigitsAtMostN(8000));
		
	}

	public int numDupDigitsAtMostN(int N) {
		
		// Transform N + 1 to arrayList
        ArrayList<Integer> L = new ArrayList<Integer>();
        for (int x = N + 1; x > 0; x /= 10)
            L.add(0, x % 10);

        // Count the number with digits < N
        int res = 0, n = L.size();
        for (int i = 1; i < n; ++i)
            res += 9 * perm(9, i - 1);

        // Count the number with same prefix
        HashSet<Integer> seen = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            for (int j = i > 0 ? 0 : 1; j < L.get(i); ++j)
                if (!seen.contains(j))
                    res += perm(9 - i, n - i - 1);
            if (seen.contains(L.get(i))) break;
            seen.add(L.get(i));
        }
        return N - res;
    }


    public int perm(int m, int n) {
        return n == 0 ? 1 : perm(m, n - 1) * (m - n + 1);
    }

	

}
