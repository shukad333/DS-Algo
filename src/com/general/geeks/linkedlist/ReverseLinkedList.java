package com.general.geeks.linkedlist;

public class ReverseLinkedList {
	
	public static void main(String[] args) {
		
		Node node = new Node(1);
		node.next = new Node(2);
		node.next.next = new Node(3);
		node.next.next.next = new Node(4);
		
		node = new ReverseLinkedList().reverseList(node);
		
		while(null!=node) {
			System.out.print(node.data+" ");
			node = node.next;
		}
	}

	public Node reverseList(Node head) {
		
		if(null == head) {
			return null;
		}
		
		Node prev = null;
		Node curr = head;
		Node next = null;
		while(curr!=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			
		}
		
		head = prev;
		return head;

	}

}
