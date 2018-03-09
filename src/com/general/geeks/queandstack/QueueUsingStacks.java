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
		s1.push(element);
	}
	
	public int get() {
		
		while(!s1.isEmpty()) {
			int ele = s1.pop();
			s2.push(ele);
		}
		
		int pop = s2.pop();
		while(!s2.isEmpty()) {
			push(s2.pop());
		}
		return pop;
		
	}

	
	public static void main(String[] args) {
		QueueUsingStacks q = new QueueUsingStacks();
		q.push(10);
		q.push(20);
		q.push(30);
		
		System.out.println(q.get());
		q.push(100);
		System.out.println(q.get());
		System.out.println(q.get());
		System.out.println(q.get());
	}
}
