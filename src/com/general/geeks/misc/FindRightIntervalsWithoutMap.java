package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * 
 * Given a set of intervals, for each of the interval i, check if there exists an interval j whose start point is bigger than or equal to the end point of the interval i, which can be called that j is on the "right" of i.

For any interval i, you need to store the minimum interval j's index, which means that the interval j has the minimum start point to build the "right" relationship for interval i. If the interval j doesn't exist, store -1 for the interval i. Finally, you need output the stored value of each interval as an array.

Note:
You may assume the interval's end point is always bigger than its start point.
You may assume none of these intervals have the same start point.
Example 1:
Input: [ [1,2] ]

Output: [-1]

Explanation: There is only one interval in the collection, so it outputs -1.
Example 2:
Input: [ [3,4], [2,3], [1,2] ]

Output: [-1, 0, 1]

Explanation: There is no satisfied "right" interval for [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point;
For [1,2], the interval [2,3] has minimum-"right" start point.
Example 3:
Input: [ [1,4], [2,3], [3,4] ]

Output: [-1, 2, -1]

Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point.
 * 
 * @author skadavath
 *
 */
public class FindRightIntervalsWithoutMap {
	
	public static void main(String[] args) {
		
//		List<String> resp = new ArrayList<>();
//		resp.stream().findAny().get();
		
		Interval[] intervals = new Interval[3];
		Interval inter = new Interval(3, 4);
		intervals[0] = inter;
		
		inter = new Interval(2, 3);
		intervals[1] = inter;
		
		inter = new Interval(1, 2);
		intervals[2] = inter;
		
		System.out.println(Arrays.toString(new FindRightIntervalsWithoutMap().findRightIntervalTreeMap(intervals)));
		
	}
	
	
	public static void entho() {
		
	}
	
	public int[] findRightIntervalTreeMap(Interval[] intervals) {
		
		NavigableMap<Integer, Integer> map = new TreeMap<>();
		
		int j=0;
		for(Interval interval : intervals) {
			map.put(interval.start, j++);
		}
		
		j=0;
		int[] resp = new int[intervals.length];
		
		for(Interval interval : intervals) {
			
			Integer closest = map.ceilingKey(interval.end);
			resp[j++] = null==closest?-1:map.get(closest);
		}
		
		return resp;
		
	}

	public int[] findRightInterval(Interval[] intervals) {
		
		List<Integer> starts = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		
		int j=0;
		for(Interval interval : intervals) {
			starts.add(interval.start);
			map.put(interval.start, j++);
		}
		
		Collections.sort(starts);
		
		
		int[] resp = new int[intervals.length];
		
		int i=0;
		for(Interval interval : intervals) {
			int closestStart = binarySearch(starts, interval.end);
			if(closestStart<interval.end) {
				resp[i] = -1;
			}
			else
				resp[i] = map.get(closestStart);
			
			i++;
		}
		
		return resp;

	}
	
	
	private int binarySearch(List<Integer> starts , int end) {
		
		int left=0,right = starts.size()-1;
		
		while(left<right) {
			
			int mid = (left+right)>>1;
		if(starts.get(mid)<end) {
			left = mid+1;
		}
		else
			right=mid;
			
		}
		
		return starts.get(left);
	}

}
