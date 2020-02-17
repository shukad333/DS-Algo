package com.interviewbit;

public class IntegerToString {
	
	public static void main(String[] args) {
		
		System.out.println(new IntegerToString().convert(123));
		
	}
	
	private String convert(int i) {
		
		int noOfDigits = (int)(Math.log10(i))+1;
		
		StringBuilder sb = new StringBuilder();
		while(noOfDigits>0) {
			int num = (int) (i/(Math.pow(10, noOfDigits-1)));
			sb.append(num+"");
			i%=Math.pow(10, noOfDigits-1);
			noOfDigits--;
		}
		return sb.toString();
	}

}
