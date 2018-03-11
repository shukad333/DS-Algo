package com.general.geeks.linkedlist;

public class RotateList {
	
	public static void main(String[] args) {
		
		/*
		 * 1->2->3->4->5->NULL
		 * first find kth node from end
		 */
		
		Node node = new Node(1);
		node.next = new Node(2);
		node.next.next = new Node(3);
//		node.next.next.next = new Node(25);
//		node.next.next.next.next = new Node(30);
//		
		RotateList rl = new RotateList();
		rl.printLL(node);
		System.out.println();
		node = rl.rotateRight(node, 3);

		rl.printLL(node);
		
	}
	
	public Node rotateRight(Node head , int k) {
		
		 if(null==head || k==0)
	            return head;

		Node current = head;
		
		//first find kth node
		
		int length = 0;
		
		while(current!=null) {
			length++;
			current = current.next;
		}
		
		if(k==length)
			return head;
		

		k = k>length?(k%length):k;
		
		System.out.println("length is "+length);
		
		current = head;



		for(int i=1;i<(length-k+1);i++) {

			current = current.next;
		}
		
		Node res = current;
		while(current.next!=null) {
			current = current.next;
		}
		current.next = head;
		head = res.next;
		res.next = null;
		
		return head;
	}
	
	public void printLL(Node node) {
		while(node!=null) {
			System.out.print(node.data+" -> ");
			node = node.next;
		}
	}
}