package com.general.geeks.misc;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * 
 * In a list of songs, the i-th song has a duration of time[i] seconds. 

Return the number of pairs of songs for which their total duration in seconds is divisible by 60.  Formally, we want the number of indices i < j with (time[i] + time[j]) % 60 == 0.

 

Example 1:

Input: [30,20,150,100,40]
Output: 3
Explanation: Three pairs have a total duration divisible by 60:
(time[0] = 30, time[2] = 150): total duration 180
(time[1] = 20, time[3] = 100): total duration 120
(time[1] = 20, time[4] = 40): total duration 60
Example 2:

Input: [60,60,60]
Output: 3
Explanation: All three pairs have a total duration of 120, which is divisible by 60.
 

Note:

1 <= time.length <= 60000
1 <= time[i] <= 500
 * 
 * @author skadavath
 *
 */
public class PairsofSongsWithTotalDurationsDivisibleby60 {
	
	public static void main(String[] args) {
		
		Map<Integer, Integer> m = new LinkedHashMap<>();
		m.put(1, 11);
		m.put(4, 44);
		m.put(3, 33);
		m.put(4, 44);
		
		System.out.println(m);
		System.out.println(new PairsofSongsWithTotalDurationsDivisibleby60().numPairsDivisibleBy60(new int[] {30,20,150,100,40}));
		
	}

	public int numPairsDivisibleBy60(int[] time) {
		
		Map<Integer, Integer> map = new LinkedHashMap<>();
		
		int sum = 0;
		for(int t : time) {
			
			int other = (60-t%60)%60;//last % for tracks which have length exactly 60
			
			if(map.containsKey(other))
				sum+=map.get(other);
			map.put(t%60, map.getOrDefault(t%60, 0)+1);
			
		}
		
		return sum;

	}

}
