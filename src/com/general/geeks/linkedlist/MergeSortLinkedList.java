package com.general.geeks.linkedlist;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * Example 1:
 * 
 * Input: 4->2->1->3 Output: 1->2->3->4 Example 2:
 * 
 * Input: -1->5->3->4->0 Output: -1->0->3->4->5
 * 
 * @author skadavath
 *
 */
public class MergeSortLinkedList {
	
	public static void main(String[] args) {
		
		Node n = new Node(1);
		n.next = new Node(10);
		n.next.next = new Node(7);
		n.next.next.next = new Node(2);
		n.next.next.next.next = new Node(4);
		
		Node res = new MergeSortLinkedList().sortList(n);
		
		while(res!=null) {
			System.out.print(res.data+" ");
			res = res.next;
		}
		
	}

	public Node sortList(Node head) {
		
		if(null==head || null==head.next)
			return head;
		
		Node slow = head;
		Node fast = head;
		Node prev = null;
		while(null!=fast && null!=fast.next) {
			prev = slow;
			fast = fast.next.next;
			slow = slow.next;
		}
		
	
		//split the two halves
		
		
		prev.next = null;
		
		Node left = sortList(head);
		Node right = sortList(slow);
		
		Node res = mergeSort(left, right);
		
		return res;

	}
	
	private Node mergeSort(Node l1,Node l2) {
		Node res = new Node(0);
		Node l = res;//for iteration and filling
		
		while(l1!=null && l2!=null) {
			if(l1.data<l2.data) {
				l.next = l1;
				l1 = l1.next;
			}
			else {
				l.next = l2;
				l2 = l2.next;
			}
			l = l.next;
		}
		
		//See if remaining
		
		if(l1!=null) {
			l.next = l1;
		}
		if(l2!=null) {
			l.next = l2;
		}
		
		return res.next;
	}
	
	private Node getMiddle(Node node) {
		if(null==node)
			return node;
		Node slow = node;
		Node fast = node;
		while(null!=fast && null!=fast.next) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return slow;
	}

}
