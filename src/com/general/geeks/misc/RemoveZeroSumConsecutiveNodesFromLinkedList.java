package com.general.geeks.misc;

import java.util.HashMap;
import java.util.Map;

import com.general.geeks.linkedlist.ListNode;

/**
 * 
 * Given the head of a linked list, we repeatedly delete consecutive sequences of nodes that sum to 0 until there are no such sequences.

After doing so, return the head of the final linked list.  You may return any such answer.

 

(Note that in the examples below, all sequences are serializations of ListNode objects.)

Example 1:

Input: head = [1,2,-3,3,1]
Output: [3,1]
Note: The answer [1,2,1] would also be accepted.
Example 2:

Input: head = [1,2,3,-3,4]
Output: [1,2,4]
Example 3:

Input: head = [1,2,3,-3,-2]
Output: [1]
 

Constraints:

The given linked list will contain between 1 and 1000 nodes.
Each node in the linked list has -1000 <= node.val <= 1000.
 * 
 * @author skadavath
 *
 */
public class RemoveZeroSumConsecutiveNodesFromLinkedList {
	
	public static void main(String[] args) {
		
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(-3);
		node.next.next.next = new ListNode(3);
		node.next.next.next.next = new ListNode(1);
		
		ListNode resp = new RemoveZeroSumConsecutiveNodesFromLinkedList().removeZeroSumSublists(node);
		while(resp!=null) {
			System.out.println(resp.data+" -> ");
			resp = resp.next;
		}
		
		
	}

public ListNode removeZeroSumSublists(ListNode head) {
		
		ListNode dummy = new ListNode(0),curr=dummy;
		dummy.next = head;
		Map<Integer, ListNode> prefixMap = new HashMap<>();
		int preSum = 0;
		while(curr!=null) {
			
			preSum += curr.data;
			if(prefixMap.containsKey(preSum)) {
				
				curr = prefixMap.get(preSum).next;
				int p = preSum+curr.data;
				while(p!=preSum) {
					prefixMap.remove(p);
					curr = curr.next;
					p += curr.data;
				}
				prefixMap.get(preSum).next = curr.next;
				
			}
			else 
                prefixMap.put(preSum, curr);
			curr = curr.next;
			
		}
		
		return dummy.next;

	}

}
