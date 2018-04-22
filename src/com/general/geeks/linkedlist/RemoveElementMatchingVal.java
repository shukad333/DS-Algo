package com.general.geeks.linkedlist;

/**
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6 Return: 1 --> 2
 * --> 3 --> 4 --> 5
 * 
 * 
 * @author skadavath
 *
 */
public class RemoveElementMatchingVal {
	
	public static void main(String[] args) {
		
		Node node = new Node(1);
		node.next = new Node(1);
//		node.next.next = new Node(3);
//		node.next.next.next = new Node(4);
//		node.next.next.next.next = new Node(5);
//		
		node = new RemoveElementMatchingVal().removeElements(node, 1);
		while(node!=null) {
			System.out.print(node.data+" ");
			node = node.next;
		}
	}
	
	public Node removeElements(Node head, int val) {
		
		Node helper = new Node(0);
		helper.next = head;
		Node p = helper;
		
		while(p.next!=null) {
			if(p.next.data == val) {
				Node next = p.next;
				p.next = next.next;
			}
			else {
				p = p.next;
			}
		}
		return helper.next;
		
	}

}
