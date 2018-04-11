package com.general.geeks.linkedlist;


/*
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortALinkedList {
	
	public static void main(String[] args) {
		
		
		Node node = new Node(1);
		node.next = new Node(14);
		node.next.next = new Node(4);
		node.next.next.next = new Node(3);
		
		printLL(node);
		node = new SortALinkedList().sortList(node);
		printLL(node);
		
	}
	
	private static void printLL(Node node) {
		while(null!=node) {
			System.out.print(node.data);
			node = node.next;
		}
	}
	 public Node sortList(Node head) {
	        
		
		 
		 return mergeSort(head);
	    }
	 
	 private Node mergeSort(Node node) {
		 
		 if(null == node || null == node.next) {
			 return node;
		 }
		 
		 
		 Node middle = getMiddleNode(node);
		 Node nextOfMiddle = middle.next;
		 middle.next = null;
		 
		 Node left = mergeSort(node);
		 Node right = mergeSort(nextOfMiddle);
		 
		 return combine(left, right);
		 
	 }
	 
	 private Node combine(Node n1 , Node n2) {
		 
		 Node result = null;
		 if(null==n1) {
			 return n2;
		 }
		 if(null==n2) {
			 return n1;
		 }
		 
		 if(n1.data<n2.data) {
			 result = n1;
			 result.next = combine(n1.next,n2);
		 }
		 else {
			 result = n2;
			 result.next = combine(n1,n2.next);
		 }
		 
		 return result;
		 
	 }
	 
	 private Node getMiddleNode(Node node) {
		 
		 Node fast = node;
		 Node slow = node;
		 
		 while(null!=fast && null!=fast.next) {
			 
			 slow = slow.next;
			 fast = fast.next.next;
		 }
		 
		 return slow;
		 
	 }
	 
}
