package com.general.geeks.misc;

public class ExcelSheetColumnNumber {
	
	public static void main(String[] args) {
		
		char s = 'Z';
		System.out.println(new ExcelSheetColumnNumber().titleToNumber("BB"));
	}
	public int titleToNumber(String s) {
		
		if(null == s || s.isEmpty()) {
			return 0;
		}
		int num = 0;
		int exp=0;
		for(int i=s.length()-1;i>=0;i--) {
			int val = s.charAt(i)-'A'+1;
			num += (int)Math.pow(26, exp) * val;
			exp++;
			
		}
		
		return num;
	}

}
