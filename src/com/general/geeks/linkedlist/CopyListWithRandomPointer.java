package com.general.geeks.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 * 
 * @author skadavath
 *
 */
public class CopyListWithRandomPointer {

	public RandomListNode copyRandomList(RandomListNode head) {
		
		
		Map<RandomListNode, RandomListNode> map = new HashMap<>();
		
		RandomListNode node = head;
		
		while(null!=node) {
			map.put(node, new RandomListNode(node.label));
			node = node.next;
		}
		
		node = head;
		while(null!=node) {
			map.get(node).next = map.get(node.next);
			map.get(node).random = map.get(node.random);
			node = node.next;
		}
		return map.get(head);

	}

}


 
 class RandomListNode {
     int label;
     RandomListNode next, random;
     RandomListNode(int x) { this.label = x; }
 };
 
