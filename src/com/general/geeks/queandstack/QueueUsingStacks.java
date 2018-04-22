package com.general.geeks.queandstack;

import java.util.Queue;
import java.util.Stack;

/*
 * This is the queue using two stacks
 */
public class QueueUsingStacks {

	Stack<Integer> s1 = new Stack();
	Stack<Integer> s2 = new Stack();

	public void push(int element) {
		while(!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		s1.push(element);
		while(!s2.isEmpty()) {
			s1.push(s2.pop());
		}
	}
	
	public int pop() {
		
		return s1.pop();
		
	}
	
	public int peek() {
		return s1.peek();
	}
	
	public boolean empty() {
		return s1.isEmpty();
	}

	
	public static void main(String[] args) {
		QueueUsingStacks q = new QueueUsingStacks();
		q.push(10);
		q.push(20);
		q.push(30);
		
		System.out.println(q.pop());
		System.out.println(q.peek());
		q.push(100);
		System.out.println(q.pop());
		System.out.println(q.pop());
		System.out.println(q.pop());
	}
}
