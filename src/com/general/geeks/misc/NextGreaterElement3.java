package com.general.geeks.misc;

import java.util.Arrays;

/**
 * Given a positive 32-bit integer n, you need to find the smallest 32-bit
 * integer which has exactly the same digits existing in the integer n and is
 * greater in value than n. If no such positive 32-bit integer exists, you need
 * to return -1.
 * 
 * Example 1:
 * 
 * Input: 12 Output: 21
 * 
 * 
 * Example 2:
 * 
 * Input: 21 Output: -1
 * 
 * 
 * 
 * @author skadavath
 *
 */
public class NextGreaterElement3 {
	
	public static void main(String[] args) {
		System.out.println(new NextGreaterElement3().nextGreaterElement(2145761));
	}
	
	/*
	 * 
	 * Say the number is 2145761 , the answer is 2146157
	 * So , start from right , and find a number like num[i-1]<num[i] else no solution
	 * Here its 5 since its smaller than 7
	 * Now find a larger number to the right just larger than 5 , which here is 6 . Now swap it
	 * Sort the remaining number right of 6 after swapping 
	 * 
	 * 
	 */
	public int nextGreaterElement(int n) {
		
		char[] numChar = String.valueOf(n).toCharArray();
		
		int i=numChar.length;
		for(i=numChar.length-1;i>0;i--)
			if(numChar[i-1]<numChar[i])
				break;
		
		if(i==0)
			return -1;//no solution
		
		int smallestIndex = i;
		
		for(int j=i+1;j<numChar.length;j++) {
			if(numChar[j]>numChar[i-1] && numChar[j]<=numChar[smallestIndex]) {
				smallestIndex = j;
			}
		}
		
		char temp = numChar[smallestIndex];
		numChar[smallestIndex] = numChar[i-1];
		numChar[i-1] = temp;
		
		Arrays.sort(numChar, i, numChar.length);
		
		return (int)Long.parseLong(new String(numChar));

	}

}
