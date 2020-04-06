package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 
 * Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * 
 * @author skadavath
 *
 */
public class TopKFrequentElements {
	
	
//	public List<Integer> topKFrequent(int[] nums, int k) {
//
//		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b)-> b.getValue()-a.getValue());
//
//		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//		for(int n : nums) {
//			map.putIfAbsent(n, 0);
//			map.put(n, map.get(n)+1);
//		}
//
//		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
//			pq.offer(entry);
//		}
//
//		List<Integer> resp = new ArrayList<Integer>();
//
//		while(resp.size()<k) {
//			Map.Entry<Integer, Integer> entry = pq.poll();
//			resp.add(entry.getKey());
//
//		}
//
//
//	}

}
