package com.general.geeks.linkedlist;

public class RemoveDuplicatesFromSortedList {
	
	public static void main(String[] args) {
		
		Node node = new Node(1);
		node.next = new Node(1);
		node.next.next = new Node(1);
//		node.next.next.next = new Node(2);
//		node.next.next.next.next = new Node(3);
//		
		node = new RemoveDuplicatesFromSortedList().deleteDuplicates(node);
		while(node!=null) {
			System.out.print(node.data+" -> ");
			node = node.next;
		}
	}

	public Node deleteDuplicates(Node head) {
		
		Node prev = head;
		Node curr = head;
		curr = curr.next;
		while(curr!=null) {
			if(curr.data!=head.data) {
				head.next = curr;
				head = head.next;
			}
			
			curr = curr.next;
		}
		head.next = null;
		return prev;
	}

}
