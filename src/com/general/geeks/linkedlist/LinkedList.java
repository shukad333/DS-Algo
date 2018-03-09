package com.general.geeks.linkedlist;

public class LinkedList {

	private Node head;

	public LinkedList(int data) {
		Node node = new Node(data);
		this.head = node;

	}

	public void push(int data) {
		Node node = new Node(data);
		node.next = head;
		head = node;
	}
	
	public void print() {
		Node n = head;
		while(null!=n) {
			System.out.print(n.data+"\t");
			n = n.next;
		}
	}
	
	public Node getHead() {
		return head;
	}
	public static void main(String[] args) {
		
		LinkedList list = new LinkedList(100);
		list.push(90);
		list.push(80);
		list.push(70);
		list.push(60);
		
		list.print();
	}
}
