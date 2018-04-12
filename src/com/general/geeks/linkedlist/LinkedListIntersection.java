package com.general.geeks.linkedlist;

public class LinkedListIntersection {
	
	public static void main(String[] args) {
		
		
		Node headA = new Node(1);
		headA.next = new Node(2);
		headA.next.next = new Node(3);
		
		Node headB = new Node(10);
		headB.next = headA.next;
		
		System.out.println(new LinkedListIntersection().getIntersectionNode(headA, headB).data);
	}
	
public Node getIntersectionNode(Node headA, Node headB) {
        
		if(null == headA || null == headB) {
			return null;
		}
		
		int lenA =0,lenB=0;
		Node temp = headA;
		while(temp!=null) {
			temp = temp.next;
			lenA++;
		}
		
		temp = headB;
		while(temp!=null) {
			temp = temp.next;
			lenB++;
		}
		
		if(lenA>lenB) {
			for(int i=0;i<Math.abs(lenA-lenB);i++) {
				headA = headA.next;
			}
		}
		else {
			for(int i=0;i<Math.abs(lenA-lenB);i++) {
				headB = headB.next;
			}
		}
		
		while(headA!=null && headB!=null) {
			if(headA==headB) {
				return headA;
			}
			headA = headA.next;
			headB = headB.next;
		}
		
		return null;
		
		
    }
}
