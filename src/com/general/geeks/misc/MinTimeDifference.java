package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a list of 24-hour clock time points in "Hour:Minutes" format, find the
 * minimum minutes difference between any two time points in the list. Example
 * 1: Input: ["23:59","00:00"] Output: 1 Note: The number of time points in the
 * given list is at least 2 and won't exceed 20000. The input time is legal and
 * ranges from 00:00 to 23:59.
 * 
 * @author skadavath
 *
 */
public class MinTimeDifference {
	
	public static void main(String[] args) {
		System.out.println(new MinTimeDifference().findMinDifference(Arrays.asList("23:59","00:00")));
	}

	public int findMinDifference(List<String> timePoints) {
		
		int min = Integer.MAX_VALUE;
		
		List<Integer> times = new ArrayList<>();
		
		for(String p : timePoints) {
			String[] point = p.split(":");
			times.add((Integer.parseInt(point[0])*60)+Integer.parseInt(point[1]));
		}
		
		Collections.sort(times);
		
		for(int i=1;i<times.size();i++) {
			
			int diff = times.get(i) - times.get(i-1);
			min = Math.min(diff, min);
		}
		
		int cornerCase = times.get(0) + 24*60-times.get(times.size()-1);
		return Math.min(cornerCase, min);

	}

}
