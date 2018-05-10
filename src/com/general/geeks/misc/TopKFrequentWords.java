package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a non-empty list of words, return the k most frequent elements.
 * 
 * Your answer should be sorted by frequency from highest to lowest. If two
 * words have the same frequency, then the word with the lower alphabetical
 * order comes first.
 * 
 * Example 1: Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"] Explanation: "i" and "love" are the two most frequent
 * words. Note that "i" comes before "love" due to a lower alphabetical order.
 * Example 2: Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny",
 * "is", "is"], k = 4 Output: ["the", "is", "sunny", "day"] Explanation: "the",
 * "is", "sunny" and "day" are the four most frequent words, with the number of
 * occurrence being 4, 3, 2 and 1 respectively. Note: You may assume k is always
 * valid, 1 ≤ k ≤ number of unique elements. Input words contain only lowercase
 * letters. Follow up: Try to solve it in O(n log k) time and O(n) extra space.
 * 
 * @author skadavath
 *
 */
public class TopKFrequentWords {
	
	public static void main(String[] args) {
		
		System.out.println(new TopKFrequentWords().topKFrequent(new String[] {"i", "love", "leetcode", "i", "love", "coding"},4));
		
	}
	
	
	public List<String> topKFrequent(String[] words, int k) {
		
		Map<String, Integer> map = new HashMap();
		for(String s : words) {
			if(!map.containsKey(s)) {
				map.put(s, 1);
			}
			else {
				map.put(s, map.get(s)+1);
			}
		}
		
		PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(
                (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue()
       );
		
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			queue.offer(entry);
			if(queue.size()>k) {
				queue.poll();
			}
		}
		
		List<String> list = new LinkedList();
		while(!queue.isEmpty()) {
			list.add(0, queue.poll().getKey());
		}
		return list;
	}

}
