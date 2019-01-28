package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * Example 1:
 * 
 * Input: [[1,3],[2,6],[8,10],[15,18]] Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 * 
 * Input: [[1,4],[4,5]] Output: [[1,5]] Explanation: Intervals [1,4] and [4,5]
 * are considerred overlapping.
 * 
 * @author skadavath
 *
 */
public class MergeIntervals {
	
	public static void main(String[] args) {
		List<Interval> list = new ArrayList<>();
		Interval interval = new Interval(1,3);
		list.add(interval);
		interval = new Interval(2,6);
		list.add(interval);
		interval = new Interval(8,10);
		list.add(interval);
		interval = new Interval(15,18);
		list.add(interval);
		System.out.println(new MergeIntervals().merge(list));
	}

	public List<Interval> merge(List<Interval> intervals) {
		
		List<Interval> resp = new ArrayList<>();
		
		intervals.sort((i1,i2) -> i1.start-i2.start);
		
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		
		for(Interval interval : intervals) {
			if(interval.start<=end) {
				end = Math.max(interval.end, end);
			}
			else {
				resp.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;
			}
		}
		
		//last one
		resp.add(new Interval(start,end));
		return resp;

	}

}
