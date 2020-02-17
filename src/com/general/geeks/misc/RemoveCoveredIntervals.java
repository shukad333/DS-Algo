package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given a list of intervals, remove all intervals that are covered by another interval in the list. Interval [a,b) is covered by interval [c,d) if and only if c <= a and b <= d.

After doing so, return the number of remaining intervals.

 

Example 1:

Input: intervals = [[1,4],[3,6],[2,8]]
Output: 2
Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.
 

Constraints:

1 <= intervals.length <= 1000
0 <= intervals[i][0] < intervals[i][1] <= 10^5
intervals[i] != intervals[j] for all i != j
 * 
 * @author skadavath
 *
 */
public class RemoveCoveredIntervals {

	public int removeCoveredIntervals(int[][] intervals) {

		Arrays.sort(intervals, (a, b) -> (a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]));

		int start = intervals[0][0], end = intervals[0][1];
		int count = 1;
		for (int i = 1; i < intervals.length; i++) {

			if (start <= intervals[i][0] && end >= intervals[i][1]) {

				continue;

			}
			start = intervals[i][0];
			end = intervals[i][1];
			count++;

		}
		return count;

	}

}
