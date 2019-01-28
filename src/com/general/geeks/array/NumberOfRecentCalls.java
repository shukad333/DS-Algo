package com.general.geeks.array;

import java.util.Map;
import java.util.TreeMap;

/**
 * Write a class RecentCounter to count recent requests.

It has only one method: ping(int t), where t represents some time in milliseconds.

Return the number of pings that have been made from 3000 milliseconds ago until now.

Any ping with time in [t - 3000, t] will count, including the current ping.

It is guaranteed that every call to ping uses a strictly larger value of t than before.

 

Example 1:

Input: inputs = ["RecentCounter","ping","ping","ping","ping"], inputs = [[],[1],[100],[3001],[3002]]
Output: [null,1,2,3,3]
 

Note:

Each test case will have at most 10000 calls to ping.
Each test case will call ping with strictly increasing values of t.
Each call to ping will have 1 <= t <= 10^9.

 * 
 * @author skadavath
 *
 */
public class NumberOfRecentCalls {
	
	public static void main(String[] args) {
		
		NumberOfRecentCalls num = new NumberOfRecentCalls();
		System.out.println(num.ping(1));
		System.out.println(num.ping(100));
		System.out.println(num.ping(3001));
		System.out.println(num.ping(3002));
		
	}
	
	TreeMap<Integer, Integer> map = new TreeMap<>();
	
	public NumberOfRecentCalls() {
		
		

	}

	public int ping(int t) {
		
		map.put(t, map.size()+1);
		Map<Integer, Integer> m1 = map.tailMap(t-3000);
		return map.tailMap(t-3000).size();

	}

}
