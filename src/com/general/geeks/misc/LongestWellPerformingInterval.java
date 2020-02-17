package com.general.geeks.misc;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * We are given hours, a list of the number of hours worked per day for a given employee.

A day is considered to be a tiring day if and only if the number of hours worked is (strictly) greater than 8.

A well-performing interval is an interval of days for which the number of tiring days is strictly larger than the number of non-tiring days.

Return the length of the longest well-performing interval.

 

Example 1:

Input: hours = [9,9,6,0,6,6,9]
Output: 3
Explanation: The longest well-performing interval is [9,9,6].
 

Constraints:

1 <= hours.length <= 10000
0 <= hours[i] <= 16

 * 
 * @author skadavath
 *
 */
public class LongestWellPerformingInterval {
	
	public static void main(String[] args) {
		
		System.out.println(new LongestWellPerformingInterval().longestWPI(new int[] {9,9,6,0,6,6,6,6,6,9,10,11}));
		
	}

	public int longestWPI(int[] hours) {
		
		int resp = 0;
		int currScore = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<hours.length;i++) {
			
			if(hours[i]>8)
				currScore++;
			else
				currScore--;
			
			if(currScore>0) {
				resp = i+1;
			}
			else {
				map.putIfAbsent(currScore, i);
				if(map.containsKey(currScore-1)) {
					resp = Math.max(resp, i-map.get(currScore-1));
				}
			}
			
		}
		
		return resp;

	}

}
