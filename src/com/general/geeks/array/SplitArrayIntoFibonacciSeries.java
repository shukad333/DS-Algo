package com.general.geeks.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given a string S of digits, such as S = "123456579", we can split it into a Fibonacci-like sequence [123, 456, 579].

Formally, a Fibonacci-like sequence is a list F of non-negative integers such that:

0 <= F[i] <= 2^31 - 1, (that is, each integer fits a 32-bit signed integer type);
F.length >= 3;
and F[i] + F[i+1] = F[i+2] for all 0 <= i < F.length - 2.
Also, note that when splitting the string into pieces, each piece must not have extra leading zeroes, except if the piece is the number 0 itself.

Return any Fibonacci-like sequence split from S, or return [] if it cannot be done.

Example 1:

Input: "123456579"
Output: [123,456,579]
Example 2:

Input: "11235813"
Output: [1,1,2,3,5,8,13]
Example 3:

Input: "112358130"
Output: []
Explanation: The task is impossible.
Example 4:

Input: "0123"
Output: []
Explanation: Leading zeroes are not allowed, so "01", "2", "3" is not valid.
Example 5:

Input: "1101111"
Output: [110, 1, 111]
Explanation: The output [11, 0, 11, 11] would also be accepted.
Note:

1 <= S.length <= 200
S contains only digits.
 * 
 * @author skadavath
 *
 */
public class SplitArrayIntoFibonacciSeries {
	
	public static void main(String[] args) {
		
		System.out.println(new SplitArrayIntoFibonacciSeries().splitIntoFibonacci("123456579"));
		
	}

	public List<Integer> splitIntoFibonacci(String S) {
		
		List<Integer> resp = new ArrayList<>();
		resp.add(null);
		//helper(S, resp, 0);
		return resp;

	}
	
	private boolean helper(String S , List<Integer> resp,int index) {
		
		if(index==S.length() && resp.size()>=3)
			return true;

		for(int i=index;i<S.length();i++) {
			
			if(S.charAt(index)=='0' && i>index)
				break;
			
			String subStr = S.substring(index, i+1);
			
			int respSize = resp.size();
			long num = Long.parseLong(subStr);
			if(num>Integer.MAX_VALUE)
				break;
			
			if(respSize>=2 && num>resp.get(respSize-1)+resp.get(respSize-2))
				break;
			
			if(respSize<=1 || num==resp.get(respSize-1)+resp.get(respSize-2)) {
				resp.add((int)num);
				if(helper(S, resp, i+1))
				return true;
				resp.remove(resp.size()-1);
			}
		}
		
		return false;
		
	}

}
