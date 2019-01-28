package com.general.geeks.misc;

/**
 * Given an integer, return its base 7 string representation.
 * 
 * Example 1: Input: 100 Output: "202" Example 2: Input: -7 Output: "-10"
 * 
 * @author skadavath
 *
 */
public class Base7 {
	
	public static void main(String[] args) {
		
		System.out.println(new Base7().convertToBase7(100));
		
	}

	 public String convertToBase7(int num) {
			
			if(num==0) {
				return "0";
			}
			
			StringBuilder sb = new StringBuilder();
			
	        boolean isNegative = num<0;
	        num = Math.abs(num);
			while(num>0) {
				
				int div = num%7;
				sb.append(div+"");
				num/=7;
			}
			
	        
			return isNegative?"-"+sb.reverse().toString():sb.reverse().toString();

		}

}
