package com.general.geeks.linkedlist;

import java.util.Stack;

public class PallindromeLL {
	
	public static void main(String[] args) {
		
		LinkedList list = new LinkedList(100);
		list.push(90);
		list.push(80);
		list.push(70);
		list.push(60);
		list.push(60);
		list.push(70);
		list.push(80);
		list.push(90);
		list.push(100);
		
		list.print();
		if(checkIfPallindrome(list))
			System.out.println("Pallindrome");
		else
			System.out.println("Not pallindome");
	}
	
	static boolean checkIfPallindrome(LinkedList list) {
		Stack<Integer> stack = new Stack<>();
		Node current = list.getHead();
		while(current!=null) {
			stack.push(current.data);
			current = current.next;
		}
		current = list.getHead();
		while(current!=null) {
			if(stack.pop()!=current.data)
				return false;
			
			current = current.next;
		}
		
		return true;
	}

}
