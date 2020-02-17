package com.general.geeks.misc;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * You are driving a vehicle that has capacity empty seats initially available for passengers.  The vehicle only drives east (ie. it cannot turn around and drive west.)

Given a list of trips, trip[i] = [num_passengers, start_location, end_location] contains information about the i-th trip: the number of passengers that must be picked up, and the locations to pick them up and drop them off.  The locations are given as the number of kilometers due east from your vehicle's initial location.

Return true if and only if it is possible to pick up and drop off all passengers for all the given trips. 

 

Example 1:

Input: trips = [[2,1,5],[3,3,7]], capacity = 4
Output: false
Example 2:

Input: trips = [[2,1,5],[3,3,7]], capacity = 5
Output: true
Example 3:

Input: trips = [[2,1,5],[3,5,7]], capacity = 3
Output: true
Example 4:

Input: trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
Output: true
 * 
 * @author skadavath
 *
 */
public class CarPooling {

	public boolean carPooling(int[][] trips, int capacity) {
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int[] t : trips) {
			map.put(t[1], map.getOrDefault(t[1], 0)+t[0]);
			map.put(t[2], map.getOrDefault(t[1], 0)-t[0]);
		}
		
		
		for(int v : map.values()) {
			capacity-=v;
			if(capacity<0)
				return false;
		}
		
		return true;

	}

}
