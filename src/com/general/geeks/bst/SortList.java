package com.general.geeks.bst;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5

 * 
 * @author skadavath
 *
 */
public class SortList {
	
	public ListNode sortList(ListNode head) {
		
		ListNode slow=head,fast=head,prev=null;
		
		while(slow!=null && fast.next!=null) {
			
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		prev.next = null;
		
		ListNode left = sortList(head);
		ListNode right = sortList(slow);
		
		return merge(left,right);
		
		
	}
	
	private ListNode merge(ListNode l1,ListNode l2) {
		
		ListNode resp = new ListNode(0),p=resp;
		
		while(l1!=null && l2!=null) {
			if(l1.val<l2.val) {
			p.next = new ListNode(l1.val);
			l1 = l1.next;
		}
			else {
				p.next = new ListNode(l2.val);
				l2 = l2.next;
			}
		p = p.next;
		}
		
		if(l1!=null)
			p.next = l1;
		if(l2!=null)
			p.next = l2;
		
		return resp.next;
	}

}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		this.val = x;
		
	}
}
