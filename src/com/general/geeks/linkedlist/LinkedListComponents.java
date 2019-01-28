package com.general.geeks.linkedlist;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * We are given head, the head node of a linked list containing unique integer
 * values.
 * 
 * We are also given the list G, a subset of the values in the linked list.
 * 
 * Return the number of connected components in G, where two values are
 * connected if they appear consecutively in the linked list.
 * 
 * Example 1:
 * 
 * Input: head: 0->1->2->3 G = [0, 1, 3] Output: 2 Explanation: 0 and 1 are
 * connected, so [0, 1] and [3] are the two connected components. Example 2:
 * 
 * Input: head: 0->1->2->3->4 G = [0, 3, 1, 4] Output: 2 Explanation: 0 and 1
 * are connected, 3 and 4 are connected, so [0, 1] and [3, 4] are the two
 * connected components. Note:
 * 
 * If N is the length of the linked list given by head, 1 <= N <= 10000. The
 * value of each node in the linked list will be in the range [0, N - 1]. 1 <=
 * G.length <= 10000. G is a subset of all values in the linked list.
 * 
 * @author skadavath
 *
 */
public class LinkedListComponents {

	public static void main(String[] args) {

		Node node = new Node(0);
		node.next = new Node(1);
		node.next.next = new Node(2);
		node.next.next.next = new Node(3);
		node.next.next.next.next = new Node(4);

		System.out.println(new LinkedListComponents().numComponents(node, new int[] { 3, 1, 0, 4 }));

	}

	public int numComponents(Node head, int[] G) {

		int count = 0;
		Set<Integer> set = new HashSet<>();
		for (int i : G)
			set.add(i);

		boolean prev = false;
		while (head != null) {
			int data = head.data;
			if (!set.contains(data)) {

				prev = false;
			} else {
				set.remove(data);
				if (!prev)
					count++;
				prev = true;
			}
			head = head.next;

		}
		return count;

	}

}
