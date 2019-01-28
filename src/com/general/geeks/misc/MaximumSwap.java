package com.general.geeks.misc;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-negative integer, you could swap two digits at most once to get
 * the maximum valued number. Return the maximum valued number you could get.
 * 
 * Example 1: Input: 2736 Output: 7236 Explanation: Swap the number 2 and the
 * number 7. Example 2: Input: 9973 Output: 9973 Explanation: No swap. Note: The
 * given number is in the range [0, 108]
 * 
 * @author skadavath
 *
 */
public class MaximumSwap {
	
	public static void main(String[] args) {
		System.out.println(new MaximumSwap().maximumSwap(11119111));
	}

	public int maximumSwap(int num) {
		
		Map<Integer, Integer> map = new HashMap<>();
		char[] numChar = String.valueOf(num).toCharArray();
		for(int i=0;i<numChar.length;i++)
			map.put(numChar[i]-'0', i);
		
		
		for(int i=0;i<numChar.length;i++) {
			for(int k=9;k>numChar[i]-'0';k--) {
				if(null!=map.get(k) && map.get(k)>i) {
					int otherPos = map.get(k);
					char temp = numChar[otherPos];
					numChar[otherPos] = numChar[i];
					numChar[i] = temp;
					return Integer.parseInt(String.valueOf(numChar));
				}
			}
		}
		return num;
	}

}
