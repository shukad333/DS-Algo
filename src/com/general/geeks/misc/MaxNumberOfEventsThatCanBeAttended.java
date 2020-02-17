package com.general.geeks.misc;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 
 * Given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends at endDayi.

You can attend an event i at any day d where startTimei <= d <= endTimei. Notice that you can only attend one event at any time d.

Return the maximum number of events you can attend.

 
 
 Input: events = [[1,2],[2,3],[3,4]]
Output: 3
Explanation: You can attend all the three events.
One way to attend them all is as shown.
Attend the first event on day 1.
Attend the second event on day 2.
Attend the third event on day 3.
Example 2:

Input: events= [[1,2],[2,3],[3,4],[1,2]]
Output: 4
Example 3:

Input: events = [[1,4],[4,4],[2,2],[3,4],[1,1]]
Output: 4
Example 4:

Input: events = [[1,100000]]
Output: 1
Example 5:

Input: events = [[1,1],[1,2],[1,3],[1,4],[1,5],[1,6],[1,7]]
Output: 7
 

Constraints:

1 <= events.length <= 10^5
events[i].length == 2
1 <= events[i][0] <= events[i][1] <= 10^5
 * 
 * @author skadavath
 *
 */
public class MaxNumberOfEventsThatCanBeAttended {
	
	public static void main(String[] args) {
		
		int[][] events = new int[][] {{1,4},{4,4},{2,2},{3,4},{1,1},{1,1}};
		System.out.println(new MaxNumberOfEventsThatCanBeAttended().maxEvents(events));
		
	}

	public int maxEvents(int[][] events) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Arrays.sort(events,(a,b)->a[0]-b[0]);
		
		int j=0,resp=0;
		for(int i=1;i<10000;i++) {
			
			while(j<events.length && events[j][0]==i) {
				pq.offer(events[j++][1]);
			}
			
			while(pq.size()>0 && pq.peek()<i) {
				pq.poll();
			}
			
			if(!pq.isEmpty()) {
				resp++;
				pq.poll();
			}
			
		}
		return resp;

	}

}
