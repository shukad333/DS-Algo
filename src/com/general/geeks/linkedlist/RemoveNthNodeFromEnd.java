package com.general.geeks.linkedlist;

public class RemoveNthNodeFromEnd {
	
	public static void main(String[] args) {
		
		
		Node ll = new Node(1);
//		ll.next = new Node(2);
//		ll.next.next = new Node(3);
//		ll.next.next.next = new Node(4);
//		ll.next.next.next.next = new Node(5);
//		ll.next.next.next.next.next = new Node(6);
//		ll.next.next.next.next.next.next = new Node(7);
//		
		Node res = removeNthFromEnd(ll,1);
		while(res!=null) {
			System.out.println(res.data+" ");
			res = res.next;
		}
		
		
		
	}
	
	private static Node removeNthFromEnd(Node head,int n) {
		Node start = new Node(0);
		Node slow = start, fast = start;
	    slow.next = head;
	    
	    //Move fast in front so that the gap between slow and fast becomes n
	    for(int i=1; i<=n+1; i++)   {
	        fast = fast.next;
	    }
	    //Move fast to the end, maintaining the gap
	    while(fast != null) {
	        slow = slow.next;
	        fast = fast.next;
	    }
	    //Skip the desired node
	    slow.next = slow.next.next;
	    return start.next;
	}
	
}
