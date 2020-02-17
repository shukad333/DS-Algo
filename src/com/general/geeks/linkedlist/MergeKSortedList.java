package com.general.geeks.linkedlist;

/**
 * 
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * Example:
 * 
 * Input: [ 1->4->5, 1->3->4, 2->6 ] Output: 1->1->2->3->4->4->5->6
 * 
 * 
 * @author skadavath
 *
 */
public class MergeKSortedList {
	
	public static void main(String[] args) {
		
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(5);
		
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		
		ListNode l3 = new ListNode(2);
		l3.next = new ListNode(6);
		
		ListNode resp = new MergeKSortedList().mergeKLists(new ListNode[] {l1,l2,l3});
		while(null!=resp) {
			System.out.print(resp.data+"--->");
			resp = resp.next;
		}
		
	}

	public ListNode mergeKLists(ListNode[] lists) {
		
		return partition(lists, 0, lists.length-1);

	}
	
	private ListNode partition(ListNode[] lists,int start,int end) {
		
		if(start==end)
			return lists[start];
		
		if(start<end) {
			
			int mid = (start+end)>>1;
			ListNode l1 = partition(lists, start, mid);
			ListNode l2 = partition(lists, mid+1, end);
			
			return merge(l1, l2);
		}
		else
			return null;
		
	}
	
	private ListNode merge(ListNode l1,ListNode l2) {
		
		if(null==l1)
			return l2;
		if(null==l2)
			return l1;
		
		if(l1.data<l2.data) {
			l1.next = merge(l1.next, l2);
			return l1;
		}
		else  {
			l2.next = merge(l1, l2.next);
			return l2;
		}
		
	}

}
