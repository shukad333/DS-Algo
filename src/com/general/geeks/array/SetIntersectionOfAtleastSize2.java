package com.general.geeks.array;

import java.util.Arrays;
import java.util.Stack;

/**
 * 
 * An integer interval [a, b] (for integers a < b) is a set of all consecutive
 * integers from a to b, including a and b.
 * 
 * Find the minimum size of a set S such that for every integer interval A in
 * intervals, the intersection of S with A has size at least 2.
 * 
 * Example 1: Input: intervals = [[1, 3], [1, 4], [2, 5], [3, 5]] Output: 3
 * Explanation: Consider the set S = {2, 3, 4}. For each interval, there are at
 * least 2 elements from S in the interval. Also, there isn't a smaller size set
 * that fulfills the above condition. Thus, we output the size of this set,
 * which is 3. Example 2: Input: intervals = [[1, 2], [2, 3], [2, 4], [4, 5]]
 * Output: 5 Explanation: An example of a minimum sized set is {1, 2, 3, 4, 5}.
 * Note:
 * 
 * intervals will have length in range [1, 3000]. intervals[i] will have length
 * 2, representing some integer interval. intervals[i][j] will be an integer in
 * [0, 10^8].
 * 
 * 
 * @author skadavath
 *
 */
public class SetIntersectionOfAtleastSize2 {
	
	
	public static void main(String[] args) {
		
		System.out.println(new SetIntersectionOfAtleastSize2().intersectionSizeTwo(new int[][] {{1, 3}, {1, 4}, {2, 5}, {3, 5}}));
		
	}

	public int intersectionSizeTwo(int[][] intervals) {

		Arrays.sort(intervals, (a, b) -> ((a[0] == b[0]) ? b[1] - a[0] : a[0] - b[0]));

		Stack<int[]> stack = new Stack<>();

		for (int[] interval : intervals) {
			while (!stack.isEmpty() && stack.peek()[1] >= interval[1])
				stack.pop();

			stack.push(interval);
		}
		
		int size = stack.size();
		
		int[][] intervalNew = new int[size][2];
		
		for(int i=size-1;i>=0;i--) {
			intervalNew[i][0] = stack.peek()[0];
			intervalNew[i][1] = stack.pop()[1];
			
		}
		
		
		int first = intervalNew[0][1]-1,second = intervalNew[0][1];
		int resp = 2;
		for(int i=1;i<size;i++) {
			
			boolean isFirst = (first>=intervalNew[i][0] && first<=intervalNew[i][1]);
			boolean isSecond = (second>=intervalNew[i][0] && second<=intervalNew[i][1]);
			
			if(isFirst && isSecond)
				continue; //skip to next since we already have the numbers p1 and p2
			
			if(isSecond) {
				
				resp++;
				first = second;
				second = intervalNew[i][1];
				continue;
				
			}
			
			first = intervalNew[i][1]-1;
			second = intervalNew[i][1];
			resp+=2;
			
		}

		return resp;

	}

}
