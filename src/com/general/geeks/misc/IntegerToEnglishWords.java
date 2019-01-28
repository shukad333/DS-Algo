package com.general.geeks.misc;

import java.util.HashSet;
import java.util.Set;

/**
 * Convert a non-negative integer to its english words representation. Given
 * input is guaranteed to be less than 231 - 1.
 * 
 * Example 1:
 * 
 * Input: 123 Output: "One Hundred Twenty Three" Example 2:
 * 
 * Input: 12345 Output: "Twelve Thousand Three Hundred Forty Five" Example 3:
 * 
 * Input: 1234567 Output: "One Million Two Hundred Thirty Four Thousand Five
 * Hundred Sixty Seven" Example 4:
 * 
 * Input: 1234567891 Output: "One Billion Two Hundred Thirty Four Million Five
 * Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 * 
 * @author skadavath
 *
 */
public class IntegerToEnglishWords {
	
	public static void main(String[] args) {
		System.out.println(new IntegerToEnglishWords().numberToWords(1230123));
	}

	public String numberToWords(int num) {
		
		if (num == 0) return "Zero";
		
		String[] till20 = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
		String[] tens = {"","Ten","Twenty","Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
		String[] thousands = {"", "Thousand", "Million", "Billion"};
		
		String resp = "";
		int i=0;
		while(num>0) {
			if(num%1000!=0) {
				resp = getConv(num%1000, till20, tens, thousands)+thousands[i]+" "+resp;
			}
			num/=1000;
			i++;
		}
		
		
		
		return resp.trim();

	}
	
	private String getConv(int num,String[] till20,String[] tens,String[] thousands) {
		if(num==0)
			return "";
		
		else if(num<20) {
			return till20[num]+" ";
		}
		else if(num<100) {
			return tens[num/10]+" " + getConv(num%10, till20, tens, thousands);
		}
		else
			return till20[num/100]+" Hundred "+getConv(num%100, till20, tens, thousands);
		}
	}


