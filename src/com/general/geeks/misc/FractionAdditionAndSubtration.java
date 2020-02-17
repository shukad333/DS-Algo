package com.general.geeks.misc;

import java.util.stream.Stream;

/**
 * 
 * Given a string representing an expression of fraction addition and subtraction, you need to return the calculation result in string format. The final result should be irreducible fraction. If your final result is an integer, say 2, you need to change it to the format of fraction that has denominator 1. So in this case, 2 should be converted to 2/1.

Example 1:
Input:"-1/2+1/2"
Output: "0/1"
Example 2:
Input:"-1/2+1/2+1/3"
Output: "1/3"
Example 3:
Input:"1/3-1/2"
Output: "-1/6"
Example 4:
Input:"5/3+1/3"
Output: "2/1"
 * 
 * @author skadavath
 *
 */
public class FractionAdditionAndSubtration {
	
	public static void main(String[] args) {
		
		System.out.println(new FractionAdditionAndSubtration().fractionAddition("5/3+1/3"));
		
	}

	public String fractionAddition(String expression) {
		
			
		String[] fracs = expression.split("(?=[-+])"); // splits input string into individual fractions
	    String res = "0/1";
	    for (String frac : fracs) res = add(res, frac); // add all fractions together
	    return res;
	}

	public String add(String frac1, String frac2) {
	    int[] f1 = Stream.of(frac1.split("/")).mapToInt(Integer::parseInt).toArray(), 
	          f2 = Stream.of(frac2.split("/")).mapToInt(Integer::parseInt).toArray();
	    int numer = f1[0]*f2[1] + f1[1]*f2[0], denom = f1[1]*f2[1];
	    String sign = "";
	    if (numer < 0) {sign = "-"; numer *= -1;}
	    return sign + numer/gcd(numer, denom) + "/" + denom/gcd(numer, denom); // construct reduced fraction
	}

	// Computes gcd using Euclidean algorithm
	public int gcd(int x, int y) { return x == 0 || y == 0 ? x + y : gcd(y, x % y); }
	
}