package com.general.geeks.misc;

public class PallindromeInteger {
	
	public static void main(String[] args) {
		
		PallindromeInteger pi = new PallindromeInteger();
		//System.out.println(pi.isPallindrome(123));
		System.out.println(pi.isPallindrome(-1));
	}
	
	public boolean isPallindrome(int x) {
		
		
		int divisor = 1;
		while(x/divisor >=10) {
			divisor*=10;
		}
		
		while(x!=0) {
			int leading = x/divisor;
			int trailing = x%10;
			if(leading!=trailing)
				return false;
			x = (x%divisor)/10;
			divisor/=100;
		}
		return true;
	}
}
