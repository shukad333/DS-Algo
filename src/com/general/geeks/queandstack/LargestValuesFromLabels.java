package com.general.geeks.queandstack;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 
 * We have a set of items: the i-th item has value values[i] and label labels[i].

Then, we choose a subset S of these items, such that:

|S| <= num_wanted
For every label L, the number of items in S with label L is <= use_limit.
Return the largest possible sum of the subset S.

 

Example 1:

Input: values = [5,4,3,2,1], labels = [1,1,2,2,3], num_wanted = 3, use_limit = 1
Output: 9
Explanation: The subset chosen is the first, third, and fifth item.
Example 2:

Input: values = [5,4,3,2,1], labels = [1,3,3,3,2], num_wanted = 3, use_limit = 2
Output: 12
Explanation: The subset chosen is the first, second, and third item.
Example 3:

Input: values = [9,8,8,7,6], labels = [0,0,0,1,1], num_wanted = 3, use_limit = 1
Output: 16
Explanation: The subset chosen is the first and fourth item.
Example 4:

Input: values = [9,8,8,7,6], labels = [0,0,0,1,1], num_wanted = 3, use_limit = 2
Output: 24
Explanation: The subset chosen is the first, second, and fourth item.
 
 * 
 * @author skadavath
 *
 */
public class LargestValuesFromLabels {
	
	public static void main(String[] args) {
		
		System.out.println(new LargestValuesFromLabels().largestValsFromLabels(new int[] {9,8,8,7,6}, new int[] {0,0,0,1,1}, 3, 1));
		
	}
	
public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
	
	PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0]-a[0]);
	
	Map<Integer, Integer> map = new HashMap<>();
	for(int i=0;i<labels.length;i++) {
		if(!map.containsKey(labels[i]))
				map.put(labels[i], 0);
		
		pq.add(new int[] {values[i],labels[i]});
		
		
		
	}
	
	int max = 0;
	for(int i=0;i<num_wanted && !pq.isEmpty();) {
		
		int[] pair = pq.poll();
		
		if(map.get(pair[1])<use_limit) {
			max+=pair[0];
			map.put(pair[1], map.get(pair[1])+1);
			i++;
		}
		
		
		
	}
	
	return max;
        
    }

}
