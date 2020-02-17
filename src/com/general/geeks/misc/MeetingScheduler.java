package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 
 * 
 * Given the availability time slots arrays slots1 and slots2 of two people and a meeting duration duration, return the earliest time slot that works for both of them and is of duration duration.

If there is no common time slot that satisfies the requirements, return an empty array.

The format of a time slot is an array of two elements [start, end] representing an inclusive time range from start to end.  

It is guaranteed that no two availability slots of the same person intersect with each other. That is, for any two time slots [start1, end1] and [start2, end2] of the same person, either start1 > end2 or start2 > end1.

 

Example 1:

Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 8
Output: [60,68]
Example 2:

Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 12
Output: []
 

Constraints:

1 <= slots1.length, slots2.length <= 10^4
slots1[i].length, slots2[i].length == 2
slots1[i][0] < slots1[i][1]
slots2[i][0] < slots2[i][1]
0 <= slots1[i][j], slots2[i][j] <= 10^9
1 <= duration <= 10^6 
 * 
 * @author skadavath
 *
 */
public class MeetingScheduler {
	
	public static void main(String[] args) {
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
		int[][] arr = {{10,50},{60,120},{140,210},{1,2}};
		for(int[] a : arr)
			pq.offer(a);
		
		while(!pq.isEmpty()) {
			System.out.println(Arrays.toString(pq.poll()));
		}
		
		List<Integer> resp;
		
		
	}

	public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
		
		for(int[] s1:slots1)
			if(s1[1]-s1[0]>=duration)
				pq.offer(s1);
		for(int[] s1:slots2)
			if(s1[1]-s1[0]>=duration)
				pq.offer(s1);
		
		while(pq.size()>1) {
			int[] polled = pq.poll();
			if(polled[1]>=duration+pq.peek()[0])
				return Arrays.asList(pq.peek()[0],pq.peek()[0]+duration);
		}
		
		return new ArrayList<>();

	}

}
