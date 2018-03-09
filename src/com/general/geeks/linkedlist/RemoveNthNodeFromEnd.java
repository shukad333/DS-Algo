package com.general.geeks.linkedlist;

public class RemoveNthNodeFromEnd {
	
	public static void main(String[] args) {
		
		
		Node ll = new Node(1);
		ll.next = new Node(2);
		ll.next.next = new Node(3);
		ll.next.next.next = new Node(4);
		ll.next.next.next.next = new Node(5);
		ll.next.next.next.next.next = new Node(6);
		ll.next.next.next.next.next.next = new Node(7);
		
		Node res = removeNthFromEnd(ll,2);
		while(res!=null) {
			System.out.println(res.data+" ");
			res = res.next;
		}
		
		
		
	}
	
	private static Node removeNthFromEnd(Node ll,int n) {
		Node head = ll;
		int length = length(ll);
		System.out.println("length is "+length);
		for(int i=1;i<(length-n);i++) {
			ll = ll.next;
		}
		
		ll.next = ll.next.next;
		return head;
	}
	
	private static int length(Node ll) {
		int len = 0;
		while(ll!=null) {
			len++;
			ll = ll.next;
		}
		
		return len;
	}
	
}
