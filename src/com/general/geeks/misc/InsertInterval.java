package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

 * @author skadavath
 *
 */
public class InsertInterval {
	
	public static void main(String[] args) {
		
		List<Interval> list = new ArrayList<>();
		Interval interval = new Interval(1,2);
		list.add(interval);
		interval = new Interval(3,5);
		list.add(interval);
		interval = new Interval(6,7);
		list.add(interval);
		interval = new Interval(8,10);
		list.add(interval);
		interval = new Interval(12,16);
		list.add(interval);
		
		System.out.println(new InsertInterval().insert(list, new Interval(4,8)));
	}

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		
		List<Interval> resp = new ArrayList<>();
		
		int i=0;
		while(i<intervals.size() && intervals.get(i).end<newInterval.start) {
			resp.add(intervals.get(i++));
		}
		
		//we found the place to insert now 
		
		while(i<intervals.size() && newInterval.end>=intervals.get(i).start) {
			newInterval = new Interval(Math.min(intervals.get(i).start, newInterval.start),Math.max(intervals.get(i).end, newInterval.end));
			i++;
		}
		
		resp.add(newInterval);
		//add remaining
		
		while(i<intervals.size()) {
			resp.add(intervals.get(i++));
		}
		
		return resp;

	}

}
