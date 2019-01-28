package com.general.geeks.linkedlist;

/**
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Follow up: Can you solve it without using extra space?
 * 
 * 
 * @author skadavath
 *
 */
public class LinkedListCycle {

	public boolean hasCycle(Node head) {

		Node p1 = head;
		Node p2 = head;

		while (p1 != null && p2 != null) {

			p1 = p1.next;
			if (p2.next == null) {
				return false;
			}
			p2 = p2.next.next;
			if (p1 == p2)
				return true;

		}

		return false;

	}

}
