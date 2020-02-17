package com.interviewbit;

public class Atoi {
	
	public static void main(String[] args) {
		
		System.out.println(new Atoi().atoi("7 U 0 T7165 0128862 089 39 5"));
		
	}

	public int atoi(final String A) {

		int num = 0;

		for (int i = 0; i < A.length(); i++) {
			if (Character.isDigit(A.charAt(i)))
				num = num * 10 + A.charAt(i) - '0';
			else
				break;
		}

		return num;
	}

}
