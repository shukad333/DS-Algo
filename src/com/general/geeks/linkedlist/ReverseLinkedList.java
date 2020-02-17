package com.general.geeks.linkedlist;

public class ReverseLinkedList {
	
	public static void main(String[] args) {
		
		Node node = new Node(1);
		node.next = new Node(2);
		node.next.next = new Node(3);
		node.next.next.next = new Node(4);
		
		node = new ReverseLinkedList().reverListRecursive(node,null);
		
		while(null!=node) {
			System.out.print(node.data+" ");
			node = node.next;
		}
	}
	
	private Node reverListRecursive(Node head , Node newHead) {
		
		if(head==null)
			return newHead;
		Node next = head.next;
		head.next = newHead;
		
		return reverListRecursive(next, head);
		
		
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
