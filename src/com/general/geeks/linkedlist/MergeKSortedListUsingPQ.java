package com.general.geeks.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

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
public class MergeKSortedListUsingPQ {
	
	public static void main(String[] args) {
		
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(5);
		
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		
		ListNode l3 = new ListNode(2);
		l3.next = new ListNode(6);
		
		ListNode resp = new MergeKSortedListUsingPQ().mergeKLists(new ListNode[] {l1,l2,l3});
		while(null!=resp) {
			System.out.print(resp.data+"--->");
			resp = resp.next;
		}
		
	}

	public ListNode mergeKLists(ListNode[] lists) {
		
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				
				if(o1.data<o2.data) {
					return -1;
				}
				else if(o1.data == o2.data) {
					return 0;
				}
				else
					return 1;
			}
			
			
			
		});
		
		 ListNode dummy = new ListNode(0);
	        ListNode tail=dummy;
	        
	        for (ListNode node:lists)
	            if (node!=null)
	                queue.add(node);
	            
	        while (!queue.isEmpty()){
	            tail.next=queue.poll();
	            tail=tail.next;
	            
	            if (tail.next!=null)
	                queue.add(tail.next);
	        }
	        return dummy.next;
	    }
	
	
}
