package com.general.geeks.misc;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Your car starts at position 0 and speed +1 on an infinite number line. (Your
 * car can go into negative positions.)
 * 
 * Your car drives automatically according to a sequence of instructions A
 * (accelerate) and R (reverse).
 * 
 * When you get an instruction "A", your car does the following: position +=
 * speed, speed *= 2.
 * 
 * When you get an instruction "R", your car does the following: if your speed
 * is positive then speed = -1 , otherwise speed = 1. (Your position stays the
 * same.)
 * 
 * For example, after commands "AAR", your car goes to positions 0->1->3->3, and
 * your speed goes to 1->2->4->-1.
 * 
 * Now for some target position, say the length of the shortest sequence of
 * instructions to get there.
 * 
 * Example 1: Input: target = 3 Output: 2 Explanation: The shortest instruction
 * sequence is "AA". Your position goes from 0->1->3. Example 2: Input: target =
 * 6 Output: 5 Explanation: The shortest instruction sequence is "AAARA". Your
 * position goes from 0->1->3->7->7->6.
 * 
 * @author skadavath
 *
 */
public class RaceCars {
	
	public static void main(String[] args) {
		System.out.println(new RaceCars().racecar(3));
	}

	class Node {

		int pos;
		int speed;

		public Node(int pos, int speed) {
			this.pos = pos;
			this.speed = speed;
		}

		public String serial() {
			return pos + "," + speed;
		}

	}

	public int racecar(int target) {
		Queue<Node> queue = new LinkedList<>();
		Set<String> visited = new HashSet<>();
		Node start = new Node(0, 1);
		queue.add(start);
		visited.add(start.serial());

		int level = 0;
		while (!queue.isEmpty()) {
			int sz = queue.size();
			for (int i = 0; i < sz; i++) {
				Node cur = queue.poll();
				if (cur.pos == target) {
					return level;
				}
				Node neighbour1 = new Node(cur.pos + cur.speed, cur.speed * 2);
				if (!visited.contains(neighbour1.serial()) && Math.abs(neighbour1.pos - target) < target) {
					visited.add(neighbour1.serial());
					queue.add(neighbour1);
				}
				Node neighbour2 = new Node(cur.pos, cur.speed > 0 ? -1 : 1);
				if (!visited.contains(neighbour2.serial()) && Math.abs(neighbour2.pos - target) < target) {
					visited.add(neighbour2.serial());
					queue.add(neighbour2);
				}
			}
			level++;
		}
		return -1;
	}

}
