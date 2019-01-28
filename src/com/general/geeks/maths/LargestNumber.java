package com.general.geeks.maths;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of non negative integers, arrange them such that they form the
 * largest number.
 * 
 * Example 1:
 * 
 * Input: [10,2] Output: "210" Example 2:
 * 
 * Input: [3,30,34,5,9] Output: "9534330" Note: The result may be very large, so
 * you need to return a string instead of an integer.
 * 
 * 
 * @author skadavath
 *
 */
public class LargestNumber {
	
	public static void main(String[] args) {
		
		System.out.println(new LargestNumber().largestNumber(new int[] {0,0,1,80,8}));
	}

	public String largestNumber(int[] nums) {
		
		if(null==nums || nums.length==0) {
			return null;
		}
		
		Comparator<String> comparator = new Comparator<String>() {
			@Override
			public int compare(String arg0, String arg1) {
				
				String first = arg0+arg1;
				String second = arg1+arg0;
				
				return second.compareTo(first);
			}
		};
		
		String[] numbers = new String[nums.length];
		for(int i=0;i<nums.length;i++) {
			numbers[i] = String.valueOf(nums[i]);
		}
		
		Arrays.sort(numbers,comparator);
		
		//special case when all are 0
		if(numbers[0].charAt(0)=='0') {
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		for(String s : numbers) {
			sb.append(s);
		}
		return sb.toString();

	}

}
