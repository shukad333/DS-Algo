package com.general.geeks.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * You have a lock in front of you with 4 circular wheels. Each wheel has 10
 * slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can
 * rotate freely and wrap around: for example we can turn '9' to be '0', or '0'
 * to be '9'. Each move consists of turning one wheel one slot.
 * 
 * The lock initially starts at '0000', a string representing the state of the 4
 * wheels.
 * 
 * You are given a list of deadends dead ends, meaning if the lock displays any
 * of these codes, the wheels of the lock will stop turning and you will be
 * unable to open it.
 * 
 * Given a target representing the value of the wheels that will unlock the
 * lock, return the minimum total number of turns required to open the lock, or
 * -1 if it is impossible.
 * 
 * Example 1: Input: deadends = ["0201","0101","0102","1212","2002"], target =
 * "0202" Output: 6 Explanation: A sequence of valid moves would be "0000" ->
 * "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202". Note that a
 * sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be
 * invalid, because the wheels of the lock become stuck after the display
 * becomes the dead end "0102". Example 2: Input: deadends = ["8888"], target =
 * "0009" Output: 1 Explanation: We can turn the last wheel in reverse to move
 * from "0000" -> "0009". Example 3: Input: deadends =
 * ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * Output: -1 Explanation: We can't reach the target without getting stuck.
 * Example 4: Input: deadends = ["0000"], target = "8888" Output: -1
 * 
 * @author skadavath
 *
 */
public class OpenTheLock {
	
	public static void main(String[] args) {
		System.out.println(new OpenTheLock().openLock(new String[] {"8888"}, "0009"));
	}
	
	public int openLock(String[] deadends, String target) {
		
		Queue<String> queue = new LinkedList();
		queue.offer("0000");
		Set<String> deadSet = new HashSet(Arrays.asList(deadends));
		Set<String> visited = new HashSet();
		visited.add("0000");
		if(deadSet.contains(queue.peek())) {
			return -1;
		}
		
		int level = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size>0) {
				
				String currentLock = queue.poll();
				if(deadSet.contains(currentLock)) {
					size--;
					continue;
				}
				
				
				if(currentLock.equals(target)) return level;
				
				
				StringBuilder sb = new StringBuilder(currentLock);
				for(int i=0;i<4;i++) {
					char c = sb.charAt(i);
					String newLockForward = sb.substring(0, i)+(c=='9'?0:c-'0'+1)+sb.substring(i+1);
					String newLockBackward = sb.substring(0, i)+(c=='0'?9:c-'0'-1)+sb.substring(i+1);
					if(!visited.contains(newLockForward) && !deadSet.contains(newLockForward)) {
						visited.add(newLockForward);
						queue.add(newLockForward);
					}
					
					if(!visited.contains(newLockBackward) && !deadSet.contains(newLockBackward)) {
						visited.add(newLockBackward);
						queue.add(newLockBackward);
					}
					
				}
				size--;
			}
			level++;
		}
		return -1;
	}

}
