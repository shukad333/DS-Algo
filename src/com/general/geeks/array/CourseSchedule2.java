package com.general.geeks.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

Example 1:

Input: 2, [[1,0]] 
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished   
             course 0. So the correct course order is [0,1] .
Example 2:

Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both     
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. 
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.

 * @author skadavath
 *
 */
public class CourseSchedule2 {
	
	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(new CourseSchedule2().findOrder(4, new int[][] {{1,0},{2,0},{3,1},{3,2}})));
	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		
		//create a graph first
		List<List<Integer>> adjList = new ArrayList<>();
		int[] courseCount = new int[numCourses];
		
		int i=numCourses;
		while(i-->=0) {
			adjList.add(new ArrayList<>());
			
		}
		
		for(int[] pre : prerequisites) {
			courseCount[pre[0]]++;
			adjList.get(pre[1]).add(pre[0]);
		}
		
		Queue<Integer> queue = new LinkedList<>();
		for(i=0;i<numCourses;i++) {
			if(courseCount[i]==0)queue.offer(i);
		}
		
		i=0;
		int[] resp = new int[numCourses];
		
		while(!queue.isEmpty()) {
			
			int from = queue.poll();
			resp[i++] = from;
			
			for(int to : adjList.get(from)) {
				courseCount[to]--;
				if(courseCount[to]==0)
					queue.offer(to);
				else if(courseCount[to]<0) {
					return new int[] {0};
				}
			}
			
		}
		
		
		
		
		return numCourses == i ? resp : new int[0];

	}

}
