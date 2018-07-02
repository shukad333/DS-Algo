package com.general.geeks.misc;

/**
 * Given a non-negative integer c, your task is to decide whether there're two
 * integers a and b such that a2 + b2 = c.
 * 
 * Example 1: Input: 5 Output: True Explanation: 1 * 1 + 2 * 2 = 5 Example 2:
 * Input: 3 Output: False
 * 
 * @author skadavath
 *
 */
public class SumOfSquareNumbers {
	
	public static void main(String[] args) {
		System.out.println(new SumOfSquareNumbers().judgeSquareSum(5));
		System.out.println(new SumOfSquareNumbers().judgeSquareSum(3));
		System.out.println(new SumOfSquareNumbers().judgeSquareSum(29));
	}

	public boolean judgeSquareSum(int c) {
		
		int left = 0;
		int right = (int)Math.sqrt(c);
		while(left<=right) {
			int square = left*left + right*right;
			if(square == c) 
				return true;
			else {
				if(square < c)
				left++;
				if(square > c)
				right--;
			}
		}
		
		return false;

	}

}
