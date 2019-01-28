package com.general.geeks.misc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * Given a set of points in the xy-plane, determine the minimum area of a rectangle formed from these points, with sides parallel to the x and y axes.

If there isn't any rectangle, return 0.

 

Example 1:

Input: [[1,1],[1,3],[3,1],[3,3],[2,2]]
Output: 4
Example 2:

Input: [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
Output: 2
 

Note:

1 <= points.length <= 500
0 <= points[i][0] <= 40000
0 <= points[i][1] <= 40000
All points are distinct.
Seen this question in a real interview before?  

 * 
 * @author skadavath
 *
 */
public class MinimumAreaRectangle {
	
	public static void main(String[] args) {
		
		System.out.println(new MinimumAreaRectangle().minAreaRect(new int[][] {{1,1},{1,3},{3,1},{3,3},{2,2}}));
	}
	
	 public int minAreaRect(int[][] points) {
		 
		 
		 Map<Integer,Set<Integer>> map = new HashMap<>();
		 for(int[] p : points) {
			 
			  if(map.get(p[0])==null)
				  map.put(p[0], new HashSet<>());
			  map.get(p[0]).add(p[1]);
		 }
		 
		 int min = Integer.MAX_VALUE;
		 for(int[] p1 : points) {
			 for(int[] p2 : points) {
				 
				 if(p1[0]==p2[0] || p1[1]==p2[1])
					 continue;
				 
				 if(map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1])) {
					 min = Math.min(min, Math.abs(p1[0]-p2[0]) * Math.abs(p1[1]-p2[1]));
				 }
			 }
		 }
		 
		 
		 
		 return min==Integer.MAX_VALUE?0 : min;
	      
	 }

}
