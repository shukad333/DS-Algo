package com.general.geeks.linkedlist;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * Example:
 * 
 * Given 1->2->3->4, you should return the list as 2->1->4->3. Note:
 * 
 * Your algorithm should use only constant extra space. You may not modify the
 * values in the list's nodes, only nodes itself may be changed.
 * 
 * @author skadavath
 *
 */
public class SwapNodes {
	
	public static void main(String[] args) {
		
		Node node = new Node(1);
		node.next = new Node(2);
		node.next.next = new Node(3);
		node.next.next.next = new Node(4);
		
		node = new SwapNodes().swapPairs(node);
		while(node!=null) {
			System.out.print(node.data+" -> ");
			node = node.next;
		}
		
	}

	public Node swapPairs(Node head) {
		
		Node node = head;
		
		while(node!=null && node.next!=null) {
			
			int temp = node.data;
			node.data = node.next.data;
			node.next.data = temp;
			node = node.next.next;
			
		}
		
		return head;

	}

}
