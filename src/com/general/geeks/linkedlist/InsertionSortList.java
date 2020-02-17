package com.general.geeks.linkedlist;

/**
 * A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list
 

Algorithm of Insertion Sort:

Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
It repeats until no input elements remain.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5

 * @author skadavath
 *
 */
public class InsertionSortList {
	
	public static void main(String[] args) {
		
		Node node = new Node(4);
		node.next = new Node(2);
		node.next.next = new Node(1);
		node.next.next.next = new Node(3);
		
		Node ressp = new InsertionSortList().insertionSortList(node);
		
		while(null!=ressp) {
			System.out.println(ressp.data+"---->");
			ressp = ressp.next;
		}
		
		
	}
	
	public Node insertionSortList(Node head) {
		
		Node resp = new Node(0);
		
		Node curr = head;
		
		Node next = null;
		Node pre = resp;
		
		while(null!=curr) {
			
			next = curr.next;
			
			while(null!=pre.next && curr.data>pre.next.data) {
				
				pre = pre.next;
			}
			
			//insert between pre and pre.next
			curr.next = pre.next;
			pre.next = curr;
			pre = resp;
			curr = next;
			
		}
		
		return resp.next;

	}

}
