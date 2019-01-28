package com.general.geeks.linkedlist;

/**
 * 
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5
 * 
 * @author skadavath
 *
 */
public class PartitionList {
	
	public static void main(String[] args) {
		
		Node node = new Node(1);
		node.next = new Node(4);
		node.next.next = new Node(3);
		node.next.next.next = new Node(2);
		node.next.next.next.next = new Node(5);
		node.next.next.next.next.next = new Node(2);
		
		Node resp = new PartitionList().partition(node, 3);
		
		while(null!=resp) {
			System.out.println(resp.data+"->");
			resp = resp.next;
		}
		
		
	}

	public Node partition(Node head, int x) {
		
		Node lower = new Node(-1),higher=new Node(-1);
		Node headLower = lower,headHigher = higher;
		
		while(null!=head) {
			
			if(head.data<x) {
				lower.next = new Node(head.data);
				lower = lower.next;
			}
			else {
				higher.next = new Node(head.data);
				higher = higher.next;
			}
			
			head = head.next;
		}
		lower.next = headHigher.next;
		
		return headLower.next;

	}

}
