package com.general.geeks.linkedlist;


/*
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortALinkedList {
	
	public static void main(String[] args) {
		
		
//		Node node = new Node(1);
//		node.next = new Node(14);
//		node.next.next = new Node(4);
//		node.next.next.next = new Node(3);
//		
//		printLL(node);
//		node = new SortALinkedList().sortList(node);
//		System.out.println();
//		printLL(node);
		
	}
	
	private static void printLL(Node node) {
		while(null!=node) {
			System.out.print(node.data+" ");
			node = node.next;
		}
	}
	//merge two sorted list, return result head
    public ListNode merge(ListNode h1, ListNode h2){
        if(h1 == null){
            return h2;
        }
        if(h2 == null){
            return h1;
        }
        
        if(h1.data < h2.data){
            h1.next = merge(h1.next, h2);
            return h1;
        }
        else{
            h2.next = merge(h1, h2.next);
            return h2;
        }
        
    }
    
    public ListNode sortList(ListNode head) {
        //bottom case
        if(head == null){
            return head;
        }
        if(head.next == null){
            return head;
        }
        
        //p1 move 1 step every time, p2 move 2 step every time, pre record node before p1
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode pre = head;
        
        while(p2 != null && p2.next != null){
            pre = p1;
            p1 = p1.next;
            p2 = p2.next.next;
        }
        //change pre next to null, make two sub list(head to pre, p1 to p2)
        pre.next = null;
        
        //handle those two sub list
        ListNode h1 = sortList(head);
        ListNode h2 = sortList(p1);
        
        return merge(h1, h2);
        
    }
    
}
