package com.general.geeks.linkedlist;

import java.util.Stack;

/**
 * You are given two non-empty linked lists representing two non-negative
 * integers. The most significant digit comes first and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Follow up: What if you cannot modify the input lists? In other words,
 * reversing the lists is not allowed.
 * 
 * Example:
 * 
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 8 -> 0 -> 7
 * 
 * @author skadavath
 *
 */
public class AddTwoNumbersII {
	
	public static void main(String[] args) {
		Node n1 = new Node(7);
		n1.next = new Node(2);
		n1.next.next = new Node(4);
		n1.next.next.next = new Node(3);
		
		Node n2 = new Node(5);
		n2.next = new Node(6);
		n2.next.next = new Node(4);
		
		Node resp = new AddTwoNumbersII().addTwoNumbers(n1, n2);
		while(resp!=null) {
			System.out.print(resp.data+" -> ");
			resp = resp.next;
		}
	}

	public Node addTwoNumbers(Node l1, Node l2) {

		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();

		while (l1 != null) {
			s1.push(l1.data);
			l1 = l1.next;
		}

		while (l2 != null) {
			s2.push(l2.data);
			l2 = l2.next;
		}

		Node resp = new Node(0);
		
		int sum = 0;
		while (!s1.isEmpty() || !s2.isEmpty()) {
			if (!s1.isEmpty())
				sum += s1.pop();
			if (!s2.isEmpty())
				sum += s2.pop();
			
			int rem = sum%10;
			resp.data = rem;
			
			Node head = new Node(sum/10);
			head.next = resp;
			resp = head;
			
			sum/=10;
		}
		
		return resp.data==0?resp.next:resp;
	}

}
