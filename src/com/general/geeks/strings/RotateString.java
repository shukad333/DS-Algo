package com.general.geeks.strings;

/**
 * 
 * We are given two strings, A and B.
 * 
 * A shift on A consists of taking string A and moving the leftmost character to
 * the rightmost position. For example, if A = 'abcde', then it will be 'bcdea'
 * after one shift on A. Return True if and only if A can become B after some
 * number of shifts on A.
 * 
 * Example 1: Input: A = 'abcde', B = 'cdeab' Output: true
 * 
 * Example 2: Input: A = 'abcde', B = 'abced' Output: false Note:
 * 
 * A and B will have length at most 100.
 * 
 * @author skadavath
 *
 */
public class RotateString {
	
	public static void main(String[] args) {
		System.out.println(new RotateString().rotateString("abcde", "cdeab"));
	}

	public boolean rotateString(String A, String B) {
		
		if(null == A || null == B) {
			return false;
		}
		
		if(A.equals(B)) {
			return true;
		}
		if(A.length()==0 && B.length()==0) {
			return false;
		}
		if(A.length()==0 || B.length()==0) {
			return false;
		}
		if(A.length()!=B.length())
			return false;
		
		
		for(int i=0;i<A.length();i++) {
			A = rotateBy1(A);
			if(A.equals(B)) {
				return true;
			}
		}
		
		return false;
	}
	
	public String rotateBy1(String s) {
		char[] charArr = s.toCharArray();
		char temp = charArr[0];
		for(int i=1;i<charArr.length;i++) {
			charArr[i-1] = charArr[i];
		}
		charArr[charArr.length-1] = temp;
		return new String(charArr);
	}

}
