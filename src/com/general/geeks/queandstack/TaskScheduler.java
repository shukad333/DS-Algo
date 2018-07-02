package com.general.geeks.queandstack;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given a char array representing tasks CPU need to do. It contains capital
 * letters A to Z where different letters represent different tasks.Tasks could
 * be done without original order. Each task could be done in one interval. For
 * each interval, CPU could finish one task or just be idle.
 * 
 * However, there is a non-negative cooling interval n that means between two
 * same tasks, there must be at least n intervals that CPU are doing different
 * tasks or just be idle.
 * 
 * You need to return the least number of intervals the CPU will take to finish
 * all the given tasks.
 * 
 * Example 1: Input: tasks = ["A","A","A","B","B","B"], n = 2 Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B. Note: The number of
 * tasks is in the range [1, 10000]. The integer n is in the range [0, 100].
 * 
 * @author skadavath
 *
 */
public class TaskScheduler {
	
	public static void main(String[] args) {
		char[] tasks = new char[]{'A','A','A','B','B','B'};
		System.out.println(new TaskScheduler().leastInterval(tasks, 2));
	}

	public int leastInterval(char[] tasks, int n) {

		int count = 0;

		Map<Character, Integer> tasksMap = new HashMap<Character, Integer>();
		for (char c : tasks) {
			tasksMap.put(c, tasksMap.getOrDefault(c, 0) + 1);
		}
		Queue<Integer> queue = new PriorityQueue<>((i1, i2) -> (i2 - i1));
		for (char c : tasksMap.keySet()) {
			queue.offer(tasksMap.get(c));
		}
		
		 Map<Integer, Integer> coolDown = new HashMap<>();
	        while (!queue.isEmpty() || !coolDown.isEmpty()) {
	            if (coolDown.containsKey(count - n - 1)) {
	                queue.offer(coolDown.remove(count - n - 1));
	            }
	            if (!queue.isEmpty()) {
	                int left = queue.poll() - 1;
	        	if (left != 0) coolDown.put(count, left);
	            }
	            count++;
	        }
	        
	        return count;

	}

}
