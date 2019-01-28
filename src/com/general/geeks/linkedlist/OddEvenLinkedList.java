package com.general.geeks.linkedlist;

/**
 * Given a singly linked list, group all odd nodes together followed by the even
 * nodes. Please note here we are talking about the node number and not the
 * value in the nodes.
 * 
 * You should try to do it in place. The program should run in O(1) space
 * complexity and O(nodes) time complexity.
 * 
 * Example 1:
 * 
 * Input: 1->2->3->4->5->NULL Output: 1->3->5->2->4->NULL Example 2:
 * 
 * Input: 2->1->3->5->6->4->7->NULL Output: 2->3->6->7->1->5->4->NULL Note:
 * 
 * The relative order inside both the even and odd groups should remain as it
 * was in the input. The first node is considered odd, the second node even and
 * so on ...
 * 
 * @author skadavath
 *
 */
public class OddEvenLinkedList {
	
	public static void main(String[] args) {
		Node node = new Node(1);
		node.next = new Node(2);
		node.next.next = new Node(3);
		node.next.next.next = new Node(4);
		node.next.next.next.next = new Node(5);
		
		Node resp = new OddEvenLinkedList().oddEvenList(node);
		while(resp!=null) {
			System.out.println(resp.data+" ");
			resp = resp.next;
		}
	}

	public Node oddEvenList(Node head) {
		
		Node odd = head;
		Node even = head.next;
		Node evenHead = head.next;
		while(even!=null && even.next!=null) {
			odd.next = odd.next.next;
			even.next = even.next.next;
			odd = odd.next;
			even = even.next;
			
		}
		
		odd.next = evenHead;
		
		return head;

	}

}
