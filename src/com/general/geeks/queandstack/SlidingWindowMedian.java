package com.general.geeks.queandstack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

Examples: 
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Your job is to output the median array for each window in the original array.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Median
---------------               -----
[1  3  -1] -3  5  3  6  7       1
 1 [3  -1  -3] 5  3  6  7       -1
 1  3 [-1  -3  5] 3  6  7       -1
 1  3  -1 [-3  5  3] 6  7       3
 1  3  -1  -3 [5  3  6] 7       5
 1  3  -1  -3  5 [3  6  7]      6
Therefore, return the median sliding window as [1,-1,-1,3,5,6].

Note: 
You may assume k is always valid, ie: k is always smaller than input array's size for non-empty array.
 * 
 * @author skadavath
 *
 */
public class SlidingWindowMedian {
	
	public static void main(String[] args) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(4);
		pq.offer(9);
		pq.offer(1);
		
		System.out.println(pq.poll());
		System.out.println(pq.peek());
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
			
		});
		
		maxHeap.add(2);
		maxHeap.add(10);
		maxHeap.add(4);
		
		System.out.println(maxHeap.poll());
		System.out.println(maxHeap.poll());
		
		List<String> list = new ArrayList<>();
		
		System.out.println(list.stream().anyMatch(l->l.equals("Nooru")));
		
	}

	public double[] medianSlidingWindow(int[] nums, int k) {
		
		double[] resp = new double[nums.length];
		
		return resp;

	}

}
