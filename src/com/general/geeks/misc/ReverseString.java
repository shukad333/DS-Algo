package com.general.geeks.misc;

/**
 * Write a function that takes a string as input and returns the string
 * reversed.
 * 
 * Example: Given s = "hello", return "olleh".
 * 
 * 
 * @author skadavath
 *
 */
public class ReverseString {

	public static void main(String[] args) {

		System.out.println(new ReverseString().reverseString("hello"));
	}

	public String reverseString(String s) {

		int len = s.length();
		String resp = "";
		for (int i = 0; i < len; i++) {

			char temp = s.charAt(len - i - 1);
			resp = resp + temp;

		}
		return resp;
	}

}
