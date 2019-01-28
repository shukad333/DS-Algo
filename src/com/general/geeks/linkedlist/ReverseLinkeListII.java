package com.general.geeks.linkedlist;

/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 * 
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * 
 * Example:
 * 
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4 Output: 1->4->3->2->5->NULL
 * 
 * @author skadavath
 *
 */
public class ReverseLinkeListII {
	
	public static void main(String[] args) {
		
		Node node = new Node(1);
		node.next = new Node(2);
		node.next.next = new Node(3);
		node.next.next.next = new Node(4);
		node.next.next.next.next = new Node(5);
		
		
		Node res = new ReverseLinkeListII().reverseBetween(node, 2, 4);
		while(res!=null) {
			System.out.println(res.data+" -> ");
			res = res.next;
		}
	}

	public Node reverseBetween(Node head, int m, int n) {
		
		int i=1;
		Node res = new Node(0);
		res.next = head;
		
		Node pre = res;
		while(i++<m)  {
			
			pre = pre.next;
		}
		
		Node start = pre.next;
		Node afterStart = start.next;
		
		i=0;
		while(i++<(n-m)) {
			start.next = afterStart.next;
			afterStart.next = pre.next;
			pre.next = afterStart;
			afterStart = start.next;
		}
		
	
		
		return res.next;

	}

}
