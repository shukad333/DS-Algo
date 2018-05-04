package com.general.geeks.maths;

/**
 * Calculate the sum of two integers a and b, but you are not allowed to use the
 * operator + and -.
 * 
 * Example: Given a = 1 and b = 2, return 3.
 * 
 * @author skadavath
 *
 */
public class SumWithoutPlusAndMinus {
	
	public static void main(String[] args) {
		int i = 2;
		System.out.println(new SumWithoutPlusAndMinus().getSum(2, 4));
	}
	public int getSum(int a, int b) {
		
		while(b!=0) {
			int carry = a & b;
			a = a ^ b;
			b = carry << 1;
			
		}
		
		return a;
	}
}
