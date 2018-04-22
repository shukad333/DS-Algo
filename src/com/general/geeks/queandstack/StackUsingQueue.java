package com.general.geeks.queandstack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
	
	Queue<Integer> queue1 = new LinkedList();
	Queue<Integer> queue2 = new LinkedList();
	
	public static void main(String[] args) {
		
		StackUsingQueue stack = new StackUsingQueue();
		stack.push(4);
		stack.push(6);
		stack.push(10);
		
		System.out.println(stack.empty());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
	
	public void push(int x) {
	
		while(!queue1.isEmpty()) {
			queue2.add(queue1.poll());
		}
		queue1.add(x);
		while(!queue2.isEmpty()) {
			queue1.add(queue2.poll());
		}
		
	}
	
	public int pop() {
		return queue1.poll();
	}
	
	public int top() {
		return queue1.peek();
	}
	
	public boolean empty() {
		return queue1.isEmpty();
	}
}
