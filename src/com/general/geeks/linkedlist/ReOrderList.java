package com.general.geeks.linkedlist;

public class ReOrderList {
	
	public static void main(String[] args) {
		
		Node node = new Node(10);
		node.next = new Node(20);
		node.next.next = new Node(30);
		node.next.next.next = new Node(40);
	}
	
public void reorderList(Node head) {
		
        if (null==head || null==head.next)
            return;
		//find the middle of the list
		
        Node l1 = head;
        Node l2 = head;
		
		while(null!=l2.next && null!=l2.next.next) {
			
			l1 = l1.next;
			l2 = l2.next.next;
			
		}
		
		//Reverse second half , l1 is the middle
		
		Node currentHead = l1;
		l2 = l1.next;
		
		while(null!=l2.next) {
			
			Node curr = l2.next;
			l2.next = curr.next;
			curr.next = currentHead.next;
			currentHead.next = curr;
		}
		
		l1 = head;
		l2 = currentHead.next;
		
		while(l1!=currentHead) {
		 currentHead.next = l2.next;
		 l2.next = l1.next;
		 l1.next = l2;
		 l1 = l2.next;
		 l2 = currentHead.next;
		}
	}
}