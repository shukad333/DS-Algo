package com.general.geeks.maths;

public class GCD {
	
	public static void main(String[] args) {
		
		System.out.println(GCD(20,15));
		System.out.println(GCD(23,46));
	}
	public static int GCD(int a , int b) {
		if(a==b) {
			return a;
		}
		if(a>b) {
			return GCD(a-b,b);
		}
		return GCD(a,b-a);
	}
}
