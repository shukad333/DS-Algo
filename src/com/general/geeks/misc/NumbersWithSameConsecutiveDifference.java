package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * Return all non-negative integers of length N such that the absolute difference between every two consecutive digits is K.

Note that every number in the answer must not have leading zeros except for the number 0 itself. For example, 01 has one leading zero and is invalid, but 0 is valid.

You may return the answer in any order.

 

Example 1:

Input: N = 3, K = 7
Output: [181,292,707,818,929]
Explanation: Note that 070 is not a valid number, because it has leading zeroes.
Example 2:

Input: N = 2, K = 1
Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 

Note:

1 <= N <= 9
0 <= K <= 9
 * 
 * @author skadavath
 *
 */
public class NumbersWithSameConsecutiveDifference {
	
	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(new NumbersWithSameConsecutiveDifference().numsSameConsecDiff(3, 7)));
		
	}

	public int[] numsSameConsecDiff(int N, int K) {
		
		List<Integer> cur = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,0));
		
		for (int i = 2; i <= N; ++i) {
            List<Integer> cur2 = new ArrayList<>();
            for (int x : cur) {
                int y = x % 10;
                if (x > 0 && y + K < 10)
                    cur2.add(x * 10 + y + K);
                if (x > 0 && K > 0 && y - K >= 0)
                    cur2.add(x * 10 + y - K);
            }
            cur = cur2;
        }
		
		return cur.stream().mapToInt(j->j).toArray();

	}

}
