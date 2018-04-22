package com.general.geeks.maths;

import java.util.HashSet;
import java.util.Set;

/*
 * 
 * Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1

 */
public class HappyNumber {

	public static void main(String[] args) {
		
		System.out.println(new HappyNumber().isHappy(4));

	}

	public boolean isHappy(int n) {
		
		if(n==0) 
			return false;
		
		Set<Integer> set = new HashSet();
		while(true) {
			
		n = getSquare(n);
		if (n == 1) {
			return true;
		}
		
		if(set.contains(n))
			return false;
		
		set.add(n);
		
		}
	}
	
	private int getSquare(int n) {
		int sum = 0;
		while (n > 0) {
			int digit = n % 10;
			sum += Math.pow(digit, 2);
			n = n/10;
		}
		
		return sum;
	}

}
