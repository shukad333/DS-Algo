package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given two lists of closed intervals, each list of intervals is pairwise
 * disjoint and in sorted order.
 * 
 * Return the intersection of these two interval lists.
 * 
 * (Formally, a closed interval [a, b] (with a <= b) denotes the set of real
 * numbers x with a <= x <= b. The intersection of two closed intervals is a set
 * of real numbers that is either empty, or can be represented as a closed
 * interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
 * 
 * 
 * 
 * Example 1: Input: A = [[0,2],[5,10],[13,23],[24,25]], B =
 * [[1,5],[8,12],[15,24],[25,26]] Output:
 * [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]] Reminder: The inputs and the
 * desired output are lists of Interval objects, and not arrays or lists.
 * 
 * 
 * @author skadavath
 *
 */
public class IntervalListIntersections {
	
	public static void main(String[] args) {
		
		IntervalA[] A = new IntervalA[] {new IntervalA(0,2),new IntervalA(5,10),new IntervalA(13,23),new IntervalA(24,25)};
		IntervalA[] B = new IntervalA[] {new IntervalA(1,5),new IntervalA(8,12),new IntervalA(15,24),new IntervalA(25,26)};
		
		System.out.println(new IntervalListIntersections().intervalIntersection(A, B));
	}

	public IntervalA[] intervalIntersection(IntervalA[] A, IntervalA[] B) {
		
		int i=0,j=0;
		
		List<IntervalA> resp = new ArrayList<>();
		while(i<A.length && j<B.length) {
			
			IntervalA first = A[i];
			IntervalA second = B[j];
			
			int maxStart = Math.max(first.start, second.start);
			int minEnd = Math.min(first.end, second.end);
			
			
			if(minEnd>=maxStart) {
				resp.add(new IntervalA(maxStart,minEnd));
			}
			
			if(minEnd==first.end)i++;
			if(minEnd==second.end)j++;
			
		}
		
		IntervalA[] respArr = new IntervalA[resp.size()];
		for(int k=0;j<resp.size();j++) {
			respArr[k] = resp.get(k);
		}

		return respArr;

	}

}

class IntervalA {
	int start;
	int end;

	IntervalA() {
		start = 0;
		end = 0;
	}

	IntervalA(int s, int e) {
		start = s;
		end = e;
	}

}

/**
 * Definition for an interval. public class Interval { int start; int end;
 * Interval() { start = 0; end = 0; } Interval(int s, int e) { start = s; end =
 * e; } }
 */
