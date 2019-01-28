package com.general.geeks.linkedlist;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * Example 1:
 * 
 * Input: 1->2->3->3->4->4->5 Output: 1->2->5 Example 2:
 * 
 * Input: 1->1->1->2->3 Output: 2->3
 * 
 * @author skadavath
 *
 */
public class RemoveDuplicatesFromSortedListII {

	public static void main(String[] args) {

		Node node = new Node(1);
		node.next = new Node(1);
		node.next.next = new Node(3);
		// node.next.next.next = new Node(3);
		// node.next.next.next.next = new Node(10);
		// node.next.next.next.next.next = new Node(4);
		// node.next.next.next.next.next.next = new Node(5);
		// node.next.next.next.next.next.next.next = new Node(5);

		Node res = new RemoveDuplicatesFromSortedListII().deleteDuplicates(node);
		while (res != null) {
			System.out.print(res.data + " ");
			res = res.next;
		}
	}

	public Node deleteDuplicates(Node head) {

		Node resp = new Node(-1);
		resp.next = head;
		Node curr = head;
		Node prev = resp;

		while (curr != null) {
			while (curr.next != null && curr.next.data == curr.data)
				curr = curr.next;
			if (prev.next == curr)
				prev = prev.next;
			else
				prev.next = curr.next;

			curr = curr.next;

		}
		return resp.next;
	}

}
