package com.general.geeks.linkedlist;

/**
 * 
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed.

 * 
 * @author skadavath
 *
 */
public class ReverseNodesInKGroup {
	
	public static void main(String[] args) {
		
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);
		
		new ReverseNodesInKGroup().reverseKGroup(node, 2);
		
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		
		int count=0;
		ListNode curr = head;
		while(curr!=null && count!=k) {
			curr = curr.next;
			count++;
		}
		
		if(count==k) {
			
			curr = reverseKGroup(curr, k);
			
			while(count-->0) {
				ListNode temp = head.next;
				head.next = curr;
				curr = head;
				head = temp;
			}
			head = curr;
			
		}
		
		return head;
		
	}
}
