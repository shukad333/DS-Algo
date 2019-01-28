package com.general.geeks.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * There are n different online courses numbered from 1 to n. Each course has
 * some duration(course length) t and closed on dth day. A course should be
 * taken continuously for t days and must be finished before or on the dth day.
 * You will start at the 1st day.
 * 
 * Given n online courses represented by pairs (t,d), your task is to find the
 * maximal number of courses that can be taken.
 * 
 * Example: Input: [[100, 200], [200, 1300], [1000, 1250], [2000, 3200]] Output:
 * 3 Explanation: There're totally 4 courses, but you can take 3 courses at
 * most: First, take the 1st course, it costs 100 days so you will finish it on
 * the 100th day, and ready to take the next course on the 101st day. Second,
 * take the 3rd course, it costs 1000 days so you will finish it on the 1100th
 * day, and ready to take the next course on the 1101st day. Third, take the 2nd
 * course, it costs 200 days so you will finish it on the 1300th day. The 4th
 * course cannot be taken now, since you will finish it on the 3300th day, which
 * exceeds the closed date. Note: The integer 1 <= d, t, n <= 10,000. You can't
 * take two courses simultaneously.
 * 
 * 
 * @author skadavath
 *
 */
public class CourseSchedule3 {

	public static void main(String[] args) {
		
		PriorityQueue<int[]> timePQ = new PriorityQueue<>((a, b) -> b[0] - a[0]);
		
		timePQ.offer(new int[] {4,3});
		timePQ.offer(new int[] {1,2});
		timePQ.offer(new int[] {5,2});
		//System.out.println(Arrays.toString(timePQ.peek()));
		System.out.println(new CourseSchedule3().scheduleCourse(new int[][] {{100,2},{32,50}}));
	}

	public int scheduleCourse(int[][] courses) {

		PriorityQueue<int[]> coursePQ = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		PriorityQueue<int[]> timePQ = new PriorityQueue<>((a, b) -> b[0] - a[0]);

		for (int[] course : courses) {

			coursePQ.offer(course);

		}

		int currTime = 0;
		while(!coursePQ.isEmpty()) {
			
			int[] course = coursePQ.poll();
			currTime += course[0];
			
			timePQ.offer(course);
			
			if(currTime>course[1]) {
				currTime -= timePQ.poll()[0];
			}
			
			

		}

		return timePQ.size();

	}

}
