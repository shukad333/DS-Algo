package com.general.geeks.linkedlist;

/**
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null.
 * 
 * Note: Do not modify the linked list.
 * 
 * Follow up: Can you solve it without using extra space?
 * 
 * 
 * @author skadavath
 *
 */
public class LinkedListCycle2 {
	
	public static void main(String[] args) {
		Node n1 = new Node(1);
		n1.next = new Node(4);
		n1.next.next = new Node(5);
		n1.next.next.next = n1.next;
		
		System.out.println(new LinkedListCycle2().detectCycle(n1).data);
	}

	public Node detectCycle(Node head) {
		
		Node n1 = head;
		Node n2 = head;
		
		boolean cycle = false;
		while(n1!=null && n2!=null) {
			n1 = n1.next;
			if(n2.next==null)
				return null;
			n2 = n2.next.next;
			if(n1==n2) {
				cycle = true;
				break;
			}
		}
		
		if(!cycle)
			return null;
		n2 = head;
		while(n1!=n2) {
			n1 = n1.next;
			n2 = n2.next;
		}
		return n1;

	}

}
