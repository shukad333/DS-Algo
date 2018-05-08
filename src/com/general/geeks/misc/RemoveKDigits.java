package com.general.geeks.misc;

/**
 * Given a non-negative integer num represented as a string, remove k digits
 * from the number so that the new number is the smallest possible.
 * 
 * Note: The length of num is less than 10002 and will be ≥ k. The given num
 * does not contain any leading zero. Example 1:
 * 
 * Input: num = "1432219", k = 3 Output: "1219" Explanation: Remove the three
 * digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * 
 * @author skadavath
 *
 */
public class RemoveKDigits {
	
	public static void main(String[] args) {
		
		String num = "21345";
		System.out.println(new RemoveKDigits().removeKdigits(num, 2));
	}

	public String removeKdigits(String num, int k) {
		
		
		
		String res = "";
		buildLowest(num, k, res);
		return res;

	}
	
	private void buildLowest(String num,int k , String res) {
		
		if(k==0) {
			 res = res+num;
			 return;
		}
		
		if(num.length()<=k) {
			return;
		}
		
		int minIndex = 0;
		for(int i=1;i<num.length();i++) {
			if(num.charAt(minIndex)>num.charAt(i)) {
				minIndex = i;
			}
		}
		
		res = num.charAt(minIndex)+res;
		String newStr = num.substring(minIndex+1,num.length());
		buildLowest(newStr, k-1, res);
	}

}
