package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given a sorted list of disjoint intervals, each interval intervals[i] = [a, b] represents the set of real numbers x such that a <= x < b.

We remove the intersections between any interval in intervals and the interval toBeRemoved.

Return a sorted list of intervals after all such removals.

 

Example 1:

Input: intervals = [[0,2],[3,4],[5,7]], toBeRemoved = [1,6]
Output: [[0,1],[6,7]]
Example 2:

Input: intervals = [[0,5]], toBeRemoved = [2,3]
Output: [[0,2],[3,5]]
 

Constraints:

1 <= intervals.length <= 10^4
-10^9 <= intervals[i][0] < intervals[i][1] <= 10^9
 * 
 * @author skadavath
 *
 */
public class RemoveInterval {
	
	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder();
		
		
	}
	
	public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
		
		List<List<Integer>> resp = new ArrayList<>();
		
		for(int[] interval : intervals) {
			
			if(interval[1]<=toBeRemoved[0] || interval[0]>=toBeRemoved[1]) {
				resp.add(Arrays.asList(interval[0],interval[1]));
			}
			else {
				if(interval[0]<=toBeRemoved[0])
					resp.add(Arrays.asList(interval[0],toBeRemoved[0]));
				if(interval[1]>toBeRemoved[1])
					resp.add(Arrays.asList(toBeRemoved[1],interval[1]));
			}
		}
		
		return resp;
		

	}

}
