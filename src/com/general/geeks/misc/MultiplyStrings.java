package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two non-negative integers num1 and num2 represented as strings, return
 * the product of num1 and num2, also represented as a string.
 * 
 * Example 1:
 * 
 * Input: num1 = "2", num2 = "3" Output: "6" Example 2:
 * 
 * Input: num1 = "123", num2 = "456" Output: "56088" Note:
 * 
 * The length of both num1 and num2 is < 110. Both num1 and num2 contain only
 * digits 0-9. Both num1 and num2 do not contain any leading zero, except the
 * number 0 itself. You must not use any built-in BigInteger library or convert
 * the inputs to integer directly.
 * 
 * @author skadavath
 *
 */
public class MultiplyStrings {
	
	public static void main(String[] args) {
		
		System.out.println(new MultiplyStrings().multiply("123", "0"));
	}

	public String multiply(String num1, String num2) {

		int len1 = num1.length() - 1;
		int len2 = num2.length() - 1;
		int carry = 0;

		int[] prod = new int[len1+len2+2];
		while (len1 >= 0) {
			String local = "";
			while (len2 >= 0) {
				int n1 = num1.charAt(len1) - '0';
				int n2 = num2.charAt(len2) - '0';

				int p = (n1 * n2) + prod[len1+len2+1];
				
				prod[len1+len2+1] = p%10;
				prod[len1+len2] += p/10;
				
				len2--;

			}
			len2 = num2.length() - 1;
			len1--;

		}

		StringBuilder sb = new StringBuilder();
		for(int i : prod) {
			if(!(sb.length()==0 && i==0))sb.append(i);
		}
		return sb.toString();
	}

}
