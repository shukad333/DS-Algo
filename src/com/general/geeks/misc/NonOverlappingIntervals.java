package com.general.geeks.misc;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a collection of intervals, find the minimum number of intervals you
 * need to remove to make the rest of the intervals non-overlapping.
 * 
 * Note: You may assume the interval's end point is always bigger than its start
 * point. Intervals like [1,2] and [2,3] have borders "touching" but they don't
 * overlap each other. Example 1: Input: [ [1,2], [2,3], [3,4], [1,3] ]
 * 
 * Output: 1
 * 
 * Explanation: [1,3] can be removed and the rest of intervals are
 * non-overlapping. Example 2: Input: [ [1,2], [1,2], [1,2] ]
 * 
 * Output: 2
 * 
 * Explanation: You need to remove two [1,2] to make the rest of intervals
 * non-overlapping. Example 3: Input: [ [1,2], [2,3] ]
 * 
 * Output: 0
 * 
 * Explanation: You don't need to remove any of the intervals since they're
 * already non-overlapping.
 * 
 * @author skadavath
 *
 */
public class NonOverlappingIntervals {

	public static void main(String[] args) {
		Interval i1 = new Interval(2, 3);
		Interval i2 = new Interval(1, 2);
		Interval i3 = new Interval(3, 4);
		 //System.out.println(new NonOverlappingIntervals().eraseOverlapIntervals(new Interval[]{i1,i2,i3}));
		System.out.println(new NonOverlappingIntervals().eraseOverlapIntervals(new Interval[]{}));

	}

	public int eraseOverlapIntervals(Interval[] intervals) {
		
		if(0==intervals.length) {
			return 0; 
		}
		Arrays.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {

				return o1.end - o2.end;
			}
		});
		
		int end = intervals[0].end;
		int count = 1;
		for(int i=1;i<intervals.length;i++) {
			if(intervals[i].start>=end) {
				end = intervals[i].end;
				count++;
			}
		}
		return intervals.length-count;

	}

}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "start:"+start+" end:"+end;
	}

}
