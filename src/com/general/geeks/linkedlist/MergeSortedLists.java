package com.general.geeks.linkedlist;

public class MergeSortedLists {
	
	public static void main(String[] args) {
		
		Node l1 = new Node(1);
//		l1.next = new Node(2);
//		l1.next.next = new Node(4);
//		l1.next.next.next = new Node(4);
//		
		Node l2 = new Node(2);
//		l2.next = new Node(4);
//		l2.next.next = new Node(6);
//		l2.next.next.next = new Node(8);
//		
		Node res = merge(l1,l2);
		
		while(res!=null) {
			System.out.println(res.data+" ");
			res = res.next;
		}
	}
	public static Node merge(Node list1,Node list2) {
		
		if (list1 == null) return list2;
		  if (list2 == null) return list1;

		  Node head;
		  if (list1.data < list2.data) {
		    head = list1;
		  } else {
		    head = list2;
		    list2 = list1;
		    list1 = head;
		  }
		  while(list1.next != null) {
		    if (list1.next.data > list2.data) {
		      Node tmp = list1.next;
		      list1.next = list2;
		      list2 = tmp;
		    }
		    list1 = list1.next;
		  } 
		  list1.next = list2;
		  return head;
		  
	}
}
