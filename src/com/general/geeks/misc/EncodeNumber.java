package com.general.geeks.misc;

/**
 * 
 * Given a non-negative integer num, Return its encoding string.
 * 
 * The encoding is done by converting the integer to a string using a secret
 * function that you should deduce from the following table:
 *
 *  n f(n)
 *  0 ""
 *  1 "0"
 *  2 "1"
 *  3 "00"
 *  4 "01"
 *  5 "10"
 *  6 "11"
 *  7 "000"
 * 
 * Input: num = 23
Output: "1000"
Example 2:

Input: num = 107
Output: "101100"

 * 
 * @author skadavath
 *
 */
public class EncodeNumber {
	 public String encode(int num) {
		 
		 //intuition
		 //from the pattern , we can see f(n) = "1" + binary representation of n+1
		 return new String(Integer.toBinaryString(num+1)).substring(1);
	 }

}
